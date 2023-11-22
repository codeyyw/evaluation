package com.yyw.utils;

import com.yyw.entity.Admin;

public class AdminVerify {
	
	private static String adminName = Admin.getAdminName();
	private static String adminPwd = Admin.getAdminPassword();
	
	public static boolean verify(String loginName,String loginPwd) {
		
		if(adminName.equals(loginName)&&adminPwd.equals(loginPwd)) {
			
			System.out.println("管理员信息正确，成功登录");
			return true;
		}
		return false;
		
	};

}
