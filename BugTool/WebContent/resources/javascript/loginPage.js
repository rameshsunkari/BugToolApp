;
$(function() {

	bugtool = {};
	bugtool.loginPage = {};
	bugtool.loginPage.checkSubmit = (function() {
		var email = $('#userName');
		var pswd = $('#pswd');

		var emailValidate = bugtool.loginPage.checkEmail(email);
		var pswdValidate = bugtool.loginPage.checkPass(pswd);
		return emailValidate && pswdValidate;

	});

	bugtool.loginPage.checkEmail = (function(uNameField) {
		var filter = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
		if (!filter.test(uNameField.val())) {
			alert('Please provide a valid email address');
			uNameField.focus;
			return false;
		}
		return true;
	});

	bugtool.loginPage.checkPass = (function(pswdField) {
		var pswd = pswdField.val();

		if (pswd == '' || pswd == null) {
			alert('Please provide a valid password');
			return false;
		}

		return true;

	});

});
