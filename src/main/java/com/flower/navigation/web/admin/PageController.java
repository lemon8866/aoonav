package com.flower.navigation.web.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.flower.navigation.config.Global;
import com.flower.navigation.entity.BookmarkLabelEntity;
import com.flower.navigation.entity.BookmarkTypeEntity;
import com.flower.navigation.service.BookMarkLabelService;
import com.flower.navigation.service.BookMarkTypeService;
import com.flower.navigation.service.SiteService;

@Controller
@RequestMapping(value = "/admin")
public class PageController {
	
	@Autowired
	private SiteService siteService;
	
	@Autowired
	private BookMarkTypeService bookMarkTypeService;
	
	@Autowired
	private BookMarkLabelService bookMarkLabelService;
	
	
	@RequestMapping(value = "/admin")
	public String admin(HttpServletRequest request) {
		if(request.getSession().getAttribute(Global.user_session_key) ==  null) {
			return "admin/login";
		}else {
			return "admin/index";
		}
	}
	@RequestMapping(value = "/login")
	public String login(HttpServletRequest request) {
		if(request.getSession().getAttribute(Global.user_session_key) !=  null) {
			return "redirect:/admin/index";
		}
		return "admin/login";
	}

	@RequestMapping(value = "/index")
	public String index() {
		return "admin/index";
	}
	
	@RequestMapping(value = "/welcome")
	public String welcome() {
		return "admin/welcome";
	}
	@RequestMapping(value = "/loginOut")
	public String loginOut(HttpServletRequest request) {
		request.getSession().setAttribute(Global.user_session_key, null);
		return "admin/login";
	}
	@RequestMapping(value = "/userList")
	public String userList() {
		return "admin/userList";
	}
	@RequestMapping(value = "/addUser")
	public String addUser() {
		return "admin/addUser";
	}
	
	@RequestMapping(value = "/addBookLabel")
	public String addBookLabel() {
		return "admin/addBookLabel";
	}
	
	
	@RequestMapping(value = "/site")
	public String site(Model model) {
		model.addAttribute("site", siteService.getData());
		return "admin/site";
	}
	@RequestMapping(value = "/booklabel")
	public String booklabel(Model model) {
		List<BookmarkLabelEntity> findAll = bookMarkLabelService.findAll();
		model.addAttribute("list", findAll);
		return "admin/booklabel";
	}
	@RequestMapping(value = "/booktype")
	public String booktype(Model model) {
		List<BookmarkTypeEntity> findAll = bookMarkTypeService.findAll();
		model.addAttribute("list", findAll);
		return "admin/booktype";
	}
	@RequestMapping(value = "/bookList")
	public String bookList(Model model) {
		List<BookmarkLabelEntity> labelList = bookMarkLabelService.findAll();
		List<BookmarkTypeEntity> typeList = bookMarkTypeService.findAll();
		model.addAttribute("labelList", labelList);
		model.addAttribute("typeList", typeList);
		return "admin/bookList";
	}
	
	@RequestMapping(value = "/addBook")
	public String addBook(Model model) {
		List<BookmarkLabelEntity> labelList = bookMarkLabelService.findAll();
		List<BookmarkTypeEntity> typeList = bookMarkTypeService.findAll();
		model.addAttribute("labelList", labelList);
		model.addAttribute("typeList", typeList);
		return "admin/addBook";
	}
}
