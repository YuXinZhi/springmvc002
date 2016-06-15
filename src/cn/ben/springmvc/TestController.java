package cn.ben.springmvc;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.ben.springmvc.model.Person;
import cn.ben.springmvc.model.User;

//用来标注当前类是springmvc的控制层放类
//相同级别注解的还有 Component,Service,Repository
@Controller
@RequestMapping("test")
// controller的唯一标识或命名空间
public class TestController {

	/**
	 * 方法返回值是ModelAndVie中的viewName
	 * 
	 * @return
	 */
	@RequestMapping("hello.do")
	// 用来访问控制层的方法的注解
	public String hello() {
		System.out.println("Hello Spring MVC 2");
		return "jsp1/index";
	}

	@RequestMapping("/toPerson.do")
	public String toPerson(HttpServletRequest request) {
		String result = request.getParameter("name");
		System.out.println(result);
		return "jsp1/index";
	}

	@RequestMapping("/toPerson1.do")
	public String toPerson1(String name) {
		System.out.println("toPerson1 name=" + name);
		return "jsp1/index";
	}

	@RequestMapping("/toPerson3.do")
	public String toPerson3(String name, Integer age) {
		System.out.println("toPerson3 name=" + name + "age=" + age);
		return "jsp1/index";
	}

	/**
	 * 参数名首字母“区分”大小写
	 * 
	 * @param name
	 * @param age
	 * @param date
	 * @return
	 */
	@RequestMapping("/toPerson4.do")
	public String toPerson4(String name, Integer age, Date date) {
		System.out.println("toPerson4 name=" + name + "age=" + age + "date="
				+ date);
		return "jsp1/index";
	}

	/**
	 * 传递的参数名必须要与实体类set方法后面的字符串匹配得上才能接收到参数
	 * 
	 * 参数名必须与set属性名一致，首字母“不区分”大小写
	 * 
	 * @param person
	 * @return
	 */
	@RequestMapping("/toPerson5.do")
	public String toPerson5(Person person, User user) {
		System.out.println("toPerson5 person=" + person);
		System.out.println("toPerson5 user=" + user);

		return "jsp1/index";
	}

	@RequestMapping("/toPerson6.do")
	public String toPerson6(String[] names) {
		for (String name : names) {
			System.out.println(name);
		}
		return "jsp1/index";
	}

	/**
	 * 注册时间类型的属性编辑器
	 * 
	 * @param binder
	 */
	@InitBinder()
	public void initBinder(ServletRequestDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				new SimpleDateFormat("yyyy-MM-dd"), true));
	}

	/******************************* 返回值 *********************************************/

	/**
	 * 方法1. 方法的返回值采用ModelAndView,ModelAndView("index", map); 相当于把数据结果放到request里面
	 * 
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping("/toPerson001.do")
	public ModelAndView toPerson001() throws ParseException {
		Person person = new Person();
		person.setName("ymm");
		person.setAge(24);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = format.parse("1992-05-20");
		person.setBirthday(date);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("p", person);
		return new ModelAndView("index", map);
	}

	/**
	 * 方法2.直接在方法参数列表中定义Map,这个Map即是ModelAndView里面的Map,
	 * 有试图解析器统一处理，统一走ModeAndView的接口
	 * 
	 * @param map
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping("/toPerson002.do")
	public String toPerson002(Map<String, Object> map) throws ParseException {
		Person person = new Person();
		person.setName("ymm002");
		person.setAge(24);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = format.parse("1992-05-20");
		person.setBirthday(date);

		map.put("p", person);
		return "index";
	}

	/**
	 * 前两种方法不建议使用
	 */

	/**
	 * 在参数列表中直接定义Model,model.addAttribute("p", person);把参数值放到request中去，建议使用
	 * 
	 * @param map
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping("/toPerson003.do")
	public String toPerson003(Model model) throws ParseException {
		Person person = new Person();
		person.setName("ymm003");
		person.setAge(24);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = format.parse("1992-05-20");
		person.setBirthday(date);
		// 把参数值放到request类中
		model.addAttribute("p", person);
		return "index";
	}

	@RequestMapping("/ajax.do")
	public void ajax(String name, HttpServletResponse response) {
		String result = "hello " + name;
		try {
			response.getWriter().write(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/toAjax.do")
	public String toAjax() {
		return "ajax";
	}
}
