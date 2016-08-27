package hbi.core.demo.mapper;

import java.util.List;

import com.hand.hap.mybatis.common.Mapper;

import hbi.core.demo.dto.OrderMessage;

public interface OrderMessageMapper extends Mapper<OrderMessage> {
	 List<OrderMessage> getOrderMessage(OrderMessage orderMessage);

}
