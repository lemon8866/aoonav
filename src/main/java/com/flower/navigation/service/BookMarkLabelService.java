package com.flower.navigation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flower.navigation.common.AjaxEntity;
import com.flower.navigation.config.Global;
import com.flower.navigation.dao.BookMarkLabelDao;
import com.flower.navigation.dao.BookMarkTypeDao;
import com.flower.navigation.entity.BookmarkLabelEntity;
import com.flower.navigation.entity.BookmarkTypeEntity;

@Service
public class BookMarkLabelService {
	
	@Autowired
	private BookMarkLabelDao bookMarkLabelDao;

	public AjaxEntity saveData(BookmarkLabelEntity data) {
		bookMarkLabelDao.save(data);
		return new AjaxEntity(Global.ajax_option_success, "操作成功", data);
	}
	public List<BookmarkLabelEntity>  findAll(){
		return bookMarkLabelDao.findAll();
	}
	
	public AjaxEntity delData(BookmarkLabelEntity data) {
		bookMarkLabelDao.deleteById(data.getId());
		return new AjaxEntity(Global.ajax_option_success, "操作成功", null);
	}
}
