package com.flower.navigation.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.flower.navigation.config.Global;
import com.flower.navigation.entity.UserEntity;



/**  

* <p>Title: LoginInterceptor</p>  

* <p>Description:登录拦截器 </p>  

* @author QingFeng  

* @date 2020年8月14日  

*/  
public class LoginInterceptor implements HandlerInterceptor  {
	
	 private Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	
	 @Override
     public boolean preHandle(HttpServletRequest request,
                              HttpServletResponse response, Object handler) throws Exception {

         UserEntity user = (UserEntity)request.getSession().getAttribute(Global.user_session_key);
         logger.info(request.getRequestURI().toString());
         if (user == null || user.equals(""))  {
             response.sendRedirect("/admin/login");
             return false;
         }
         return true;
     }

     @Override
     public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
         logger.info("postHandle...");
     }

     @Override
     public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
         logger.info("afterCompletion...");
     }

}
