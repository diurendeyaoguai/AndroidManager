package com.frame.saeasyandroids.db.dao.impl;

import android.content.Context;

import com.frame.saeasyandroids.bean.Book;
import com.frame.saeasyandroids.db.dao.BookDao;

public class BookDaoImpl extends DAOImpl<Book> implements BookDao {

	public BookDaoImpl(Context context) {
		super(context);
	}

}
