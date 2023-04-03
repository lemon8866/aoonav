package com.flower.navigation.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.flower.navigation.common.AjaxEntity;
import com.flower.navigation.config.Global;
import com.flower.navigation.dao.SiteDao;
import com.flower.navigation.entity.SiteEntity;

@Service
public class SiteService {
	
	@Autowired
	private SiteDao siteDao;
	
	public SiteEntity getData() {
		List<SiteEntity> findAll = siteDao.findAll();
		if(findAll.size() == 0) {
			SiteEntity siteEntity = new SiteEntity();
			siteEntity.setSiterule("0");
			siteEntity.setId(19950915);
			return siteEntity;
		}else {
			return findAll.get(0);
		}
	}
	
	public AjaxEntity saveData(SiteEntity site) {
		System.out.println(site.toString());
		if(site.getSiterule() !=null) {
			siteDao.save(site);
		}
		return new AjaxEntity(Global.ajax_option_success, "操作成功", site);
	}

}
