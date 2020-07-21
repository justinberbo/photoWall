package cn.codeeyes.mojito.model.dto;

import java.util.Date;
import java.util.UUID;
import lombok.Data;

/**
 * @author codeeyes.cn
 * @date 2020/7/12 16:56
 */
@Data
public class UserDTO {

  private UUID uuid;
  private Long id;
  private String nickName;
  private String password;
  private String email;
  private String mobile;
  private String realName;
  private Integer mobileFlag;
  private Date createTime;
  private Date updateTime;
  private String ip;
}
