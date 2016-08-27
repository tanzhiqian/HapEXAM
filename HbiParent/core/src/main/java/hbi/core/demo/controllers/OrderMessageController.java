package hbi.core.demo.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hand.hap.core.IRequest;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.system.dto.ResponseData;

import hbi.core.demo.dto.OrderMessage;
import hbi.core.demo.service.OrderMessageService;

@Controller
public class OrderMessageController extends BaseController {
	@Autowired(required = true)
	private OrderMessageService orderMessageService;

	
	 @RequestMapping(value = "/getOrderMessage")
	/* @ResponseBody 
	 List<OrderMessage> getOrderMessage(IRequest requestContext, OrderMessage orderMessage, int page, int pagesize) {
		return orderMessageService.getOrderMessage(requestContext,orderMessage,page,pagesize);
	}*/
	 @ResponseBody
	    public ResponseData getTasks(OrderMessage orderMessage, @RequestParam(defaultValue = DEFAULT_PAGE) int page,
	            @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pagesize, HttpServletRequest request) 
	    {
		 	System.out.println("@@@@@@@@");
		 	IRequest requestContext = createRequestContext(request);
		 	System.out.println(orderMessageService.getOrderMessage(requestContext, orderMessage, page, pagesize));
	        return new ResponseData(orderMessageService.getOrderMessage(requestContext, orderMessage, page, pagesize));
	    }


}
