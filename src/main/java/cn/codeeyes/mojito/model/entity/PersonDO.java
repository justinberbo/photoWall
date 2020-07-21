package cn.codeeyes.mojito.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author codeeyes.cn
 * @date 2020/7/18 16:34
 */
@Data
public class PersonDO {

  private Integer id;

  private String name;

  private String avatar;

  private String type;

  private String category;

  private String group;
}
