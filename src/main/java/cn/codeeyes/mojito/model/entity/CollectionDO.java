package cn.codeeyes.mojito.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.util.List;
import lombok.Data;

/**
 * @author codeeyes.cn
 * @date 2020/7/20 22:22
 */
@Data
public class CollectionDO {

  private Long id;

  private String author;

  private String img_index;

  private String img_url1;

  private String img_url2;

  private String img_url3;

  private String img_url4;

  private String img_url5;

  private String img_url6;

  private String img_url7;

  private String img_url8;

  private Date create_time;

  private Date update_time;
}
