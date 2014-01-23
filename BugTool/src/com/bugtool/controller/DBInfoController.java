package com.bugtool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bugtool.model.DBInfo;
import com.bugtool.util.NavigationOutCome;


@Controller
public class DBInfoController {
	
	@RequestMapping("/dbInfoAdd")
	public ModelAndView addEnvInfo(Model model) {
		model.addAttribute("dbInfo", new DBInfo());
		ModelAndView modelView = new ModelAndView(
				NavigationOutCome.ADD_DB_DETAIL, "message",
				"Add Bug Details");
		return modelView;
	}

	@RequestMapping("/dbInfoList")
	public ModelAndView showEnvInfoList() {
		return new ModelAndView(NavigationOutCome.DB_INFO_LIST, "message",
				"DB Info List");
	}
	

}
