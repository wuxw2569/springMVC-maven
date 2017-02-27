package com.wuxw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	
	@RequestMapping(value="index.do")
	public ModelAndView index(Model model){
		model.addAttribute("welcome","��ӭ����springMVC");
		System.out.println("���󵽺�̨");
		ModelAndView view =new ModelAndView("welcome");
		return view;
	}
}
