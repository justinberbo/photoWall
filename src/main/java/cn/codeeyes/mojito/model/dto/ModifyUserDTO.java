package cn.codeeyes.mojito.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import lombok.Data;

/**
 * @author codeeyes.cn
 * @date 2020/7/20 17:27
 */
@Data
@ApiModel(value = "用户信息修改dto")
public class ModifyUserDTO {

  @ApiModelProperty(value = "用户id")
  private Long id;

  @ApiModelProperty(value = "用户昵称")
  private String nikeName;

  @ApiModelProperty(value = "邮箱")
  private String email;

  @ApiModelProperty(value = "手机")
  private String mobile;
}
