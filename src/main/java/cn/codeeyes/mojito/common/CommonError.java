package cn.codeeyes.mojito.common;

import cn.codeeyes.mojito.common.model.IErrorCode;

/**
 * @author codeeyes.cn
 * @date 2020/7/12 16:58
 */
public enum CommonError  implements IErrorCode {
  USER_NO_FIND("1001","用户不存在"),
  USER_PWD_ERROR("1002", "用户名密码错误"),
  ;

  private String code;

  private String desc;

  CommonError(String code, String desc) {
    this.setCode(code);
    this.setDesc(desc);
  }

  @Override
  public String getCode() {
    return code;
  }

  @Override
  public void setCode(String code) {
    this.code = code;
  }

  @Override
  public String getDesc() {
    return desc;
  }

  @Override
  public void setDesc(String desc) {
    this.desc = desc;
  }

  @Override
  public String[] getParams() {
    return new String[0];
  }

  @Override
  public void setParams(String[] params) {

  }

  @Override
  public String toString() {
    return "[" + this.code + "]" + this.desc;
  }

}
