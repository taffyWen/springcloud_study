package top.mable.payment.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> implements Serializable {

    //private static final long serialVersionUID

    public static final String SUCC_CODE = "200";
    public static final String FAIL_CODE = "500";


    private String code;

    private String errMsg;

    private String reqId;

    private T data;

    public Result(String errMsg) {
        this.errMsg = errMsg;
    }
    public Result(String code,String errMsg) {
        this.code = code;
        this.errMsg = errMsg;
    }

    public static <T> Result<T> success(T data, String reqId){
        return new Result<>(SUCC_CODE,"成功",reqId,data);
    }

    public static <T> Result<T> fail(T data, String reqId,String errMsg){
        return new Result<>(FAIL_CODE,errMsg,reqId,data);
    }
    public static <T> Result<T> fail(String errMsg){
        return new Result<T>(errMsg);
    }
    public static <T> Result<T> fail(String code,String errMsg){
        return new Result<T>(code,errMsg);
    }
}
