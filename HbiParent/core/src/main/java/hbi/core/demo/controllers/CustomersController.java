package hbi.core.demo.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hand.hap.core.IRequest;
import com.hand.hap.core.exception.BaseException;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.system.dto.ResponseData;

import hbi.core.demo.dto.Companys;
import hbi.core.demo.dto.Customers;
import hbi.core.demo.service.ICustomersService;

@Controller
public class CustomersController  extends BaseController {
	@Autowired
	private ICustomersService customersService;
	/**
	 * 任务分配查询.
	 * 
	 * @param customers
	 *            分配对象
	 * @param page
	 *            起始页
	 * @param pagesize
	 *            分页大小
	 * @param request
	 *            HttpServletRequest
	 * @return ResponseData
	 */
	@RequestMapping(value = "/customers/query")
	@ResponseBody
	public ResponseData getTasks(Customers customers, @RequestParam(defaultValue = DEFAULT_PAGE) int page,
			@RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pagesize, HttpServletRequest request) {
		IRequest requestContext = createRequestContext(request);
		return new ResponseData(customersService.selectByCustomers(requestContext, customers, page, pagesize));
	}
	/**
	 * 
	 * @param Customers
	 *            customers
	 * @param result
	 *            BindingResult
	 * @param request
	 *            HttpServletRequest
	 * @return ResponseData ResponseData
	 * @throws BaseException
	 *             BaseException
	 */
	@RequestMapping(value = "/customers/submit", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData submitCustomers(@RequestBody List<Customers> customers, BindingResult result,
			HttpServletRequest request) throws BaseException {
		getValidator().validate(customers, result);
		if (result.hasErrors()) {
			ResponseData rd = new ResponseData(false);
			rd.setMessage(getErrorMessage(result, request));
			return rd;
		}
		IRequest requestContext = createRequestContext(request);
		return new ResponseData(customersService.batchUpdate(requestContext, customers));
	}
}
