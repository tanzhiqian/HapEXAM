package hbi.core.demo.service;

import java.util.List;

import com.hand.hap.core.IRequest;
import com.hand.hap.core.ProxySelf;
import com.hand.hap.core.annotation.StdWho;
import com.hand.hap.system.service.IBaseService;

import hbi.core.demo.dto.Customers;

public interface ICustomersService extends IBaseService<Customers>,ProxySelf<ICustomersService>{
	List<Customers> selectByCustomers(IRequest requestContext, Customers customers, int page, int pagesize);

	List<Customers> batchUpdateCustomers(IRequest requestContext, @StdWho List<Customers> customers);

}
