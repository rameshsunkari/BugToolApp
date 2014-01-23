package com.bugtool.web.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.bugtool.model.UserInfo;

public class LoginValidator implements Validator {

	@Override
	public boolean supports(Class<?> className) {
		return UserInfo.class.isAssignableFrom(className);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName",
				"required.userName", "Field name is required.");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pswd",
				"required.password", "password field is required.");
	}

}
