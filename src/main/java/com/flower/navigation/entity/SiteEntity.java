package com.flower.navigation.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "biz_site")
public class SiteEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1150214400384279522L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE,generator="biz_site")
	@TableGenerator(name = "biz_site", allocationSize = 1, table = "seq_common", pkColumnName = "seq_id", valueColumnName = "seq_count")
    private Integer id;
	
	private String sitename;
	
	private String siteicon;
	
	private String sitedesc;
	
	private String siterule;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSitename() {
		return sitename;
	}

	public void setSitename(String sitename) {
		this.sitename = sitename;
	}

	public String getSiteicon() {
		return siteicon;
	}

	public void setSiteicon(String siteicon) {
		this.siteicon = siteicon;
	}

	public String getSiterule() {
		return siterule;
	}

	public void setSiterule(String siterule) {
		this.siterule = siterule;
	}

	public String getSitedesc() {
		return sitedesc;
	}

	public void setSitedesc(String sitedesc) {
		this.sitedesc = sitedesc;
	}
	
	

}
