package hbi.core.demo.controllers;

import hbi.core.demo.dto.Fruit;

import hbi.core.demo.service.IFruitService;

import com.hand.hap.core.IRequest;
import com.hand.hap.core.exception.BaseException;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.system.dto.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class FruitController extends BaseController {
	@Autowired
	private IFruitService fruitService;

	/**
	 * 任务分配查询.
	 * 
	 * @param fruit
	 *            分配对象
	 * @param page
	 *            起始页
	 * @param pagesize
	 *            分页大小
	 * @param request
	 *            HttpServletRequest
	 * @return ResponseData
	 */
	@RequestMapping(value = "/fruit/query")
	@ResponseBody
	public ResponseData getTasks(Fruit fruit, @RequestParam(defaultValue = DEFAULT_PAGE) int page,
			@RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pagesize, HttpServletRequest request) {
		IRequest requestContext = createRequestContext(request);
		return new ResponseData(fruitService.selectByFruit(requestContext, fruit, page, pagesize));
	}

	/**
	 * 保存水果.
	 * 
	 * @param fruits
	 *            fruits
	 * @param result
	 *            BindingResult
	 * @param request
	 *            HttpServletRequest
	 * @return ResponseData ResponseData
	 * @throws BaseException
	 *             BaseException
	 */
	@RequestMapping(value = "/fruit/submit", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData submitFruit(@RequestBody List<Fruit> fruits, BindingResult result, HttpServletRequest request)
			throws BaseException {
		getValidator().validate(fruits, result);
		if (result.hasErrors()) {
			ResponseData rd = new ResponseData(false);
			rd.setMessage(getErrorMessage(result, request));
			return rd;
		}
		IRequest requestContext = createRequestContext(request);
		return new ResponseData(fruitService.batchUpdate(requestContext, fruits));
	}
}
//
//

// @RequestMapping("/fruit/query")
// @ResponseBody
// public ResponseData selectList(HttpServletRequest request, Fruit fruit,
// @RequestParam(defaultValue = DEFAULT_PAGE) int page,
// @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pagesize) {
// IRequest iRequest = createRequestContext(request);
// List<Demo> datas = demoService.select(iRequest, fruit, page, pagesize);
// return new ResponseData(datas);
// }
//
// @RequestMapping(value = "/fruit/submit", method = RequestMethod.POST)
// @ResponseBody
// public ResponseData submit(HttpServletRequest request, @RequestBody
// List<Demo> demos) {
// IRequest iRequest = createRequestContext(request);
// List<Demo> datas = demoService.batchUpdate(iRequest, demos);
// return new ResponseData(datas);
// }
//
// @RequestMapping(value = "/demo/fruit/delete", method = RequestMethod.POST)
// @ResponseBody
// public ResponseData delete(HttpServletRequest request, @RequestBody
// List<Demo> demos) {
// IRequest iRequest = createRequestContext(request);
// demoService.batchDelete(demos);
// return new ResponseData();
// }
// }
