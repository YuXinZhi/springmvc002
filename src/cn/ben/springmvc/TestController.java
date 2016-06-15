package cn.ben.springmvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class TestController extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		System.out.println("hello Spring MVC");

		// viewName不上jsp的名称而是前缀与后缀之间的路径字符串
		return new ModelAndView("index");
	}

}
