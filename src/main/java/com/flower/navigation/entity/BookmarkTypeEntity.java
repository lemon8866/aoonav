package com.flower.navigation.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "biz_bookmark_type")
public class BookmarkTypeEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8811444374071571169L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE,generator="biz_bookmark_type")
	@TableGenerator(name = "biz_bookmark_type", allocationSize = 1, table = "seq_common", pkColumnName = "seq_id", valueColumnName = "seq_count")
    private Integer id;
	
	
	private String typename;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getTypename() {
		return typename;
	}


	public void setTypename(String typename) {
		this.typename = typename;
	}
	
	

}
