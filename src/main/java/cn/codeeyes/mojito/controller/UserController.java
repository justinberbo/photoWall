package cn.codeeyes.mojito.controller;


import cn.codeeyes.mojito.common.SysException;
import cn.codeeyes.mojito.model.common.ResponseMsg;
import cn.codeeyes.mojito.model.dto.LoginDTO;
import cn.codeeyes.mojito.model.dto.RegisterDTO;
import cn.codeeyes.mojito.model.dto.UserDTO;
import cn.codeeyes.mojito.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.annotation.Resource;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zhuang
 * @version 1.0
 * @date 2019/11/24 6:17 下午
 */
@Api(value = "account service API", description = "账号管理接口")
@Controller
public class UserController  {

  private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
  @Resource
  UserService userService;
  /**
   * 注册账号
   *
   * @return
   */
  @ApiOperation(value = "注册", httpMethod = "POST", produces = "application/json")
  @ApiResponses(value = {@ApiResponse(code = 200, message = "success", response = RegisterDTO.class, responseContainer = "List")})
  @PostMapping("/register")
  @ResponseBody
    public ResponseMsg<?> register(@Valid @RequestBody RegisterDTO registerDTO){
    userService.register(registerDTO);
    return ResponseMsg.buildSuccess(registerDTO);
  }
  @ApiOperation(value = "登入", httpMethod = "POST", produces = "application/json")
  @ApiResponses(value = {@ApiResponse(code = 200, message = "success", response = UserDTO.class, responseContainer = "List")})

  @PostMapping("/login")
  @ResponseBody
  public ResponseMsg<?> login(@Valid @RequestBody LoginDTO loginDTO, HttpServletRequest request){
    try {
      userService.login(loginDTO,request);
    }catch (SysException e){
      LOGGER.error("登入错误", e);
      return ResponseMsg.buildFailInstance(e);
    }
    return ResponseMsg.buildSuccess(loginDTO);
  }
}


