package top.mable.payment.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.mable.payment.annotation.SystemServiceLog;
import top.mable.payment.service.GpPayFeeInfoService;
import top.mable.payment.tool.Result;
import top.mable.payment.tool.vo.GpPayFeeInfoDTO;

import java.sql.Wrapper;
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

    @SystemServiceLog
    @RequestMapping("/getOne")
    public Result getOne(@RequestBody GpPayFeeInfoDTO gpPayFeeInfoDTO){
        QueryWrapper wrapper = new QueryWrapper<GpPayFeeInfoDTO>();
        wrapper.eq("id",gpPayFeeInfoDTO.getId());
        GpPayFeeInfoDTO one = gpPayFeeInfoService.getOne(wrapper);
        return Result.success(one);

    }
}
