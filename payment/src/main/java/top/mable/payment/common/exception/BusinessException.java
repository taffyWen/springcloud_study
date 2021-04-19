package top.mable.payment.common.exception;

import lombok.Data;

@Data
public class BusinessException extends RuntimeException {

    private String code;

    /**
     * 占位符需要绑定参数数组，需按顺序
     */
    private Object bindArgs[];

    /**
     * 异常参数中的枚举对象
     */
    private Enum enums;

    public BusinessException(Enum enums, Object[] bindArgs) {
        this.bindArgs = bindArgs;
        this.enums = enums;
    }


}
