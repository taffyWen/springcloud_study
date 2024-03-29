package top.mable.payment.tool;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@Data
public class RequestExceptionDTO {

    private String name;

    @NotEmpty
    private String age;
}
