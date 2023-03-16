package com.flower.navigation.service;

import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.flower.navigation.common.AjaxEntity;
import com.flower.navigation.common.RequestEntity;
import com.flower.navigation.config.Global;
import com.flower.navigation.dao.BookMarkDao;
import com.flower.navigation.entity.BookmarkEntity;
import com.flower.navigation.entity.UserEntity;
import com.flower.navigation.utils.StringUtil;

@Service
public class BookMarkService {
	
	@Autowired
	private BookMarkDao bookMarkDao;

	
	public AjaxEntity findPage(BookmarkEntity res) {
		PageRequest of= PageRequest.of(res.getPageNo(), res.getPageSize());
		Specification<BookmarkEntity> specification = new Specification<BookmarkEntity>() {

			@Override
			public Predicate toPredicate(Root<BookmarkEntity> root, CriteriaQuery<?> query,
					CriteriaBuilder criteriaBuilder) {
				Predicate predicate=criteriaBuilder.conjunction();
				BookmarkEntity seachDate = (BookmarkEntity) res;
				if(seachDate != null && StringUtil.isString(seachDate.getTypeid())) {
					predicate.getExpressions().add(criteriaBuilder.like(root.get("typeid"), "%"+seachDate.getTypeid()+"%"));
				}
				if(seachDate != null && StringUtil.isString(seachDate.getLabelid())) {
					predicate.getExpressions().add(criteriaBuilder.like(root.get("labelid"), "%"+seachDate.getLabelid()+"%"));
				}
				if(seachDate != null && StringUtil.isString(seachDate.getBookmarkrule())) {
					predicate.getExpressions().add(criteriaBuilder.like(root.get("bookmarkrule"), "%"+seachDate.getBookmarkrule()+"%"));
				}
				if(seachDate != null && StringUtil.isString(seachDate.getBookmarkname())) {
					predicate.getExpressions().add(criteriaBuilder.like(root.get("bookmarkname"), "%"+seachDate.getBookmarkname()+"%"));
				}
				return predicate;
			}};
			Page<BookmarkEntity> findAll = bookMarkDao.findAll(specification,of);
			return new AjaxEntity(Global.ajax_success, "数据获取成功", findAll);
	}
	
	public List<BookmarkEntity> findList(BookmarkEntity res) {
		PageRequest of= PageRequest.of(0, 9999);
		Specification<BookmarkEntity> specification = new Specification<BookmarkEntity>() {

			@Override
			public Predicate toPredicate(Root<BookmarkEntity> root, CriteriaQuery<?> query,
					CriteriaBuilder criteriaBuilder) {
				Predicate predicate=criteriaBuilder.conjunction();
				BookmarkEntity seachDate = (BookmarkEntity) res;
				if(seachDate != null && StringUtil.isString(seachDate.getTypeid())) {
					predicate.getExpressions().add(criteriaBuilder.like(root.get("typeid"), "%"+seachDate.getTypeid()+"%"));
				}
				if(seachDate != null && StringUtil.isString(seachDate.getLabelid())) {
					predicate.getExpressions().add(criteriaBuilder.like(root.get("labelid"), "%"+seachDate.getLabelid()+"%"));
				}
				if(seachDate != null && StringUtil.isString(seachDate.getBookmarkrule())) {
					predicate.getExpressions().add(criteriaBuilder.like(root.get("bookmarkrule"), "%"+seachDate.getBookmarkrule()+"%"));
				}
				if(seachDate != null && StringUtil.isString(seachDate.getBookmarkname())) {
					predicate.getExpressions().add(criteriaBuilder.like(root.get("bookmarkname"), "%"+seachDate.getBookmarkname()+"%"));
				}
				return predicate;
			}};
			Page<BookmarkEntity> findAll = bookMarkDao.findAll(specification,of);
			return findAll.getContent();
	}
	
	public AjaxEntity addBookData(BookmarkEntity data) {
		String time =Long.toString( new Date().getTime());
		data.setCreatetime(time);
		bookMarkDao.save(data);
		return new AjaxEntity(Global.ajax_success, Global.ajax_option_success, data);
	}
	
	public AjaxEntity delBookData(BookmarkEntity data) {
		bookMarkDao.deleteById(data.getId());
		return new AjaxEntity(Global.ajax_success, Global.ajax_option_success, data);
	}
}
