package com.flower.navigation.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.flower.navigation.common.DataEntity;

@Entity
@Table(name = "biz_bookmark_label")
public class BookmarkLabelEntity extends DataEntity<BookmarkLabelEntity> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4034775633740982894L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE,generator="biz_bookmark_label")
	@TableGenerator(name = "biz_bookmark_label", allocationSize = 1, table = "seq_common", pkColumnName = "seq_id", valueColumnName = "seq_count")
    private Integer id;
	
	private String labelname;
	
	private String labelbgcolor;
	
	private String labelfontcolor;
	
	private String createtime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLabelname() {
		return labelname;
	}

	public void setLabelname(String labelname) {
		this.labelname = labelname;
	}

	public String getLabelbgcolor() {
		return labelbgcolor;
	}

	public void setLabelbgcolor(String labelbgcolor) {
		this.labelbgcolor = labelbgcolor;
	}

	public String getLabelfontcolor() {
		return labelfontcolor;
	}

	public void setLabelfontcolor(String labelfontcolor) {
		this.labelfontcolor = labelfontcolor;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	
	
	

}
