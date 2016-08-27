package hbi.core.demo.mapper;

import java.util.List;

import com.hand.hap.mybatis.common.Mapper;

import hbi.core.demo.dto.Companys;
import hbi.core.demo.dto.Customers;

public interface CustomersMapper extends Mapper<Customers>{
	List<Customers> selectByCustomers(Companys companys);

	int insertCustomers(Customers customers);

	int deleteCustomers(Customers customers);

	int updateCustomers(Customers customers);
}
