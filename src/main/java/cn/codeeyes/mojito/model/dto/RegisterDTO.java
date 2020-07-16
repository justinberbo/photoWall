package cn.codeeyes.mojito.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import lombok.Data;

/**
 * @author codeeyes.cn
 * @date 2020/7/11 16:32
 */
@Data
@ApiModel
public class RegisterDTO {

  @ApiModelProperty(value = "邮箱")
  @NotBlank(message = "邮箱不能为空")
  private String email;

  @ApiModelProperty(value = "密码")
  @NotBlank
  @NotBlank(message = "密码不能为空")
  private String password;
}
