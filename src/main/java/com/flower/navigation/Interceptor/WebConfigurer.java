package com.flower.navigation.Interceptor;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @Auther:
 * @Date: 
 * @Description: 在web的配置文件中，实例化登陆的拦截器，并添加规则
 */
@Configuration
public class WebConfigurer implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
        .addPathPatterns("/admin/**")
        .excludePathPatterns("/admin/api/login")
        .excludePathPatterns("/admin/login")
        .excludePathPatterns("/admin/loginOut")
        .excludePathPatterns("/static/**");
    }
}