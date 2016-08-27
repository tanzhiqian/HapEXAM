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

import hbi.core.demo.dto.OrderHeaders;
import hbi.core.demo.mapper.OrderHeadersMapper;
import hbi.core.demo.service.IOrderHeadersService;

@Service
public class OrderHeadersServiceImpl extends BaseServiceImpl<OrderHeaders> implements IOrderHeadersService{

	@Autowired
	private OrderHeadersMapper orderHeadersMapper;
	@Override
	public List<OrderHeaders> selectByOrderHeaders(IRequest requestContext, OrderHeaders orderHeaders, int page,
			int pagesize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, pagesize);
		return orderHeadersMapper.selectByOrderHeaders(orderHeaders);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public List<OrderHeaders> batchUpdateOrderHeaders(IRequest requestContext, List<OrderHeaders> orderHeaders) {
		// TODO Auto-generated method stub
		for(OrderHeaders orderHeader:orderHeaders){
			if(orderHeader.get__status()!=null){
				switch (orderHeader.get__status()) {
				case DTOStatus.ADD:
					orderHeadersMapper.insertOrderHeaders(orderHeader);
					break;
				case DTOStatus.DELETE:
					orderHeadersMapper.deleteOrderHeaders(orderHeader);
					break;
				case DTOStatus.UPDATE:
					self().deleteByPrimaryKey(orderHeader);
					break;
				default:
					break;
				}
			}
		}
		
		return orderHeaders;
	}

}
