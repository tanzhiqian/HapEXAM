package hbi.core.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hand.hap.core.IRequest;
import com.hand.hap.system.service.impl.BaseServiceImpl;

import hbi.core.demo.dto.OrderMessage;
import hbi.core.demo.mapper.OrderMessageMapper;
import hbi.core.demo.service.OrderMessageService;

@Service
public class OrderMessageServiceImpl extends BaseServiceImpl<OrderMessage> implements OrderMessageService {

	@Autowired(required = true)
	OrderMessageMapper orderMessageMapper;
@Override
	public List<OrderMessage> getOrderMessage(IRequest requestContext, OrderMessage orderMessage, int page, int pagesize) {
		// TODO Auto-generated method stub
	List<OrderMessage> list=orderMessageMapper.getOrderMessage(orderMessage);
		return list;
	}



}
