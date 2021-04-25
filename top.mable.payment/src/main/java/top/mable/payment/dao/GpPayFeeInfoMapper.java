package top.mable.payment.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.mable.payment.tool.vo.GpPayFeeInfoDTO;

@Mapper
public interface GpPayFeeInfoMapper extends BaseMapper<GpPayFeeInfoDTO> {
}
