package hbi.core.demo.mapper;

import java.util.List;

import com.hand.hap.mybatis.common.Mapper;

import hbi.core.demo.dto.OrderLines;

public interface OrderLinesMapper extends Mapper<OrderLines>{
	List<OrderLines> selectByOrderLines(OrderLines orderLines);

	int insertOrderLines(OrderLines orderLines);

	int deleteOrderLines(OrderLines orderLines);

	int updateOrderLines(OrderLines orderLines);
}
