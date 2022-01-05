package sist.com.dao;

import java.sql.*;
import java.util.*;

import sist.com.common.DataBase;

/*
 *    DB2 : ��뷮 �����ͺ��̽� : ������ , ����� , �б�
 *    =================
 *    ���� 
 *    Oracle : ����
 *    MS-SQL : ��û ... (MS)
 *    =================
 *    �߼��� ====================> �ǹ������� ���� ���� ��� (����)
 *    MY-SQL : ����Ŭ 
 *    MariaDB : MySQL���� ���ͼ� ���Ӱ� ����� 
 *    =================
 *    ���� 
 *    SQLITE : �ڵ��� 
 *    =================
 */
/*
 *    Ŭ����  : �빮�� ����
 *    ����  : �ҹ��� 
 *    ���  : ��ü �빮��
 *    �޼ҵ� : �ҹ��� 
 *    ��ȣ 
 *    public void display(){
 *       if(){
 *       }else{
 *       }
 *       
 *    }
 */
public class MusicDAO implements DataBase {
	// ���� ��ü (����Ŭ)
	private Connection conn;
	// ����Ŭ�� ��ɾ� ����
	private PreparedStatement ps;
	// ����Ŭ �ּ� => ��ҹ��� ������ ���� �ʴ´�
	// SELECT ~~ , select , Select , SeLeCt => Ű����� �빮��
	private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";

	// 1. ����̹� ��� : �ѹ��� ���� => ������
	public MusicDAO() {
		try {
			// ����̹� ��� , �������� , ������ ����
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception ex) {
		}
	}

	// 2. ����Ŭ ����
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(URL, "hr", "happy");
			// ����Ŭ => conn hr/happy
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// 3. ����Ŭ ����
	public void disConnection() {
		try {
			if (ps != null)
				ps.close();
			if (conn != null)
				conn.close();
			// exit
		} catch (Exception ex) {
		}
	}

	// 4. ��� ====> ����Ŭ ������ �߰�
	@Override
	public void dbInsert(Object obj) {
		// TODO Auto-generated method stub
		try {
			Music m = (Music) obj;
			// 1.����
			getConnection();
			// 2.����Ŭ ��ɹ� ���� => SQL
			/*
			 * SQL 
			 * 	= DML = ������ ���۾�� 
			 * 	  SELECT : ������ �˻� 
			 * 	  INSERT : ������ �߰� 
			 * 	  UPDATE : ������ ���� 
			 * 	  DELETE : ������ ���� 
			 * 	= DDL = ������ ������ 
			 * 	  TABLE / VIEW / SEQUENCE / INDEX / PROCEDURE 
			 * 	  FUNCTION / TRIGGER 
			 * 	  CREATE : �����ͺ��̽� ���� (����ȭ) 
			 * 	  DROP 
			 * 	  ALTER 
			 * 	  RENAME 
			 * 	  TRUNCATE 
			 * 	= DCL = ������ ������ 
			 * 	  GRANT 
			 * 	  REVOKE 
			 *  = TCL = Ʈ����� ���� ��� 
			 *    COMMIT 
			 *    ROLLBACK
			 */
			String sql = "INSERT INTO genie_music VALUES(?,?,?,?,?,?,?,?,?)";
			// 3.���� ä���� ���� ���
			ps = conn.prepareStatement(sql);
			ps.setInt(1, m.getNo());
			ps.setString(2, m.getTitle());
			ps.setString(3, m.getSinger());
			ps.setString(4, m.getAlbum());
			ps.setInt(5, m.getRank());
			ps.setString(6, m.getState());
			ps.setInt(7, m.getIdcrement());
			ps.setString(8, m.getKey());
			ps.setString(9, m.getPoster());

			ps.executeUpdate(); // ���ȭ��ǥ , ����
			// COMMIT ==. AutoCommit
		} catch (Exception ex) {
			// ����üũ
			ex.printStackTrace();
		} finally {
			// ����Ŭ ����
			disConnection();
		}
	}
}
