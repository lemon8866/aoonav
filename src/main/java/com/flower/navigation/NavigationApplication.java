package com.flower.navigation;

import java.io.File;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.flower.navigation.utils.FileUtil;



@SpringBootApplication
public class NavigationApplication {
	
	

	public static void main(String[] args) {
		NavigationApplication.initData();
		SpringApplication.run(NavigationApplication.class, args);
	}

	public static void initData() {
		try {
			  FileUtil.copyDir("/home/app/static", "/app/static");
			
			  File destDir = new File("/app/db/app.db");
			  if(!destDir.exists()) {
				  FileUtil.copyDir("/home/app/db", "/app/db");
			  }
		} catch (Exception e) {
		}
	}


	
	

}
