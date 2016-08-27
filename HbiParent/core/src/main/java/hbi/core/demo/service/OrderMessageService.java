package hbi.core.demo.service;

import java.util.List;

import com.hand.hap.core.IRequest;
import com.hand.hap.core.ProxySelf;
import com.hand.hap.system.service.IBaseService;

import hbi.core.demo.dto.OrderMessage;

public interface OrderMessageService extends IBaseService<OrderMessage>, ProxySelf<OrderMessageService> {

	 List<OrderMessage> getOrderMessage(IRequest requestContext, OrderMessage orderMessage, int page, int pagesize);

}
