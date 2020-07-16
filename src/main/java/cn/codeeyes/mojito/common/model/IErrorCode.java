package cn.codeeyes.mojito.common.model;

public interface IErrorCode {

    String getCode();

    String getDesc();

    String[] getParams();

    void setCode(String code);

    void setDesc(String desc);

    void setParams(String[] params);

}
