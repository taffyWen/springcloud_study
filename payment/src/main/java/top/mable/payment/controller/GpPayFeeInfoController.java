package top.mable.payment.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.mable.payment.service.GpPayFeeInfoService;
import top.mable.payment.tool.Result;
import top.mable.payment.tool.vo.GpPayFeeInfoDTO;

import java.util.List;

@RestController
@RequestMapping("pay")
public class GpPayFeeInfoController {

    @Autowired
    private GpPayFeeInfoService gpPayFeeInfoService;

    @RequestMapping("/getAll")
    public Result getAll(){
        List<GpPayFeeInfoDTO> list = gpPayFeeInfoService.list();
        return Result.success(list);
    }
}
