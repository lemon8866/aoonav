package com.flower.navigation.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flower.navigation.common.AjaxEntity;
import com.flower.navigation.config.Global;
import com.flower.navigation.entity.BookmarkEntity;
import com.flower.navigation.entity.BookmarkTypeEntity;
import com.flower.navigation.entity.SiteEntity;
import com.flower.navigation.service.BookMarkService;
import com.flower.navigation.service.BookMarkTypeService;
import com.flower.navigation.service.SiteService;
import com.flower.navigation.utils.DataUtil;

@Controller
public class IndexController {
	
	@Autowired
	private SiteService siteService;
	
	
	@Autowired
	private BookMarkService bookMarkService;
	
	@Autowired
	private BookMarkTypeService bookMarkTypeService;
	
	
	@RequestMapping(value = {"/","","/index"})
	public String index(HttpServletRequest request,Model model) {
		SiteEntity data = siteService.getData();
		model.addAttribute("sitename", data.getSitename());
		model.addAttribute("siteicon", data.getSiteicon());
		model.addAttribute("sitedesc", data.getSitedesc());
		if(request.getSession().getAttribute(Global.user_session_key) !=  null) {
			List<BookmarkTypeEntity> findAll = bookMarkTypeService.findAll();
			model.addAttribute("list", findAll);
		}
		return "front/index";
	}
	
	
	@RequestMapping(value = "nurule")
	public String nurule() {
		return "front/nurule";
	}
	
	@ResponseBody
	@RequestMapping(value = "/getNavData")
	public AjaxEntity getNavData(HttpServletRequest request) {
		SiteEntity data = siteService.getData();
		String rule = data.getSiterule() == null ? "0":data.getSiterule();  //默认需要登录
		
		BookmarkEntity bookmarkEntity = new BookmarkEntity();
		if(request.getSession().getAttribute(Global.user_session_key) ==  null) {
			if(rule.equals("0")) {
				return new AjaxEntity(Global.ajax_nav_no_rule, Global.ajax_nav_no_rule_message, null);
			}
			bookmarkEntity.setBookmarkrule("1");
			List<BookmarkEntity> findList = bookMarkService.findList(bookmarkEntity);
			Map<String, List<BookmarkEntity>> dataTransferred = DataUtil.dataTransferred(findList);
			return new AjaxEntity(Global.ajax_success, Global.ajax_option_success, dataTransferred);
		}else {
			String typeid = request.getParameter("typeid");
			if(typeid != null && !typeid.equals("")) {
				bookmarkEntity.setTypeid(typeid);
			}
			bookmarkEntity.setBookmarkrule(null);
			List<BookmarkEntity> findList = bookMarkService.findList(bookmarkEntity);
			Map<String, List<BookmarkEntity>> dataTransferred = DataUtil.dataTransferred(findList);

			return new AjaxEntity(Global.ajax_success, Global.ajax_option_success, dataTransferred);
		}
	}


}
