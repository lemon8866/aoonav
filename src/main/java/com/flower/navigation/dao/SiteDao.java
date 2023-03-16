package com.flower.navigation.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.flower.navigation.entity.SiteEntity;

@Repository
@Transactional
public interface SiteDao extends PagingAndSortingRepository<SiteEntity, Integer>, JpaSpecificationExecutor<SiteEntity>{

	
	public List<SiteEntity> findAll();
	
	

}
