package com.bugtool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bugtool.model.BugInfo;
import com.bugtool.service.BugInfoService;
import com.bugtool.util.NavigationOutCome;

@Controller
public class BugInfoController {

	@Autowired
	private BugInfoService bugInfoService;

	@RequestMapping("/bugInfoAdd")
	public ModelAndView addBugInfo(Model model) {
		model.addAttribute("bugInfo", new BugInfo());
		ModelAndView modelView = new ModelAndView(
				NavigationOutCome.ADD_BUG_DETAIL, "message", "Add Bug Details");
		return modelView;
	}

	@RequestMapping("/bugInfoList")
	public ModelAndView showBugInfoList() {
		ModelAndView modelView = new ModelAndView();
		modelView.addObject("bugInfoList", getAllBugInfoItems());
		return new ModelAndView(NavigationOutCome.BUG_INFO_LIST, "message",
				"Bug Info List");
	}

	public BugInfoService getBugInfoService() {
		return bugInfoService;
	}

	public void setBugInfoService(BugInfoService bugInfoService) {
		this.bugInfoService = bugInfoService;
	}
	
	public List<BugInfo> getAllBugInfoItems(){
		return getBugInfoService().getBugList();
	}

}
