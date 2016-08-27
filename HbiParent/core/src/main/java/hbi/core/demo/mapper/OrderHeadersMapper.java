package hbi.core.demo.mapper;

import java.util.List;

import com.hand.hap.mybatis.common.Mapper;

import hbi.core.demo.dto.OrderHeaders;

public interface OrderHeadersMapper extends Mapper<OrderHeaders>{
	List<OrderHeaders> selectByOrderHeaders(OrderHeaders orderHeaders);

	int insertOrderHeaders(OrderHeaders orderHeaders);

	int deleteOrderHeaders(OrderHeaders orderHeaders);

	int updateOrderHeaders(OrderHeaders orderHeaders);
}
