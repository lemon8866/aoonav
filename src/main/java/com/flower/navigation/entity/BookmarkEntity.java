package com.flower.navigation.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;

import com.flower.navigation.common.DataEntity;

@Entity
@Table(name = "biz_bookmark")
public class BookmarkEntity extends DataEntity<BookmarkEntity> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4960969983013089628L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE,generator="biz_bookmark")
	@TableGenerator(name = "biz_bookmark", allocationSize = 1, table = "seq_common", pkColumnName = "seq_id", valueColumnName = "seq_count")
    private Integer id;
	
	private String typeid;
	
	private String typename;
	
	private String labelid;
	
	private String labelname;
	

	private String iconrul;
	
	private String bookmarkname;
	
	private String bookmarkurl;
	
	private String bookmarkdesc;
	
	private String bookmarkrule;
	
	private String bookmarkbgcolor;
	
	private String bookmarkfontcolor;
	
	private String createtime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTypeid() {
		return typeid;
	}

	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}

	public String getLabelid() {
		return labelid;
	}

	public void setLabelid(String labelid) {
		this.labelid = labelid;
	}

	public String getIconrul() {
		return iconrul;
	}

	public void setIconrul(String iconrul) {
		this.iconrul = iconrul;
	}

	public String getBookmarkname() {
		return bookmarkname;
	}

	public void setBookmarkname(String bookmarkname) {
		this.bookmarkname = bookmarkname;
	}

	public String getBookmarkurl() {
		return bookmarkurl;
	}

	public void setBookmarkurl(String bookmarkurl) {
		this.bookmarkurl = bookmarkurl;
	}

	public String getBookmarkdesc() {
		return bookmarkdesc;
	}

	public void setBookmarkdesc(String bookmarkdesc) {
		this.bookmarkdesc = bookmarkdesc;
	}

	public String getBookmarkrule() {
		return bookmarkrule;
	}

	public void setBookmarkrule(String bookmarkrule) {
		this.bookmarkrule = bookmarkrule;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public String getLabelname() {
		return labelname;
	}

	public void setLabelname(String labelname) {
		this.labelname = labelname;
	}

	public String getBookmarkbgcolor() {
		return bookmarkbgcolor;
	}

	public void setBookmarkbgcolor(String bookmarkbgcolor) {
		this.bookmarkbgcolor = bookmarkbgcolor;
	}

	public String getBookmarkfontcolor() {
		return bookmarkfontcolor;
	}

	public void setBookmarkfontcolor(String bookmarkfontcolor) {
		this.bookmarkfontcolor = bookmarkfontcolor;
	}



	
	
	
}
