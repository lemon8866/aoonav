package com.flower.navigation.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class UploadConfig implements WebMvcConfigurer {
	
	

    @Value("${file.save.staticAccessPath}")
    private String staticAccessPath;
    @Value("${file.save.path}")
    private String uploadRealPath;
	
	 @Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        registry.addResourceHandler(staticAccessPath).addResourceLocations("file:"+uploadRealPath);
	    }


}
