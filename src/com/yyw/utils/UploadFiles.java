package com.yyw.utils;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class UploadFiles {
	public static Boolean saveFiles(MultipartFile[] files, String filePath) {

		Boolean isUpload = false;
		if (null != files && files.length > 0) {
			for (MultipartFile file : files) {

				if(null != file) {
				// 获取原始文件的拓展名
				String originalFilename = file.getOriginalFilename();	
				// 封装上传文件位置的全路径，就是硬盘路径+文件名
				File targetFile = new File(filePath, originalFilename);
				// 把本地文件上传到已经封装好的文件位置的全路径就是上面的targetFile
				try {
					file.transferTo(targetFile);
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				}
			}
			isUpload = true;
		} else {
			System.out.println("没有添加申报书附件");
			return true;
		}
		return isUpload;
	}
}
