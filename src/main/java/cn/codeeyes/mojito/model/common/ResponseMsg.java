package cn.codeeyes.mojito.model.common;


import com.alibaba.fastjson.JSON;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;;


/**
 * @author codeeyes.cn
 */
@ApiModel(value = "ResponseMsg", description = "通用响应类")
@Data
public class ResponseMsg<T> {

    @ApiModelProperty(value = "结果")
    private boolean success;

    @ApiModelProperty(value = "返回码")
    private String returnCode;

    @ApiModelProperty(value = "返回描述")
    private String returnMsg;

    @ApiModelProperty(value = "数据对象")
    private T data;

    public ResponseMsg() {
        success = true;
        returnCode = "200";
        returnMsg = "";
    }

    public ResponseMsg(boolean success, String returnCode, String returnMsg) {
        this.success = success;
        this.returnCode = returnCode;
        this.returnMsg = returnMsg;
    }

    public static <T> ResponseMsg<T> buildSuccess(T data) {
        ResponseMsg<T> responseVo = new ResponseMsg<T>();
        responseVo.setData(data);
        responseVo.setReturnCode("200");
        responseVo.setReturnMsg("success");
        responseVo.setSuccess(true);
        return responseVo;
    }
    public static <T> ResponseMsg<T> buildSuccess() {
        ResponseMsg<T> responseVo = new ResponseMsg<T>();
        return responseVo;
    }
    public static <T> ResponseMsg<T> buildFailInstance(Exception ex) {
        return new ResponseMsg<T>(false,ex.toString() , ex.getMessage());
    }
}
