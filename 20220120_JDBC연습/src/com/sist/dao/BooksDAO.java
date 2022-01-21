package com.sist.dao;

import java.util.*;
import java.sql.*;

public class BooksDAO {

	private Connection conn;
	private PreparedStatement ps;
	private DataBase db = new DataBase();

	public List<BooksVO> booksListData(int page) {
		List<BooksVO> list = new ArrayList<BooksVO>();
		try {
			conn = db.getConnection(conn);

			String sql = "SELECT no, title, author " + "FROM books";

			ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			int i = 0;
			int j = 0;
			int pagecnt = (page * 10) - 10;

			while (rs.next()) {
				if (i < 10 && j >= pagecnt) {
					BooksVO vo = new BooksVO();
					vo.setNo(rs.getInt(1));
					vo.setTitle(rs.getString(2));
					vo.setAuthor(rs.getString(3));

					list.add(vo);
					i++;
				}
				j++;
			}
			rs.close();

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			db.disConnection(conn, ps);
		}

		return list;
	}
}
