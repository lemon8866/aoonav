package com.flower.navigation.service;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.flower.navigation.common.AjaxEntity;
import com.flower.navigation.config.Global;
import com.flower.navigation.dao.BookMarkLabelDao;
import com.flower.navigation.dao.BookMarkTypeDao;
import com.flower.navigation.entity.BookmarkEntity;
import com.flower.navigation.entity.BookmarkLabelEntity;
import com.flower.navigation.entity.BookmarkTypeEntity;
import com.flower.navigation.utils.DateUtils;
import com.flower.navigation.utils.StringUtil;

@Service
public class BookMarkLabelService {
	
	@Autowired
	private BookMarkLabelDao bookMarkLabelDao;

	public AjaxEntity saveData(BookmarkLabelEntity data) {
		data.setCreatetime(DateUtils.getDate("yyyy-MM-dd HH:mm:ss"));
		bookMarkLabelDao.save(data);
		return new AjaxEntity(Global.ajax_success, "操作成功", data);
	}
	public List<BookmarkLabelEntity>  findAll(){
		return bookMarkLabelDao.findAll();
	}
	
	public AjaxEntity delData(BookmarkLabelEntity data) {
		bookMarkLabelDao.deleteById(data.getId());
		return new AjaxEntity(Global.ajax_option_success, "操作成功", null);
	}
	public AjaxEntity findPage(BookmarkLabelEntity res) {
		PageRequest of= PageRequest.of(res.getPageNo(), res.getPageSize());
		Specification<BookmarkLabelEntity> specification = new Specification<BookmarkLabelEntity>() {

			@Override
			public Predicate toPredicate(Root<BookmarkLabelEntity> root, CriteriaQuery<?> query,
					CriteriaBuilder criteriaBuilder) {
				Predicate predicate=	criteriaBuilder.conjunction();
				if(res != null && StringUtil.isString(res.getLabelname())) {
					predicate.getExpressions().add(criteriaBuilder.like(root.get("labelname"), "%"+res.getLabelname()+"%"));
				}
//				query.orderBy(criteriaBuilder.desc(root.get("id")));
				return predicate;
			}
			
		};
		Page<BookmarkLabelEntity> findAll = bookMarkLabelDao.findAll(specification,of);
		return new AjaxEntity(Global.ajax_success, "数据获取成功", findAll);
	}
	public List<BookmarkLabelEntity> findList(BookmarkLabelEntity res) {
		PageRequest of= PageRequest.of(res.getPageNo(), 9999);
		Specification<BookmarkLabelEntity> specification = new Specification<BookmarkLabelEntity>() {

			@Override
			public Predicate toPredicate(Root<BookmarkLabelEntity> root, CriteriaQuery<?> query,
					CriteriaBuilder criteriaBuilder) {
				Predicate predicate=	criteriaBuilder.conjunction();
				if(res != null && StringUtil.isString(res.getLabelname())) {
					predicate.getExpressions().add(criteriaBuilder.like(root.get("labelname"), "%"+res.getLabelname()+"%"));
				}
//				query.orderBy(criteriaBuilder.desc(root.get("id")));
				return predicate;
			}
			
		};
		Page<BookmarkLabelEntity> findAll = bookMarkLabelDao.findAll(specification,of);
		return findAll.getContent();
	}
}
