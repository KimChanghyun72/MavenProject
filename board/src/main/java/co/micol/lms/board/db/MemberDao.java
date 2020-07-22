/*
 Member Dao
 2020.07.22
 kch

*/
package co.micol.lms.board.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDao {
	
	private String driver= "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "kch";
	private String password = "kch";
	
	private Connection conn; //연결
	private PreparedStatement pstmt; //명령어 전달
	private ResultSet rs; //결과set을 받는 객체
	
	//final은 변수의 변경을 막음. static final이 상수였지 아마?
	//변수의 용도를 위해 뜻이 정확하게 변수명을 정의해라.
	private final String SELECT_MEMBER = "select * from member where id = ?";
	private final String SELECT_MEMBER_ALL = "select * from member";
	private final String INSERT_MEMBER = "insert into member values(?,?,?,?)";
	private final String DELETE_MEMBER = "delete from member where id = ?";
	private final String UPDATE_MEMBER = "update member "
									+ "set password = ?, name = ?, tel = ? where id = ?";
	

	
	public MemberDao() { //생성하면서 DB 커넥션을 연결한다.
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,password);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public MemberVo select(MemberVo vo) {//한명의 멤버를 검색하기
		//sql 구문 전달 필요.
		//결과받기.
		try {
			pstmt = conn.prepareStatement(SELECT_MEMBER);
			pstmt.setString(1, vo.getId());
			rs = pstmt.executeQuery(); //결과값을 받는다.
			if(rs.next()) {
				vo.setPassword(rs.getString("password"));
				vo.setName(rs.getString("name"));
				vo.setTel(rs.getString("tel"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vo;
	}
	
	public List<MemberVo> selectAllMember(){ //전체멤버를 조회하는 것.
		List<MemberVo> list = new ArrayList<MemberVo>();
		try {
			pstmt = conn.prepareStatement(SELECT_MEMBER_ALL);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberVo vo = new MemberVo();
				vo.setId(rs.getString("id"));
				System.out.println(vo.getId());
				vo.setPassword(rs.getString("password"));
				vo.setName(rs.getString("name"));
				vo.setTel(rs.getString("tel"));
				list.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	public int insert(MemberVo vo) { //멤버 삽입
		
		return 0;
	}
	
	public int update(MemberVo vo) { //멤버 수정
		return 0;
	}
	
	public int delete(MemberVo vo) { //멤버 삭제
		return 0;
	}
}