package com.hanwha.myapp;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@RequestMapping(value="/test")
	public String test(Model model) {
		model.addAttribute("company", "한화ICT");
		model.addAttribute("dept", "을지로 가고 싶어요 ㅜㅜ");
		model.addAttribute("myname", "선빈");
		
		return "test3";
	}
	
	@RequestMapping(value="/han")
	public ModelAndView han() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("company", "한화ICT");
		mv.addObject("dept", "을지로 가고 싶어요 ㅜㅜ");
		mv.addObject("myname", "선빈");
		mv.setViewName("test3");
		
		return mv;
	}
	
	@RequestMapping(value="/paramtest")
	public ModelAndView paramtest(UserDTO user) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("userid", user.getUserid() + 100);
		mv.addObject("username", user.getUsername() + "님");
		mv.setViewName("paramtestResult");
		
		return mv;
	}
	
	@RequestMapping(value="/paramtest2")
	public ModelAndView paramtest(int userid, String username) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("userid", userid + 100);
		mv.addObject("username", username + "님");
		mv.setViewName("paramtestResult");
		
		return mv;
	}
	
	@RequestMapping(value="/redirecttest")
	public String redirecttest() {
		System.out.println("redirect test입니다.");
		return "redirect:han";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("myname", "선빈" );
		
		return "home";
	}
	
}
