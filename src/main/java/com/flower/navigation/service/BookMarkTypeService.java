package com.flower.navigation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.flower.navigation.common.AjaxEntity;
import com.flower.navigation.config.Global;
import com.flower.navigation.dao.BookMarkTypeDao;
import com.flower.navigation.entity.BookmarkTypeEntity;

@Service
public class BookMarkTypeService {
	
	@Autowired
	private BookMarkTypeDao bookMarkTypeDao;

	public AjaxEntity saveData(BookmarkTypeEntity data) {
		bookMarkTypeDao.save(data);
		return new AjaxEntity(Global.ajax_option_success, "操作成功", data);
	}
	public List<BookmarkTypeEntity>  findAll(){
		PageRequest of= PageRequest.of(0,999);
		Page<BookmarkTypeEntity> findAll = bookMarkTypeDao.findAll(of);
		return findAll.getContent();
		
		
	}
	
	public AjaxEntity delData(BookmarkTypeEntity data) {
		bookMarkTypeDao.deleteById(data.getId());
		return new AjaxEntity(Global.ajax_option_success, "操作成功", null);
	}
}
