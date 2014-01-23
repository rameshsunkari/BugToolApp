package com.bugtool.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.bugtool.model.EnvInfo;
import com.bugtool.service.EnvInfoService;
import com.bugtool.util.NavigationOutCome;

@Controller
public class EnvInfoController extends MultiActionController{

	@Autowired
	private EnvInfoService envInfoService;

	@RequestMapping("/envInfoAdd")
	public ModelAndView addEnvInfo(Model model,HttpSession session) {
		List<EnvInfo> envList = (List<EnvInfo>) session.getAttribute("envInfoList");
		System.out.println(envList!= null ?envList.size(): 0);
		model.addAttribute("envInfo", new EnvInfo());
		ModelAndView modelView = new ModelAndView(
				NavigationOutCome.ADD_ENV_DETAIL, "message",
				"Add Environment Details");
		return modelView;
	}

	@RequestMapping("/envInfoList")
	public ModelAndView showEnvInfoList() {
		ModelAndView modelView = new ModelAndView();
		modelView.addObject("envInfoList", getEnvInfoList());
		return new ModelAndView(NavigationOutCome.ENV_INFO_LIST, "message",
				"Environment List");
	}

	public EnvInfoService getEnvInfoService() {
		return envInfoService;
	}

	public void setEnvInfoService(EnvInfoService envInfoService) {
		this.envInfoService = envInfoService;
	}
	
	public List<EnvInfo> getEnvInfoList(){
		return getEnvInfoService().getEnvironmentList();
	}
	
	
	public ModelAndView getEnvList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("envInfoList");
		
		// get data
		List<EnvInfo> searchResults = getEnvInfoService().getEnvironmentList();
		
		// initialize PagedListHolder with our list, set current page defaulted to 0, and pass it to the view
		PagedListHolder<EnvInfo> pagedListHolder = new PagedListHolder<EnvInfo>(searchResults);
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		int pageSize = 10;
		pagedListHolder.setPageSize(pageSize);
		mav.addObject("pagedListHolder", pagedListHolder);
		
		return mav;
	}
}
