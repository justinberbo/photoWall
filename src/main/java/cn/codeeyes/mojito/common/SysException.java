package cn.codeeyes.mojito.common;

import cn.codeeyes.mojito.common.model.IErrorCode;

/**
 * 系统异常
 *
 * @author www.codeeyes.cn
 */
public class SysException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  private IErrorCode errorCode;

  public SysException(IErrorCode errorCode) {
    super(errorCode.toString());
    this.errorCode = errorCode;
  }

  public IErrorCode getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(IErrorCode errorCode) {
    this.errorCode = errorCode;
  }

  @Override
  public String toString() {
    return errorCode.getCode();
  }

  @Override
  public String getMessage() {
    return errorCode.getDesc();
  }

}
