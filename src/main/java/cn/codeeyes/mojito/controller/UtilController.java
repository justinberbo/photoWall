package cn.codeeyes.mojito.controller;

import cn.codeeyes.mojito.model.common.ResponseMsg;
import cn.codeeyes.mojito.model.dto.RegisterDTO;
import cn.codeeyes.mojito.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author codeeyes.cn
 * @date 2020/7/22 09:44
 */
@Controller
@Api(description = "工具接口")
public class UtilController {

  @Resource
  private UserService userService;
@ApiOperation(value = "统计访问人数",httpMethod = "GET",produces = "application/json")
  @GetMapping("/getCount")
@ResponseBody
  public ResponseMsg<?> count(){
  return ResponseMsg.buildSuccess(userService.getCount());
}

  @ApiOperation(value = "添加访问人数",httpMethod = "GET",produces = "application/json")
  @GetMapping("/addCount")
  @ResponseBody
  public ResponseMsg<?> addCount(){
    userService.addCount();
    return ResponseMsg.buildSuccess();
  }
}
