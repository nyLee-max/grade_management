package grade_management.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import grade_management.dao.BanDao;
import grade_management.database.JdbcConn;
import grade_management.dto.Ban;

public class BanDaoImpl implements BanDao {

	private static final BanDaoImpl instance = new BanDaoImpl();
	
	public static BanDaoImpl getInstance() {
		return instance;
	}
	
	private BanDaoImpl() {}
	
	@Override
	public List<Ban> selectBanByAll() {
		String sql = "select classCode from Ban";
		
		try (Connection con = JdbcConn.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery()){
			if(rs.next()) {
				List<Ban> list = new ArrayList<>();
				do {
					list.add(getBan(rs));
				}while(rs.next());
				System.out.println(list.size());
				return list;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	

	private Ban getBan(ResultSet rs) throws SQLException {
		String classCode = rs.getString("classCode");
		return new Ban(classCode);
	}

	@Override
	public int insertBan(Ban ban) {
		String sql = "insert into ban values (?)";
		
		try (Connection con = JdbcConn.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);){
			pstmt.setString(1, ban.getClassCode());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}


	@Override
	public int deleteBan(Ban ban) {
		String sql = "delete from ban where classCode = ?";
		try(Connection con = JdbcConn.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);){
			pstmt.setString(1, ban.getClassCode());
			
			return pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}




}
