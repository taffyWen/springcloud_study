package top.mable.payment.tool;


public enum ExceptionEnum {



    IS_NULL("P0001","{0}的name为空，异常")
    ;


    private String code;
    private String msg;

    ExceptionEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode(){
        return code;
    }

    public String getMsg(){
        return msg;
    }
}
