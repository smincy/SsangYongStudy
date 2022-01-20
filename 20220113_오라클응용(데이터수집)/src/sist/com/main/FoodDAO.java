package sist.com.main;
/*
 *	오라클 연결 : JDBC
 *	1. 오라클 연결
 *	2. SQL문장 전송
 *	3. 결과값 받기
 *	4. 오라클 연결 해제 
 */

import java.sql.*;
import java.util.*;

public class FoodDAO {

	private Connection conn;
	private PreparedStatement ps;
	private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";

	// 1. 드라이버 등록 (1번만등록) => 생성자
	public FoodDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {

		}
	}

	// 2. 오라클 연결
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(URL, "smincy", "134679");
		} catch (Exception e) {
		}
	}

	// 3. 오라클 해제
	public void disConnection() {
		try {
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// 4. 기능 -> Category에 데이터 추가
	public void categoryInsert(Category c) {

		try {
			// 1. 오라클 연결
			getConnection();
			// 2. SQL문장 제작
			String sql = "INSERT INTO category VALUES(cate_cno_seq.nextval,?,?,?,?)";
			// 3. 오라클로 전송
			ps = conn.prepareStatement(sql);
			ps.setString(1, c.getTitle());
			ps.setString(2, c.getSubfect());
			ps.setString(3, c.getPoster());
			ps.setString(4, c.getLink());

			// 실행 명령
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConnection();
		}
	}

	// 맛집 저장 
		/*
		 *     사용자요청 ===> 자바 ====================> 오라클 
		 *                요청 내용을 SQL문장으로 변경        |
		 *                                           SQL을 받아서 실행 
		 *                                              |
		 *                      <==================== 결과값을 자바로 전송
		 *                      |
		 *                 결과값을 사용자에게 응답 
		 *     (자바) / C# / NODEJS / C/C++ / 파이썬 / 스칼라....
		 *      1. 오라클에 연결 (Connection) conn hr/happy
		 *                                ---------------
		 *                                getConnection()
		 *      2. 사용자 요청한 내용을 SQL문장으로 변경 
		 *         ------------------------------
		 *      3. SQL문장을 오라클로 전송 => Statement(PreparedStatement)
		 *         Statement   / PreparedStatement(미리 SQL문장 전송 , 나중에 필요한 데이터를 첨부) 
		 *         ---------     -----------------
		 *          SQL+필요한 데이터를 한번에 전송 
		 *          
		 *          오라클에 데이터 추가를 요청시에 (INSERT~)
		 *          예)
		 *              name , sex , age , address , tel (회원가입)
		 *              
		 *              자바에서 값을 받는다 
		 *              String name="홍길동";
		 *              String sex="남자";
		 *              int age=25;
		 *              String address="서울시";
		 *              String tel="010-1111-1111";
		 *              
		 *              => SQL문장을 전송시에 => 문자열로 전송해야 된다 
		 *              String sql="INSERT INTO member VALUES('"
		 *                        +name+"','",sex+"',"+age
		 *                        +",'"+address+"','"+tel+"')";
		 *              => String => VARCHAR2변경 => '값'
		 *              => Statement 
		 *              => 개발자 요청에 의해서 변경 
		 *              String sql="INSERT INTO member VALUES(?,?,?,?,?)"
		 *              => 나중에 ?에 값을 채운다 
		 *              => setString(1,name) ==> 자동으로 ''가 사용 
		 *                             => '홍길동'
		 *                 setInt()
		 *                 setDouble()
		 *              => 장점 => ''을 사용하지 않는다 (자동으로 추가) => 사용하기 쉽게 
		 *              => 단점 => 소스가 길어진다 
		 *              
		 *       4. 오라클 실행명령어 전송 
		 *          = executeQuery() : SELECT (데이터를 읽어 온다)
		 *          = executeUpdate() => COMMIT이 포함 
		 *                               => 데이터를 읽은 것이 아니라 실행
		 *                               => INSERT , UPDATE , DELETE
		 *                               
		 *       5. 오라클에서 실행된 결과읽기(SELECT) => ResultSet
		 *          ResultSet => Record단위 ,ROW단위로 읽기 
		 *          =========
		 *            데이터를 인출 => 1) 처음 , 2) 마지막 
		 *            
		 *            ---------------------
		 *              ID   Name    Sex
		 *            ---------------------
		 *              aaa  홍길동    남자  ===> 여기서부터 밑으로 내려가면 읽기
		 *                                      next() ***
		 *            ---------------------
		 *              bbb  심청이    여자
		 *            ---------------------
		 *              ccc  박문수    남자  ===> 여기서부터 위로 올라가면서 읽기
		 *                                      previous()
		 *            ---------------------
		 *       6. PreparedStatement / Connection을 닫는다 
		 *                close()          close()
		 *              
		 *              
		 */
		/*
		 *  NO      NOT NULL NUMBER   ==> int      
			CNO              NUMBER   ==> int     
			NAME    NOT NULL VARCHAR2(200)  => String
			SCORE   NOT NULL NUMBER(2,1)    => double
			ADDRESS NOT NULL VARCHAR2(500)  => String 
			TEL     NOT NULL VARCHAR2(30)   => String 
			TYPE    NOT NULL VARCHAR2(100)  => String
			PRICE            VARCHAR2(50)   => String
			PARKING          VARCHAR2(50)   => String
			TIME             VARCHAR2(50)   => String
			MENU             CLOB           => String
			POSTER  NOT NULL VARCHAR2(4000) => String
		 */
	public void foodInsert(FoodHouse food) {
		try {
			getConnection(); // 연결
			// 1. SQL문장 제작
			String sql = "INSERT INTO food_house VALUES(" + "fh_no_seq.nectval,?,?,?,?,?," + "?,?,?,?,?,?)";

			// 2. SQL에 필요한 데이터값 채우기( ? 에 값 채우기)
			ps = conn.prepareStatement(sql);
			ps.setInt(1, food.getCno());
			ps.setString(2, food.getName());
			ps.setDouble(3, food.getScore());
			ps.setString(4, food.getAddress());
			ps.setString(5, food.getTel());
			ps.setString(6, food.getType());
			ps.setString(7, food.getPrice());
			ps.setString(8, food.getParking());
			ps.setString(9, food.getTime());
			ps.setString(10, food.getMenu());
			ps.setString(11, food.getPoster());

			// 3. 오라클에 명령문 실행 요청
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConnection(); // 연결 해제
		}
	}

	// 데이터 읽기 => Category의 link, cno, title 필요
	public List<Category> categoryListData() {
		List<Category> list = new ArrayList<Category>();
		try {
			// 1. 연결
			getConnection();
			// 2. SQL문장 제작
			String sql = "SELECT cno, title, link " + "FROM category";

			// 3. 필요한 데이터를 전송 (없을수도있음)
			// X

			// 4. 오라클에 명령문 실행 요청
			ps = conn.prepareStatement(sql); // sql문장을 오라클로 보낸다

			// 5. 결과값을 받는다
			ResultSet rs = ps.executeQuery(); // 실행된 결과를 rs에 넣어라

			// 6. 받은 결과값을 리스트에 첨부
			while (rs.next()) { // 결과의 위에서부터 아래로 한줄씩 읽어옴
				/*
				 *   오라클에 있는 데이터를 자바와 매칭 
				 *   문자열 : getString()
 				 *   실수 : getDouble()
				 *   정수 : getInt()
				 *   날짜 : getDate()
				 */

				Category c = new Category();
				c.setCno(rs.getInt(1));
				c.setTitle(rs.getString(2));
				c.setLink(rs.getString(3));
				list.add(c);
			}
			rs.close();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			// 연결 해제
			disConnection();
		}
		return list;
	}

}
