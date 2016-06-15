package cn.ben.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//用来标注当前类是springmvc的控制层放类
//相同级别注解的还有 Component,Service,Repository
@Controller
public class TestController {
	@RequestMapping("hello.do")
	// 用来访问控制层的方法的注解
	public String hello() {
		System.out.println("Hello Spring MVC 2");
		return "jsp1/index";
	}
}
