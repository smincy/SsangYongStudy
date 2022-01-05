package sist.com.dao;

import sist.com.common.DataBase;
import java.util.*;
import java.sql.*;

public class BooksDAO implements DataBase {
	// �ʿ��� Ŭ���� ������ �´� => ���� Ŭ����
	private Connection conn; // ����Ŭ ����
	private PreparedStatement ps;// SQL������ ����
	private final String url = "jdbc:oracle:thin:@localhost:1521:XE"; // ����Ŭ �ּ�
	/*
	 * ����̹� => thin => ���Ḹ �ϴ� ���� (����) oci => ����̹� ����Ŭ ������ �� ������ �ִ� (����)
	 * 
	 * �ڹ� , thin , MySQL(MariaDB) ============== Front(Spring-Boot=>RestAPI)
	 * VueJS/ReactJS aws => JSP (1��) , Spring (2��)
	 * 
	 * �����ͺ��̽� / ���̺� --------- ----- ���� ����
	 * 
	 * 
	 * ==> �����͸� ��Ƽ� ���� (�������� Ŭ���� ==> ĸ��ȭ) ==> �����ͺ��̽� ���� ó�� ==> �ܺο��� ������ �б�
	 * =========================================== ==> ���������� ȣȯ
	 */
	// ����̹� ���� ==> �ѹ��� ���� => ������

	public BooksDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// => Ŭ���������� �޸� �Ҵ��� �Ѵ�
		} catch (Exception ex) {
			ex.printStackTrace();
			// getMessage():���� �޼����� ��� ,
			// printStackTrace() => �����ϴ� ������ ��� => ���� ��ġ Ȯ��
			// ���� => �ҽ��� (X) , Outputâ�� ����
		}
	}
	/////////////////////// �ݺ��� ���� (�޼ҵ�ȭ)
	/*
	 * �Ѱ��� ����� ���� => ������ ���� �ݺ��� ���� ����ȭ�� ���α׷� (�ܶ�,������)
	 */

	// ����Ŭ ����
	public void getConnection() {
		// ����Ŭ ���� , ���� ���� , ��Ʈ��ũ���� ���� => CheckException
		try {
			conn = DriverManager.getConnection(url, "hr", "happy");
			// conn hr/happy ==> ����Ŭ ������ ���� (�α���)
		} catch (Exception ex) {
			ex.printStackTrace(); // username , password
		}
	}

	// ����Ŭ ���� ����
	public void disConnection() {
		try {
			// ����� => PreparedStatement => OutputStream , BufferedReader
			// ���� => Connection => Socket
			// ��� => �����Ҷ� ==> ����Ŭ ������ ���
			if (ps != null)
				ps.close(); // ���
			if (conn != null)
				conn.close(); // ��ȭ�� �ݱ�
			// ps!=null ==> ps�� ������̸�
		} catch (Exception ex) {
		}
	}

	////////////////////////////
	/*
	 * �޼ҵ� ===== ����) =============== ����� =============== ������ ===============
	 * 
	 * 1. ����� => ������ / �Ű����� 2. ������ => {}
	 * 
	 * ������ �ƴϴ� (����:���̺귯��) ============================= ������ �Ű�����
	 * ============================= O O => �󼼺��� (��ȣ) => Ŭ���� ���� => String
	 * substring(int s ,int e) ======= ============= ����� ����� ��û => boolean
	 * isLogin(String id,String pwd) ============================= ==> ��ü ��Ͽ�û O X
	 * => String trim() ====== ����� ==> �¿쿡 ���� => double random() => 0.0~0.99
	 * ============================= =====> ����Ŭ => INSERT,UPDATE,DELETE X O => void
	 * println(String s) void println(int a) ============================= X X =>
	 * System.out.println() => �����ٿ� ��� =============================
	 * 
	 * ***** �������� �Ѱ��� ���� => �����Ͱ� ������ (�迭,Ŭ����,�÷���) => 1�� => �⺻ �������� ***** �Ű������� 3���̻�
	 * �ʰ����� �ʴ´� ====== �迭,Ŭ���� ***** ��� �����͸� �ޱ� ���ؼ��� Object ***** �Ű������� ������ �� �� ���� :
	 * ���� �Ű����� String... Object...
	 * 
	 */
	@Override
	/*
	 * private int no; private String title; private String poster; private String
	 * content; private String author; private String price; private String regdate;
	 * private String isbn; private String tags;
	 */
	public void dbInsert(Object obj) {
		try {

			// => ����ȯ
			Books b = (Books) obj;

			// 1. ����Ŭ ����
			getConnection();

			// 2. ����Ŭ�� ��ɾ� ����
			String sql = "INSERT INTO books VALUES(?,?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);// ���۰�ü�� ����
			// 3. ?�� ���� ä��� ==> ?�� ������ 1������ ����
			ps.setInt(1, b.getNo());
			ps.setString(2, b.getTitle());
			ps.setString(3, b.getPoster());
			ps.setString(4, b.getContent());
			ps.setString(5, b.getAuthor());
			ps.setString(6, b.getPrice());
			ps.setString(7, b.getRegdate());
			ps.setString(8, b.getIsbn());
			ps.setString(9, b.getTags());
			// 4. ����Ŭ => ���� ����� �����Ѵ�
			ps.executeUpdate(); // commit�� ���� => autocommit => �ڵ� ����
		} catch (Exception ex) {
			// ���� Ȯ��
			ex.printStackTrace();
		} finally {
			// �ݱ�
			disConnection();
		}
	}

}