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

import hbi.core.demo.dto.Customers;
import hbi.core.demo.mapper.CustomersMapper;
import hbi.core.demo.service.ICustomersService;

@Service
public class CustomersServiceImpl extends BaseServiceImpl<Customers> implements ICustomersService{
	@Autowired
	private CustomersMapper customersMapper;
	
	

	/*@Override
	public List<Customers> selectByCustomers(IRequest requestContext, Customers customers, int page, int pagesize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, pagesize);
		return customersMapper.selectByCustomers(customers);
	}*/

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public List<Customers> batchUpdateCustomers(IRequest requestContext, List<Customers> customers) {
		// TODO Auto-generated method stub
		for(Customers customer:customers){
			if(customer.get__status()!=null){
				switch (customer.get__status()) {
				case DTOStatus.ADD:
					customersMapper.insertCustomers(customer);
					break;
				case DTOStatus.DELETE:
					customersMapper.deleteCustomers(customer);
					break;
				case DTOStatus.UPDATE:
					self().deleteByPrimaryKey(customer);
					break;
				default:
					break;
				}
			}
		}
		
		return customers;
	}



	@Override
	public List<Customers> selectByCustomers(IRequest requestContext, Customers customers, int page, int pagesize) {
		// TODO Auto-generated method stub
		return null;
	}
}
