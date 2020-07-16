package cn.codeeyes.mojito.service;


import cn.codeeyes.mojito.model.dto.LoginDTO;
import cn.codeeyes.mojito.model.dto.RegisterDTO;
import cn.codeeyes.mojito.model.dto.UserDTO;
import javax.servlet.http.HttpServletRequest;

/**
 * @author codeeyes.cn
 */
public interface UserService {

  /**
   * 用户注册，添加用户
   *
   * @param registerDTO
   * @return MarResult
   */
   void register(RegisterDTO registerDTO);

  /**
   * 用户登入
   * @param loginDTO
   * @param request
   * @return
   */
 UserDTO login(LoginDTO loginDTO, HttpServletRequest request);
}
