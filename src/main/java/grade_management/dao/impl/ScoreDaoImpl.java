package grade_management.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import grade_management.dao.ScoreDao;
import grade_management.database.JdbcConn;
import grade_management.dto.Score;
import grade_management.dto.Student;
import grade_management.dto.Subject;
import grade_management.ui.exception.SqlConstraintException;

public class ScoreDaoImpl implements ScoreDao {

	public static ScoreDaoImpl instance = new ScoreDaoImpl();

	public static ScoreDaoImpl getInstance() {
		return instance;
	}

	private ScoreDaoImpl() {
	}

	@Override
	public List<Score> selectScoreByAll() {
		String sql = "select stdNo, subNo, stdScore from score";

		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				List<Score> list = new ArrayList<>();
				do {
					list.add(getScore(rs));
				} while (rs.next());
				System.out.println(list.size());
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Score getScore(ResultSet rs) throws SQLException {
//		int no = rs.getInt("No");
		Student stdNo = new Student(rs.getInt("stdNo"));
		Subject subNo = new Subject(rs.getInt("subNo"));
		int stdScore = rs.getInt("stdScore");
		return new Score(stdNo, subNo, stdScore);
	}

	@Override
	public List<Score> selectScoreBystdNo(Student student) {
		String sql = "select  stdNo, subNo, stdScore from score where stdNo=?";
		try (Connection con = JdbcConn.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, student.getStdNo());
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					List<Score> list = new ArrayList<>();
					do {
						list.add(getScore(rs));
					} while (rs.next());
					return list;
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insertScore(Score score) {
		String sql = "insert into score(stdNo, subNo, stdScore) values (?, ?, ?)";
		try (Connection con = JdbcConn.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, score.getStudent().getStdNo());
			pstmt.setInt(2, score.getSubject().getSubNo());
			pstmt.setInt(3, score.getStdScore());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SqlConstraintException(e.getMessage(), e);
		}

	}

	@Override
	public int updateScore(Score score) {
		String sql = "update score set subNo = ?, stdScore = ? where stdNo = ?";
		try (Connection con = JdbcConn.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, score.getSubject().getSubNo());
			pstmt.setInt(2, score.getStdScore());
			pstmt.setInt(3, score.getStudent().getStdNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public int deleteScore(Score score) {
		String sql = "delete from score where stdNo = ?";
		try (Connection con = JdbcConn.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, score.getStudent().getStdNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<Score> selectScoreBysubNo(Subject subject) {
		String sql = "select stdNo, subNo, stdScore from score where subNo = ?";
		try (Connection con = JdbcConn.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, subject.getSubNo());
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					List<Score> list = new ArrayList<>();
					do {
						list.add(getScore(rs));
					} while (rs.next());
					return list;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}



}
