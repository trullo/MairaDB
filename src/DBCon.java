import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBCon {

	public static void main(String[] args) {
		System.out.println("DBCon");
		String url = "jdbc:mysql://192.168.1.233:3306/test";
		String user = "root";
		String pwd = "1234";
		Connection con = null;
		
		try {
			System.out.println("드라이버 클래스 확인");
			Class.forName("org.mariadb.jdbc.Driver");  // 연결상태확인
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			con = DriverManager.getConnection(url, user, pwd);  // 데이터베이스 연결
			String sql = "select id from user";
			PreparedStatement ps = con.prepareStatement(sql);  // 컴파일된 sql문을 수행시킨다.
			ResultSet rs = ps.executeQuery();  				   // 실행시켜서
			while(rs.next()) {
				String id = rs.getString("id");
				System.out.println(id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("종     료");
	}

}
