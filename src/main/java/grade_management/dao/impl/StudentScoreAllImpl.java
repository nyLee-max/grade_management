package grade_management.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import grade_management.dao.StudentScoreAllDao;
import grade_management.database.JdbcConn;
import grade_management.dto.Ban;
import grade_management.dto.Score;
import grade_management.dto.Student;
import grade_management.dto.StudentScoreAll;
import grade_management.dto.Subject;

public class StudentScoreAllImpl implements StudentScoreAllDao {

	public static StudentScoreAllImpl instance = new StudentScoreAllImpl();

	public static StudentScoreAllImpl getInstance() {
		return instance;
	}

	public StudentScoreAllImpl() {
	}

	@Override
	public List<StudentScoreAll> selectStudentScoreByAll() {
		String sql = "select stdNo, stdName, classCode, 국어, 영어, 수학, 사회, 과학, 평균 from vw_student_table";
		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {
			if (rs.next()) {
				List<StudentScoreAll> list = new ArrayList<>();
				do {
					list.add(getStudentScore(rs));
				} while (rs.next());
				return list;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private StudentScoreAll getStudentScore(ResultSet rs) throws SQLException {
		int stdNo = rs.getInt("stdNo");
		String stdName = rs.getString("stdName");
		Ban classCode = new Ban(rs.getString("classCode"));
		int kor = rs.getInt("국어");
		int eng = rs.getInt("영어");
		int math = rs.getInt("수학");
		int soc = rs.getInt("사회");
		int sci = rs.getInt("과학");
		int avg = rs.getInt("평균");
		return new StudentScoreAll(stdNo, stdName, classCode, kor, eng, math, soc, sci, avg);
	}

	@Override
	public List<StudentScoreAll> selectStudentScoreByClassCode(Ban ban) {
		String sql = "select stdNo, stdName, classCode, 국어, 영어, 수학, 사회, 과학, 평균 from vw_student_table where classCode =?";
		try (Connection con = JdbcConn.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, ban.getClassCode());
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					List<StudentScoreAll> list = new ArrayList<>();
					do {
						list.add(getStudentScore(rs));
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
	public List<StudentScoreAll> selectStudentScoreBySubject(Subject subject) {
		String sql = "select stdNo, stdName, classCode, 국어, 영어, 수학, 사회, 과학, 평균 " + "from vw_student_table order by "
				+ subject.getSubName() + " desc";
		try (Connection con = JdbcConn.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			System.out.println(pstmt);
			try (ResultSet rs = pstmt.executeQuery();) {
				if (rs.next()) {
					List<StudentScoreAll> list = new ArrayList<>();
					do {
						list.add(getStudentScore(rs));
					} while (rs.next());
					return list;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<StudentScoreAll> selectStudentScoreByBanSubject(Ban ban, Subject subject) {
		String sql = "select stdNo, stdName, classCode, 국어, 영어, 수학, 사회, 과학, 평균 from vw_student_table  where classCode = ? order by "
				+ subject.getSubName() + " desc";
		try (Connection con = JdbcConn.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, ban.getClassCode());
			try (ResultSet rs = pstmt.executeQuery();) {
				if (rs.next()) {
					List<StudentScoreAll> list = new ArrayList<>();
					do {
						list.add(getStudentScore(rs));
					} while (rs.next());
					return list;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public StudentScoreAll selectStudentScoreByStdNo(Student student) {
		String sql = "select stdNo, 국어, 영어, 수학, 사회, 과학 from vw_student_table where stdNo = ?";
		try (Connection con = JdbcConn.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, student.getStdNo());
			try (ResultSet rs = pstmt.executeQuery();) {
				if (rs.next()) {
					return getScore(rs);

				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private StudentScoreAll getScore(ResultSet rs) throws SQLException {
		int stdNo = rs.getInt("stdNo");
		int kor = rs.getInt("국어");
		int eng = rs.getInt("영어");
		int math = rs.getInt("수학");
		int soc = rs.getInt("사회");
		int sci = rs.getInt("과학");
		return new StudentScoreAll(stdNo, kor, eng, math, soc, sci);
	}

	@Override
	public List<StudentScoreAll> selectStudentScoreByAvg() {
		String sql = "select stdNo, stdName, classCode, enterDate, PhotoName, stdPhoto,국어, 영어, 수학, 사회,과학, 합계, 평균 from vw_student_table order by 평균 desc";
		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {
			if (rs.next()) {
				List<StudentScoreAll> list = new ArrayList<>();
				do {
					list.add(getStudentScore(rs));
				} while (rs.next());
				return list;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


}
