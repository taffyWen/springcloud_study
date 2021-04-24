package top.mable.payment.tool.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("GP_PAY_FEE_INFO")
public class GpPayFeeInfoDTO {

    private String id;

    private String businessNo;
    private double amount;
    private String status;
}
