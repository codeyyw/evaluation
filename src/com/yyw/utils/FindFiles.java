package com.yyw.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FindFiles {

	public static List<String> findfileNames(String projectName) {
		
		List<String> fileNameList = new ArrayList<String>();
		String basePath = "D:\\evauation\\uploads\\" + projectName;
		File fileDir = new File(basePath);
		if (fileDir.exists()) {

			File[] files = fileDir.listFiles();

			if (null == files || files.length == 0) {

				System.out.println("项目没有附件!");
			} else {

				for (File file : files) {
					String fileName = file.getName();
					System.out.println(fileName);
					String hrefName = "/pImg/"+projectName+"/"+fileName;
					fileNameList.add(hrefName);		
				}
				//用list添加，用String[]返回
			}
		}
		return fileNameList;
	}
}
