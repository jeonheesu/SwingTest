package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

;

public class MyDB {

	public int login(String mID, String mPW) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String dbURL = "jdbc:mysql://127.0.0.1:3306/swingDB?useSSL=false";
		String dbID = "root";
		String dbPW = "rootroot";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPW);

			String sql = "SELECT mID, mPW from memberTBL where mID = ? and mPW = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mID);
			pstmt.setString(2, mPW);
			rs = pstmt.executeQuery();

			if (rs.next()) {

//				String resultID = rs.getString("mID"); // 컬럼명
//				String resultPW = rs.getString("mPW"); // 컬럼명
//
//				if (resultID.equals(mID) && resultPW.equals(mPW)) {
//					System.out.println("로그인 성공");
//				}
			System.out.println("login 성공");
			return 1000;

			} else {
				System.out.println("login 실패.");

			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return 0;

	}

	public boolean idDuplicate(String mID) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String dbURL = "jdbc:mysql://127.0.0.1:3306/swingDB?useSSL=false";
		String dbID = "root";
		String dbPW = "rootroot";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPW);

			String sql = "SELECT mID from memberTBL where mID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mID);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				System.out.println("중복되는 아이디가 존재합니다.");
			} else {
				System.out.println("중복되는 아이디가 없습니다.");
				return false;

			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	public void insert(String mID, String mPW) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		String dbURL = "jdbc:mysql://127.0.0.1:3306/swingDB?useSSL=false";
		String dbID = "root";
		String dbPW = "rootroot";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPW);

			String sql = "insert into memberTBL(mID, mPW) " + " values (?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mID);
			pstmt.setString(2, mPW);
			pstmt.executeUpdate();

			System.out.println("MemberDTO insert() 메서드 실행 완료");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
