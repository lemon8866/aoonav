package com.flower.navigation.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.flower.navigation.entity.UserEntity;


@Repository
@Transactional
public interface UserDao extends PagingAndSortingRepository<UserEntity, Integer>, JpaSpecificationExecutor<UserEntity>{

	UserEntity findByUsername(String username);
	
	

}
