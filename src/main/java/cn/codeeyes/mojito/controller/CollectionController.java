package cn.codeeyes.mojito.controller;
import cn.codeeyes.mojito.model.common.ResponseMsg;
import cn.codeeyes.mojito.model.dto.CollectionDTO;
import cn.codeeyes.mojito.service.CollectionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author codeeyes.cn
 * @date 2020/7/20 22:18
 */
@RestController
@Api(description="图片集合")
public class CollectionController {

  @Resource
  private CollectionService collectionService;

  @ApiOperation(value = "获取图集", httpMethod = "GET", produces = "application/json")
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "success", response = CollectionDTO.class, responseContainer = "List")})
  @GetMapping("/getCollection")
  public ResponseMsg<?> getCollection() {
    return ResponseMsg.buildSuccess(collectionService.getCollection());
  }
}