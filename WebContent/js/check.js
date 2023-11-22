function trim(str) { // 删除左右两端的空格
	return str.replace(/(^\s*)|(\s*$)/g, "");
}

function validateForm() {
	var contributor_name = document.getElementById("contributor_name");
	var contributor_password = document.getElementById("contributor_password");
	var rcontributor_password = document
			.getElementById("rcontributor_password");
	var contributor_phone = document.getElementById("contributor_phone");
	var contributor_mail = document.getElementById("contributor_mail");
	var project_name = document.getElementById("project_name");
	var team_name = document.getElementById("team_name");
	
	//邮箱验证
	var emailReg = new RegExp("^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$");
	
	//手机号码验证
	var phoneReg = /^1[3-578]\d{9}$/;

	
	if (trim(contributor_name.value) == null
			|| trim(contributor_name.value) == "") {
		alert("请输入用户名");
		contributor_name.focus();
		return false;
	}
	if (trim(contributor_password.value) == null
			|| trim(contributor_password.value) == "") {
		alert("请输入密码");
		contributor_password.focus();
		return false;
	}
	if (trim(rcontributor_password.value) == null
			|| trim(rcontributor_password.value) == "") {
		alert("请重复输入密码");
		rcontributor_password.focus();
		return false;
	}
	if (trim(contributor_phone.value) == null
			|| trim(contributor_phone.value) == "") {
		alert("请输入联系方式");
		contributor_phone.focus();
		return false;
	}
	
	if(!phoneReg.test(contributor_phone.value)){
		alert("联系方式格式不对")
		return false;
		
	}
	
	if (trim(contributor_mail.value) == null
			|| trim(contributor_mail.value) == "") {
		alert("请输入邮箱");
		contributor_mail.focus();
		return false;
	}
	
	if(!emailReg.test(contributor_mail.value)){
		alert("邮箱格式不对")
		return false;
		
	}
	
	
	if (trim(project_name.value) == null || trim(project_name.value) == "") {
		alert("请输入项目名称");
		project_name.focus();
		return false;
	}
	if (trim(team_name.value) == null || trim(team_name.value) == "") {
		alert("请输入团队名称");
		team_name.focus();
		return false;
	}
	
	return true;
}