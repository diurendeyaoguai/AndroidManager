package com.frame.saeasyandroids.bean;

import com.frame.saeasyandroids.db.dao.DBHelper;
import com.frame.saeasyandroids.db.dao.aonntation.Column;
import com.frame.saeasyandroids.db.dao.aonntation.ID;
import com.frame.saeasyandroids.db.dao.aonntation.Table;

/**
 * 实验数据库操作的实体类
 * 
 * @author zhangshun
 * 
 */
@Table(DBHelper.TABLE_BOOK)
public class Book {
	@ID(autoIncreament = true)
	@Column(DBHelper.TABLE_ID_COL)
	private long id;
	@Column(DBHelper.TABLE_BOOK_NAME_COL)
	private String name;
	@Column(DBHelper.TABLE_BOOK_SUMMARY)
	private String summary;

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
