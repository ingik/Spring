package com.mvc.upgrade;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvc.upgrade.model.biz.BoardBiz;
import com.mvc.upgrade.model.dto.BoardDto;


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private BoardBiz biz;
	
	//index에있는걸 여길로
	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("/list.do")
	public String list(Model model) {
		logger.info("SELECT LIST");
		model.addAttribute("list",biz.selectList());
		return "mvclist";
	}
	
	@RequestMapping("/insertform.do")
	public String insertForm() {
		logger.info("INSERT FORM");
		return "mvcinsert";
	}
	
	@RequestMapping("/insertres.do")
	public String insertRes(BoardDto dto) {
		logger.info("INSERT RES");
		int res=biz.insert(dto);
		if(res>0) {
			return "redirect:list.do";
		}else {
			return "redirect:insertform.do";
		}
	}
	//이게 그냥 부르면 그페이지만 불러옴 옜날에 세미때 번호들 들고와서 넣어준거처럼 아예 서블렛페이지를 불러서하는것
	
	@RequestMapping("/detail.do")
	public String detail(Model model, int myno) {
		logger.info("SELECT ONE");
		model.addAttribute("dto",biz.selectOne(myno));

		return "mvcdetail";
	}
	
	@RequestMapping("/updateform.do")
	public String updateForm(Model model, int myno) {
		logger.info("UPDATE FORM");
		
		model.addAttribute("dto",biz.selectOne(myno));
		return "mvcupdate";
	}
	
	@RequestMapping("/updateres.do")
	public String updatesRes(BoardDto dto) {
		logger.info("UPDATE RES");
		int res = biz.update(dto);
		
		if(res>0) {
			return "redirect:detail.do?myno="+dto.getMyno();
		}else {
			return "redirect:updateform.do?myno="+dto.getMyno();
		}
	}

	@RequestMapping("/delete.do")
	public String delete(int myno) {
	logger.info("DELTE");
	
	int res = biz.delete(myno);
		
	if(res>0) {
		return "redirect:list.do";
	}else {
		return "redirect:detail.do?myno="+myno;
	}
	
	}
}
