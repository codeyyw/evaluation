package com.yyw.entity;

public class Admin {
	public static final String admin_name = "yuanyiwei";
	public static final String admin_password = "yyw123321";
	  // 私有构造
	
    private Admin() {}

    public static String getAdminName() {
		return admin_name;
	}

	public static String getAdminPassword() {
		return admin_password;
	}

	private static Admin single = new Admin();

    // 静态工厂方法
    public static Admin getInstance() {
        return single;
    }
	

}
