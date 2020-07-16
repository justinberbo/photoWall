package cn.codeeyes.mojito.service.impl;


import cn.codeeyes.mojito.common.CommonError;
import cn.codeeyes.mojito.common.RedisConstant;
import cn.codeeyes.mojito.common.SysException;
import cn.codeeyes.mojito.mapper.UserMapper;
import cn.codeeyes.mojito.model.dto.LoginDTO;
import cn.codeeyes.mojito.model.dto.RegisterDTO;
import cn.codeeyes.mojito.model.dto.UserDTO;
import cn.codeeyes.mojito.model.entity.UserDO;
import cn.codeeyes.mojito.service.UserService;
import cn.codeeyes.mojito.util.RedisUtil;
import com.alibaba.fastjson.JSONObject;
import javax.annotation.Resource;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
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


  @Override
  public void register(RegisterDTO registerDTO) {
    UserDO userDO = new UserDO();
    //md5
    String password = DigestUtils.md5DigestAsHex(registerDTO.getPassword().getBytes());
    userDO.setEmail(registerDTO.getEmail());
    userDO.setPassword(password);
    //发送邮件

    userMapper.insert(userDO);
  }

  @Override
  public UserDTO login(LoginDTO loginDTO, HttpServletRequest request) throws SysException {

    String loginIp=request.getRemoteAddr();

    UserDO userDO = userMapper.findByEamil(loginDTO.getEmail());
    UserDTO userDTO = new UserDTO();
    if (null == userDO) {
      throw new SysException(CommonError.USER_NO_FIND);
    }
    String password = DigestUtils.md5DigestAsHex(loginDTO.getPassword().getBytes());
    if (password.equals(userDO.getPassword())) {
      BeanUtils.copyProperties(userDO, userDTO);
      userDTO.setIp(loginIp);
      redisUtil.set(RedisConstant.USER_LOGIN_FLAG+userDO.getId(),userDTO.toString());
    } else {
      throw new SysException(CommonError.USER_PWD_ERROR);
    }
    return userDTO;
  }
}