package cn.codeeyes.mojito.model.entity;

import java.util.Date;
import lombok.Data;

/**
 * @author codeeyes.cn
 * @date 2020/7/11 16:49
 */
@Data
public class UserDO {

  private Long id;
  private String nickName;
  private String password;
  private String email;
  private String mobile;
  private String realName;
  private Integer mobileFlag;
  private Date createTime;
  private Date updateTime;
}
