package com.flower.navigation.service;

import java.util.Date;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.flower.navigation.dao.UserDao;
import com.flower.navigation.entity.UserEntity;
import com.flower.navigation.utils.MD5Util;
import com.flower.navigation.utils.StringUtil;

@Service
public class UserService {
	
	private Logger logger = LoggerFactory.getLogger(UserService.class);
		
	@Autowired
	private UserDao userDao;

	/**  
	
	 * <p>Title: findUserList</p>  
	
	 * <p>Description:分页获取管理员列表 </p>  
	
	 * @param res
	 * @return  
	
	 */  
	public AjaxEntity findUserList(RequestEntity res) {
		int page = res.getPage()==  null ?0:res.getPage();
		int limit = res.getLimit() == null?15:res.getLimit();
		Pageable pageable = PageRequest.of(page,limit, Sort.Direction.ASC,"lasttime");
		Specification<UserEntity> specification = new Specification<UserEntity>() {

			@Override
			public Predicate toPredicate(Root<UserEntity> root, CriteriaQuery<?> query,
					CriteriaBuilder criteriaBuilder) {
				Predicate predicate=criteriaBuilder.conjunction();
//				UserEntity seachDate = (UserEntity) res.getSeachDate();
//				if(seachDate != null && StringUtil.isString(seachDate.getUsername())) {
//					predicate.getExpressions().add(criteriaBuilder.like(root.get("username"), "%"+seachDate.getUsername()+"%"));
//				}
				return predicate;
			}};
			
		Page<UserEntity> findAll = userDao.findAll(specification,pageable);
		
		
		return new AjaxEntity(Global.ajax_success, "数据获取成功", findAll);
	}

	/**  
	
	 * <p>Title: addUser</p>  
	
	 * <p>Description: 添加用户</p>  
	
	 * @param userEntity
	 * @return  
	
	 */  
	public AjaxEntity addUser(UserEntity userEntity) {
		if(!StringUtil.isString(userEntity.getUsername()) || !StringUtil.isString(userEntity.getPassword())) {
			return new AjaxEntity(Global.ajax_uri_error,Global.ajax_uri_error_message,null);
		}
		UserEntity findByUsername = userDao.findByUsername(userEntity.getUsername());
		if(findByUsername != null) {
			return new AjaxEntity(Global.ajax_add_user_err,Global.ajax_add_user_err_message,null);
		}
		Date date = new Date();
		userEntity.setLasttime(Long.toString(date.getTime()));
		userEntity.setPassword(MD5Util.MD5(userEntity.getPassword()));
		userDao.save(userEntity);
		return new AjaxEntity(Global.ajax_success, Global.ajax_add_user_success_message, null);
	}

	public AjaxEntity delUser(UserEntity userEntity) {
		userDao.deleteById(userEntity.getId());
		return new AjaxEntity(Global.ajax_success, Global.ajax_option_success, null);
	}

}