package com.sist.di2;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.*;

public class BooksDAO extends SqlSessionDaoSupport {

	public List<BooksVO> booksListData() {
		return getSqlSession().selectList("booksListData");
	}

}
