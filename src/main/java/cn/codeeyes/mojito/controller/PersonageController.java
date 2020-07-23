package cn.codeeyes.mojito.controller;

import cn.codeeyes.mojito.model.common.ResponseMsg;
import cn.codeeyes.mojito.model.dto.PersonDTO;
import cn.codeeyes.mojito.model.dto.PersonSearchDTO;
import cn.codeeyes.mojito.service.HotSearchService;
import cn.codeeyes.mojito.service.PersonageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.annotation.Resource;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author codeeyes.cn
 * @date 2020/7/17 19:26
 */

@Api(value = "API", description = "人物管理接口")
@Controller
public class PersonageController {

  @Resource
  private PersonageService personageService;

  @Resource
  private HotSearchService hotSearchService;

  @ApiOperation(value = "搜索", httpMethod = "POST", produces = "application/json")
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "success", response = PersonDTO.class, responseContainer = "List")})
  @PostMapping("/search")
  @ResponseBody
  public ResponseMsg<?> search(@RequestBody PersonSearchDTO searchDTO) {
    return ResponseMsg.buildSuccess(personageService.findPersonage(searchDTO));
  }

  @ApiOperation(value = "获取搜索热门", httpMethod = "GET", produces = "application/json")
  @GetMapping("/hotSearch")
  @ResponseBody
  public ResponseMsg<?> getHot() {
    return ResponseMsg.buildSuccess(hotSearchService.getHotSearch());
  }
  @ApiOperation(value = "获取人物图集", httpMethod = "GET", produces = "application/json")
  @GetMapping ("/getImg")
  @ResponseBody
  public ResponseMsg<?> getIMg(String name) {
    System.out.println(name);
    return ResponseMsg.buildSuccess(hotSearchService.getImgList(name));
  }
}