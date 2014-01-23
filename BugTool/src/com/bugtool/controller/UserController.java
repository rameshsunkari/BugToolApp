package com.bugtool.controller;

import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.bugtool.model.UserInfo;
import com.bugtool.service.UserService;
import com.bugtool.util.BugToolConstants;
import com.bugtool.util.NavigationOutCome;

@Controller
@SessionAttributes({"userInfoObj", "userImage"})
public class UserController {

	@Autowired
	private UserService userService;
	
	private UserInfo userInfo;

	@RequestMapping("/checkUserLogin")
	public ModelAndView checkUserLogin(HttpServletRequest req,
			HttpServletResponse resp) {
		ModelAndView modelView = new ModelAndView();
		String userName = req.getParameter(BugToolConstants.USERNAME);
		String pass = req.getParameter(BugToolConstants.PASSWORD);
		
		boolean success = getUserService().checkUserLogin(userName, pass);

		if (success) {
			userInfo = getUserService().findUserByEmail(userName);
			req.getSession().setAttribute(BugToolConstants.user, userInfo);
			modelView = new ModelAndView(NavigationOutCome.SUCCESS, "message",
					userName + " Logged in successfully");
		} else {
			modelView = new ModelAndView(NavigationOutCome.FAILURE, "message",
					"Log in Failed");
		}

		return modelView;
	}

	@RequestMapping("/login")
	public ModelAndView loginPage() {
		return new ModelAndView("login", "message", "User Login Page");
	}

	@RequestMapping("/userLogin")
	public ModelAndView userLogin(Model model) {
		model.addAttribute("userInfo", new UserInfo());
		ModelAndView modelView = new ModelAndView(NavigationOutCome.USER_LOGIN, "message", "User Login Page");
		return modelView;
	}

	@RequestMapping(value = "/checkLogin", method = RequestMethod.POST)
	public ModelAndView checkLogin(
			@ModelAttribute("userInfo") UserInfo userInfo,
			BindingResult bindingResult) {
		ModelAndView modelView = new ModelAndView();
		String userName = userInfo.getEmailid();
		String pass = userInfo.getPswd();

		boolean success = getUserService().checkUserLogin(userName, pass);

		if (success) {
			userInfo = getUserService().findUserByEmail(userName);
			modelView = new ModelAndView("success", "message", userName
					+ " Logged in successfully");
			modelView.addObject("userInfoObj", userInfo);
		} else {
			modelView = new ModelAndView("failure", "message", "Log in Failed");
		}

		return modelView;
	}

	@RequestMapping("/showLoginAgain")
	public ModelAndView showLoginAgain(Model model) {
		model.addAttribute("userInfo", new UserInfo());
		ModelAndView modelView = new ModelAndView(NavigationOutCome.USER_LOGIN, "message", "Login Again");
		return modelView;
	}

	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		UserInfo user = (UserInfo) session.getAttribute("userInfoObj");
		return new ModelAndView("logout", "message", "Logged Out Successfully");
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	
	
	public void showImage(UserInfo userInfo, ModelAndView modelView){
		byte[] userImage = userInfo.getPic();
		FileOutputStream fos = null;
//		InputStream is = userInfo.getPic();
		 
        try{
            fos = new FileOutputStream("D:\\test.jpg"); 
            fos.write(userImage);
            fos.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        modelView.addObject("userImage", fos);
	}
	
	
	
}
