package com.flower.navigation.web.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flower.navigation.common.AjaxEntity;
import com.flower.navigation.common.RequestEntity;
import com.flower.navigation.entity.BookmarkEntity;
import com.flower.navigation.entity.BookmarkLabelEntity;
import com.flower.navigation.entity.BookmarkTypeEntity;
import com.flower.navigation.entity.SiteEntity;
import com.flower.navigation.entity.UserEntity;
import com.flower.navigation.service.BookMarkLabelService;
import com.flower.navigation.service.BookMarkService;
import com.flower.navigation.service.BookMarkTypeService;
import com.flower.navigation.service.SiteService;
import com.flower.navigation.service.SystemService;
import com.flower.navigation.service.UserService;

@RestController
@RequestMapping("/admin/api")
public class AdminController {
	
	@Autowired
	private SystemService systemService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private SiteService siteService;
	
	
	@Autowired
	private BookMarkTypeService bookMarkTypeService;
	
	
	@Autowired
	private BookMarkLabelService bookMarkLabelService;
	
	@Autowired
	private BookMarkService bookMarkService;
	
	
	/**  
	
	 * <p>Title: login</p>  
	
	 * <p>Description:用户管理员登录 </p>  
	
	 * @param userEntity
	 * @return  
	
	 */  
	@PostMapping(value = "/login")
	public AjaxEntity login(UserEntity userEntity,HttpServletRequest request) {
		return systemService.loginUser(userEntity,request);
	}
/**  
	
	 * <p>Title: findUserList</p>  
	
	 * <p>Description:分页获取管理员的列表 </p>  
	
	 * @param res
	 * @param request
	 * @return  
	
	 */  
	@PostMapping(value = "/findUserList")
	public AjaxEntity findUserList(RequestEntity res,HttpServletRequest request) {
		return userService.findUserList(res);
	}
	
	/**  
	
	 * <p>Title: addUser</p>  
	
	 * <p>Description: 添加用户</p>  
	
	 * @param userEntity
	 * @param request
	 * @return  
	
	 */  
	@PostMapping(value = "/addUser")
	public AjaxEntity addUser(UserEntity userEntity,HttpServletRequest request) {
		return userService.addUser(userEntity);
	}
	
	@GetMapping(value = "/delUser")
	public AjaxEntity delUser(UserEntity userEntity,HttpServletRequest request) {
		return userService.delUser(userEntity);
	}
	
	@PostMapping(value = "/saveSite")
	public AjaxEntity saveSite(SiteEntity site) {
		return siteService.saveData(site);
	}
	
	@PostMapping(value = "/savebookType")
	public AjaxEntity savebookType(BookmarkTypeEntity data) {
		return bookMarkTypeService.saveData(data);
	}
	
	@GetMapping(value = "/delbookType")
	public AjaxEntity delbookType(BookmarkTypeEntity data,HttpServletRequest request) {
		return bookMarkTypeService.delData(data);
	}
	
	
	@PostMapping(value = "/savebookLabel")
	public AjaxEntity savebookLabel(BookmarkLabelEntity data) {
		return bookMarkLabelService.saveData(data);
	}
	
	@PostMapping(value = "/findbookLabel")
	public AjaxEntity findbookLabel(BookmarkLabelEntity data) {
		return bookMarkLabelService.findPage(data);
	}
	
	
	@GetMapping(value = "/delbookLabel")
	public AjaxEntity delbookLabel(BookmarkLabelEntity data,HttpServletRequest request) {
		return bookMarkLabelService.delData(data);
	}
	
	@PostMapping(value = "/findBookList")
	public AjaxEntity findBookList(BookmarkEntity res,HttpServletRequest request) {
		return bookMarkService.findPage(res);
	}
	
	@PostMapping(value = "/addBookMark")
	public AjaxEntity addBookMark(BookmarkEntity data,HttpServletRequest request) {
		return bookMarkService.addBookData(data);
	}
	
	@GetMapping(value = "/delBookMark")
	public AjaxEntity delBookMark(BookmarkEntity data,HttpServletRequest request) {
		return bookMarkService.delBookData(data);
	}
} 
