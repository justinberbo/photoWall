package cn.codeeyes.mojito.service.impl;


import cn.codeeyes.mojito.common.CommonError;
import cn.codeeyes.mojito.common.RedisConstant;
import cn.codeeyes.mojito.common.SysException;
import cn.codeeyes.mojito.mapper.UserMapper;
import cn.codeeyes.mojito.model.dto.LoginDTO;
import cn.codeeyes.mojito.model.dto.ModifyUserDTO;
import cn.codeeyes.mojito.model.dto.RegisterDTO;
import cn.codeeyes.mojito.model.dto.UserDTO;
import cn.codeeyes.mojito.model.entity.UserDO;
import cn.codeeyes.mojito.service.UserService;
import cn.codeeyes.mojito.util.RandomUtil;
import cn.codeeyes.mojito.util.RedisUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import java.util.Random;
import java.util.UUID;
import javax.annotation.Resource;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

/**
 * @author codeeyes.cn
 */
@Service
public class UserServiceImpl implements UserService {

  @Resource
  UserMapper userMapper;

  @Autowired
  private RedisUtil redisUtil;
  /**
   * 两天
   */
  private final long LOGIN_TIME_OUT=86400L;


  @Override
  public UUID register(RegisterDTO registerDTO) throws SysException{
    UserDO userDO = userMapper.findByEmail(registerDTO.getEmail());
    if(null!=userDO){
      throw new SysException(CommonError.EMAIL_IS_REGISTER);
    }



    //md5
    String password = DigestUtils.md5DigestAsHex(registerDTO.getPassword().getBytes());
    userDO=new UserDO();
    userDO.setEmail(registerDTO.getEmail());
    userDO.setPassword(password);
    //发送邮件
    userMapper.insert(userDO);

    UUID uid=UUID.randomUUID();
    UserDTO userDTO=new UserDTO();
    BeanUtils.copyProperties(userMapper.findByEmail(userDO.getEmail()), userDTO);
    redisUtil.set(RedisConstant.USER_LOGIN_FLAG+uid,JSON.toJSON(userDTO).toString(),LOGIN_TIME_OUT);

    return uid;

  }

  @Override
  public UserDTO login(LoginDTO loginDTO, HttpServletRequest request) throws SysException {

    String loginIp=request.getRemoteAddr();

    UserDO userDO = userMapper.findByEmail(loginDTO.getEmail());
    UserDTO userDTO = new UserDTO();
    if (null == userDO) {
      throw new SysException(CommonError.USER_NO_FIND);
    }
    String password = DigestUtils.md5DigestAsHex(loginDTO.getPassword().getBytes());
    if (password.equals(userDO.getPassword())) {
      UUID uuid=UUID.randomUUID();
      BeanUtils.copyProperties(userDO, userDTO);
      userDTO.setIp(loginIp);
      userDTO.setUuid(uuid);

      redisUtil.set(RedisConstant.USER_LOGIN_FLAG+uuid,JSON.toJSON(userDTO).toString(),LOGIN_TIME_OUT);
    } else {
      throw new SysException(CommonError.USER_PWD_ERROR);
    }
    return userDTO;
  }

  @Override
  public UserDTO queryUser(String uuid) throws SysException{
    UserDTO user=new UserDTO();

    Object userJson=redisUtil.get(RedisConstant.USER_LOGIN_FLAG+uuid);
    if (null!=userJson){
       user=JSON.parseObject(userJson.toString(),UserDTO.class);
    }else {
      throw new SysException(CommonError.UUID_NO_FIND);
    }
    return user;
  }

  @Override
  public void modify(ModifyUserDTO modifyDTO) {
    UserDO userDO=new UserDO();
    userDO.setId(modifyDTO.getId());
    userDO.setEmail(modifyDTO.getEmail());
    userDO.setNickName(modifyDTO.getNikeName());
    userDO.setMobile(modifyDTO.getMobile());
    userMapper.update(userDO);
  }

  @Override
  public void addCount() {
    Object redisObj=redisUtil.get(RedisConstant.COUNT);
    Integer count=0;
    if (null!=redisObj) {
      count = Integer.parseInt(redisObj.toString())+1;
      redisUtil.del(RedisConstant.COUNT);
      redisUtil.set(RedisConstant.COUNT,count.toString());
    }
  }

  @Override
  public Integer getCount() {
    Integer count=0;
    Object redisObj=redisUtil.get(RedisConstant.COUNT);
    if (null!=redisObj) {
      count= Integer.parseInt(redisObj.toString());
    }
    return count;
  }
}