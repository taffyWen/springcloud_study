package top.mable.payment.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.mable.payment.dao.GpPayFeeInfoMapper;
import top.mable.payment.service.GpPayFeeInfoService;
import top.mable.payment.tool.vo.GpPayFeeInfoDTO;


@Service
public class GpPayFeeInfoServiceImpl extends ServiceImpl<GpPayFeeInfoMapper,GpPayFeeInfoDTO> implements GpPayFeeInfoService {
}
