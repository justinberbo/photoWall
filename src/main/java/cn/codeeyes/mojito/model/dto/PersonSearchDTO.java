package cn.codeeyes.mojito.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author codeeyes.cn
 * @date 2020/7/18 16:26
 */
@Data
@ApiModel(value = "人物搜索dto")
public class PersonSearchDTO {

  @ApiModelProperty(value = "种类")
  private String type;

  @ApiModelProperty(value = "类别")
  private String category;

  @ApiModelProperty(value = "条件")
  private String condition;
}
