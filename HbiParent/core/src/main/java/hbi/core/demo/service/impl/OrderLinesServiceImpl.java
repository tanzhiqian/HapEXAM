package hbi.core.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.hand.hap.core.IRequest;
import com.hand.hap.system.dto.DTOStatus;
import com.hand.hap.system.service.impl.BaseServiceImpl;

import hbi.core.demo.dto.OrderLines;
import hbi.core.demo.mapper.OrderLinesMapper;
import hbi.core.demo.service.IOrderLinesService;

@Service
public class OrderLinesServiceImpl extends BaseServiceImpl<OrderLines> implements IOrderLinesService{

	@Autowired
	private OrderLinesMapper orderLinesMapper;
	
	@Override
	public List<OrderLines> selectByOrderLines(IRequest requestContext, OrderLines orderLines, int page, int pagesize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, pagesize);
		return orderLinesMapper.selectByOrderLines(orderLines);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public List<OrderLines> batchUpdateOrderLines(IRequest requestContext, List<OrderLines> orderLines) {
		// TODO Auto-generated method stub
		for(OrderLines orderLine: orderLines){
			if(orderLine.get__status()!=null){
				switch (orderLine.get__status()) {
				case DTOStatus.ADD:
					orderLinesMapper.insertOrderLines(orderLine);
					break;
				case DTOStatus.UPDATE:
					orderLinesMapper.updateOrderLines(orderLine);
					break;
				case DTOStatus.DELETE:
					self().deleteByPrimaryKey(orderLine);
					break;
				default:
					break;
			}
		}
		
	}
		return orderLines;
}
}