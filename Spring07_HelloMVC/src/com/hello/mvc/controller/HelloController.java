package com.hello.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hello.mvc.model.HelloBiz;

@Controller
public class HelloController {
	// TODO: 05.Biz(@service) 호출
	@Autowired
	private HelloBiz biz;

	// TODO: 04. handler mapping을 통해 controller의 메서드를 찾아
	@RequestMapping("/hello.do")
	public String getHello(Model model) {
		//TODO: 09. return 받은 값을 model 객체에 담아서 전달
		model.addAttribute("message",biz.getHello());
		return "/WEB-INF/views/hello.jsp";
	}
	@RequestMapping("bye.do")
	public ModelAndView getBye(@RequestParam("name") String nickname) {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("/WEB-INF/views/bye.jsp");
		mav.addObject("message","Bye"+nickname);
		
		return mav;
	}
}
