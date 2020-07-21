package cn.codeeyes.mojito.common;

import cn.codeeyes.mojito.common.model.IErrorCode;

/**
 * @author codeeyes.cn
 * @date 2020/7/12 16:58
 */
public enum CommonError implements IErrorCode {
  USER_NO_FIND("1001", "用户不存在"),
  USER_PWD_ERROR("1002", "用户名密码错误"),
  EMAIL_IS_REGISTER("1003", "邮箱已注册"),
  UUID_NO_FIND("1004", "没有查到用户信息，用户登入信息过期，请重新登入");

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
  public String toString() {
    return "[" + this.code + "]" + this.desc;
  }

}
