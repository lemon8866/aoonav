package com.flower.navigation.service;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flower.navigation.common.AjaxEntity;
import com.flower.navigation.config.Global;
import com.flower.navigation.dao.UserDao;
import com.flower.navigation.entity.UserEntity;
import com.flower.navigation.utils.StringUtil;


@Service
public class SystemService {
	
	

	private Logger logger = LoggerFactory.getLogger(SystemService.class);
	
	@Autowired
	private UserDao userDao;

	/**  
	
	 * <p>Title: loginUser</p>  
	
	 * <p>Description:登录用户 </p>  
	
	 * @param userEntity
	 * @param request
	 * @return  
	
	 */  
	public AjaxEntity loginUser(UserEntity userEntity,HttpServletRequest request) {
	
		if(!StringUtil.isString(userEntity.getPassword()) || !StringUtil.isString(userEntity.getUsername())) {
			return new AjaxEntity(Global.ajax_uri_error,Global.ajax_uri_error_message,null);
		}
		logger.info("用户"+userEntity.getUsername()+"尝试登录");
		UserEntity findByUsername = userDao.findByUsername(userEntity.getUsername());
		if(findByUsername == null) {
			logger.info("用户"+userEntity.getUsername()+"登录失败");
			return new AjaxEntity(Global.ajax_login_err,Global.ajax_login_err_message,null);
		}
		if(userEntity.getPassword().equals(findByUsername.getPassword())) {
			Date date = new Date();
			findByUsername.setLasttime(Long.toString( date.getTime()));
			userDao.save(findByUsername);
			logger.info("用户"+userEntity.getUsername()+"登录成功");
			request.getSession().setAttribute(Global.user_session_key, findByUsername+Long.toString(System.currentTimeMillis()));
			return new AjaxEntity(Global.ajax_success, Global.ajax_login_success_message, null);
		}
		logger.info("用户"+userEntity.getUsername()+"登录失败");
		return new AjaxEntity(Global.ajax_login_err,Global.ajax_login_err_message,null);
	}
	




}