package com.flower.navigation.service;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.flower.navigation.common.AjaxEntity;
import com.flower.navigation.config.Global;
import com.flower.navigation.dao.UserDao;
import com.flower.navigation.entity.UserEntity;
import com.flower.navigation.utils.DateUtils;
import com.flower.navigation.utils.FileUtils;
import com.flower.navigation.utils.MD5Util;
import com.flower.navigation.utils.StringUtil;



@Service
public class SystemService {
	
	

	private Logger logger = LoggerFactory.getLogger(SystemService.class);
	
	@Autowired
	private UserDao userDao;
	
	@Value("${file.save.path}")
    private String fileSavePath;
	
    @Value("${file.save.staticAccessPath}")
    private String staticAccessPath;

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
		if(MD5Util.MD5(userEntity.getPassword()).equals(findByUsername.getPassword())) {
			Date date = new Date();
			findByUsername.setLasttime(Long.toString( date.getTime()));
			userDao.save(findByUsername);
			logger.info("用户"+userEntity.getUsername()+"登录成功");
			request.getSession().setAttribute(Global.user_session_key, findByUsername);
			return new AjaxEntity(Global.ajax_success, Global.ajax_login_success_message, null);
		}
		logger.info("用户"+userEntity.getUsername()+"登录失败");
		return new AjaxEntity(Global.ajax_login_err,Global.ajax_login_err_message,null);
	}
	


	
	/**
	 * 上传文件
	 * @param file
	 * @param req
	 * @param path
	 * @return
	 */
	public String uploadFile(MultipartFile  file, HttpServletRequest req,String path) {
		UserEntity attribute = (UserEntity) req.getSession().getAttribute(Global.user_session_key);
		String date = DateUtils.getDate("yyyy/MM/dd");
		String uploadpath =attribute.getUsername()+"/"+path+"/"+date+"/";
		FileUtils.createDirectory(fileSavePath+uploadpath);
		String oldName = file.getOriginalFilename();
        String newName = UUID.randomUUID().toString() +
                oldName.substring(oldName.lastIndexOf("."), oldName.length());
        try {
        	file.transferTo(new File(fileSavePath+uploadpath, newName));
            //返回虚拟映射
        	String replace = staticAccessPath.replace("**", "");
        	return replace+uploadpath+newName;
        } catch (IOException e) {
            e.printStackTrace();
            return "上传失败! ";
        }
		
	}

}