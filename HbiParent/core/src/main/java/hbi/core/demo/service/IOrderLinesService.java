package hbi.core.demo.service;

import java.util.List;

import com.hand.hap.core.IRequest;
import com.hand.hap.core.ProxySelf;
import com.hand.hap.core.annotation.StdWho;
import com.hand.hap.system.service.IBaseService;

import hbi.core.demo.dto.OrderLines;

public interface IOrderLinesService extends IBaseService<OrderLines>, ProxySelf<IOrderLinesService>{
	List<OrderLines> selectByOrderLines(IRequest requestContext, OrderLines orderLines, int page, int pagesize);

	List<OrderLines> batchUpdateOrderLines(IRequest requestContext, @StdWho List<OrderLines> orderLines);
}