package top.mable.payment.tool;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestData<T> implements Serializable {

    private String reqId;

    private T data;
}
