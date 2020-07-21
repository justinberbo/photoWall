package cn.codeeyes.mojito.service;


import cn.codeeyes.mojito.model.dto.LoginDTO;
import cn.codeeyes.mojito.model.dto.ModifyUserDTO;
import cn.codeeyes.mojito.model.dto.RegisterDTO;
import cn.codeeyes.mojito.model.dto.UserDTO;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

/**
 * @author codeeyes.cn
 */
@Service
public interface UserService {

  /**
   * 用户注册，添加用户
   *
   * @param registerDTO
   * @return
   */
  UUID register(RegisterDTO registerDTO);

  /**
   * 用户登入
   *
   * @param loginDTO
   * @param request
   * @return
   */
  UserDTO login(LoginDTO loginDTO, HttpServletRequest request);

  /**
   * 查找用户
   *
   * @param uuid
   * @return
   */
  UserDTO queryUser(String uuid);

  /**
   * 修改用户
   *
   * @param modifyUserDTO
   */
  void modify(ModifyUserDTO modifyUserDTO);
}
