package cn.codeeyes.mojito.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author codeeyes.cn
 * @date 2020/7/18 16:34
 */
@Data
@ApiModel(value = "人物dto")
public class PersonDTO {

  @ApiModelProperty(value = "id")
  private Integer id;

  @ApiModelProperty(value = "姓名")
  private String name;

  @ApiModelProperty(value = "头像地址")
  private String avatar;

  @ApiModelProperty(value = "类型")
  private String type;

  @ApiModelProperty(value = "种类")
  private String category;

  @ApiModelProperty(value = "单位")
  private String company;
}
