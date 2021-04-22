package top.mable.payment.controller;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.mable.payment.tool.Result;
import top.mable.payment.common.exception.BusinessException;
import top.mable.payment.tool.ExceptionEnum;
import top.mable.payment.tool.RequestData;
import top.mable.payment.tool.vo.RequestExceptionDTO;

@RestController
@RequestMapping("/demo")
public class DemoController {


    @RequestMapping("/exception")
    public Result testException(@RequestBody RequestData<RequestExceptionDTO> requestData){
        RequestExceptionDTO requestExceptionDTO = requestData.getData();
        if (requestExceptionDTO.getName() == null){
            throw new BusinessException(ExceptionEnum.IS_NULL,new String[]{requestData.getReqId()});
        }
        return Result.success(requestExceptionDTO);
    }
}
