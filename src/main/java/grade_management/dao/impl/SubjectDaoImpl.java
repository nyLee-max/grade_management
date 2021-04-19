package grade_management.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import grade_management.dao.SubjectDao;
import grade_management.database.JdbcConn;
import grade_management.dto.Subject;

public class SubjectDaoImpl implements SubjectDao {
	public static SubjectDaoImpl instance = new SubjectDaoImpl();
	
	public static SubjectDaoImpl getInstance() {
		return instance;
	}

	public SubjectDaoImpl() {}

	@Override
	public List<Subject> selectSubjectByAll() {
		String sql = "select subNo, subName from subject";
		try(Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();){
			if(rs.next()) {
				List<Subject> list = new ArrayList<>();
				do {
					list.add(getSubject(rs));
				}while(rs.next());
				return list;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private Subject getSubject(ResultSet rs) throws SQLException {
		int subNo = rs.getInt("subNo");
		String subName = rs.getString("subName");
		return new Subject(subNo, subName);
	}

	@Override
	public int insertSubject(Subject subject) {
		String sql = "insert into subject values (?,?)";
		try(Connection con = JdbcConn.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);){
			pstmt.setInt(1, subject.getSubNo());
			pstmt.setString(2, subject.getSubName());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateSubject(Subject subject) {
		String sql = "update subject set subName = ? where subNo = ?";
		try(Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);){
			pstmt.setString(1, subject.getSubName());
			pstmt.setInt(2, subject.getSubNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteSubject(Subject subject) {
		String sql = "delete from subject where subNo = ?";
		try(Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);){
			pstmt.setInt(1, subject.getSubNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
