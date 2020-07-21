package cn.codeeyes.mojito.model.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import lombok.Data;

/**
 * @author codeeyes.cn
 * @date 2020/7/20 22:22
 */
@ApiModel("图集dto")
@Data
public class CollectionDTO {

  @ApiModelProperty(value = "id")
  private Long id;

  @ApiModelProperty(value = "作者")
  private String author;

  @ApiModelProperty(value = "封面")
  private String img_index;

  @ApiModelProperty(value = "图片地址")
  private List<String> img_url;
}
