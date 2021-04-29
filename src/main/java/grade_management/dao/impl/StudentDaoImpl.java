package grade_management.dao.impl;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import grade_management.dao.StudentDao;
import grade_management.database.JdbcConn;
import grade_management.dto.Ban;
import grade_management.dto.Score;
import grade_management.dto.Student;
import grade_management.dto.Subject;

public class StudentDaoImpl implements StudentDao {
	public static StudentDaoImpl instance = new StudentDaoImpl();

	public static StudentDaoImpl getInstance() {
		return instance;
	}

	private StudentDaoImpl() {
	}

	@Override
	public List<Student> selectStudentByAll() {
		String sql = " select stdNo, stdName, classCode, enterDate, PhotoName, stdPhoto, subj4, subj국어, 국어, subj5, subj영어, 영어, subj6, subj수학, 수학, subj7, subj사회, 사회, subj8, subj과학, 과학, 합계, 평균 "
				+ " from vw_student_table";

		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				List<Student> list = new ArrayList<>();
				do {
					list.add(getStudent(rs));
				} while (rs.next());

				System.out.println(list.size());
				return list;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Student getStudent(ResultSet rs) throws SQLException {
		int stdNo = rs.getInt("stdNo");
		Ban classCode = new Ban(rs.getString("classCode"));
		String stdName = rs.getString("stdName");
		Date enterDate = rs.getDate("enterDate");
		String PhotoName = null;
		try {
			rs.getString("PhotoName");
		} catch (SQLException e) {
		}

		Blob stdPhoto = null;
		try {
			rs.getBlob("stdPhoto");
		} catch (SQLException e) {
		}

		List<Score> a = null;
		try {
			a = new ArrayList<>();
			a.add(new Score(new Subject(rs.getInt("subj4"), rs.getString("subj국어")), rs.getInt("국어")));
			a.add(new Score(new Subject(rs.getInt("subj5"), rs.getString("subj영어")), rs.getInt("영어")));
			a.add(new Score(new Subject(rs.getInt("subj6"), rs.getString("subj수학")), rs.getInt("수학")));
			a.add(new Score(new Subject(rs.getInt("subj7"), rs.getString("subj사회")), rs.getInt("사회")));
			a.add(new Score(new Subject(rs.getInt("subj8"), rs.getString("subj과학")), rs.getInt("과학")));
		} catch (SQLException e) {
		}

		return new Student(stdNo, classCode, stdName, enterDate, PhotoName, stdPhoto, a);
	}

	@Override
	public List<Student> selectStudentByclassCode(Student student) {
		String sql = "select stdNo, stdName, classCode, enterDate, 국어, 영어, 수학, 사회, 과학, 합계, 평균 from vw_student_table where classCode =?";
		try (Connection con = JdbcConn.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, student.getBan().getClassCode());
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					List<Student> list = new ArrayList<>();
					do {
						list.add(getStudent(rs));
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
	public int insertStudent(Student student) {
		String sql = "insert into student (stdNo,classCode,stdName,enterDate) values (?, ?, ?, ?)";
		try (Connection con = JdbcConn.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, student.getStdNo());
			pstmt.setString(2, student.getBan().getClassCode());
			pstmt.setString(3, student.getStdName());
			pstmt.setTimestamp(4, new Timestamp(student.getEnterDate().getTime()));
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public int updateStudent(Student student) {
		String sql = "update student set classCode = ?, stdName = ?, enterDate = ? where stdNo = ?";
		try (Connection con = JdbcConn.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, student.getBan().getClassCode());
			pstmt.setString(2, student.getStdName());
			pstmt.setTimestamp(3, new Timestamp(student.getEnterDate().getTime()));
			pstmt.setInt(4, student.getStdNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteStudent(Student student) {
		String sql = "delete from student where stdNo = ?";
		try (Connection con = JdbcConn.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, student.getStdNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public Student selectStudent(Student student) {
		String sql = "select stdNo, stdName, classCode, enterDate, PhotoName, stdPhoto,"
				+ " subj4, subj국어, 국어, subj5, subj영어, 영어, subj6, subj수학, 수학, subj7, subj사회, 사회, "
				+ " subj8, subj과학, 과학, 합계, 평균," + " enterDate from vw_student_table where stdNo = ?";
		try (Connection con = JdbcConn.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, student.getStdNo());
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					return getStudent(rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Student> selectStudentTable(Student student) {
		String sql = "select stdNo, stdName, classCode, enterDate, PhotoName, stdPhoto, subj4, subj국어, 국어, subj5, subj영어, 영어, subj6, subj수학, 수학, subj7, subj사회, 사회, subj8, subj과학, 과학, 합계, 평균 from vw_student_table where classCode = ?";
		
		try(Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);){
			pstmt.setString(1, student.getBan().getClassCode());
			try(ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					List<Student> list = new ArrayList<>();
					do {
						list.add(getStudentTable(rs));
					}while(rs.next());
					return list;
				}
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

	private Student getStudentTable(ResultSet rs)  {
		int stdNo = 0;
		Ban classCode = null;
		String stdName = null;
		List<Score> a = null;
		int avg = 0;
		a = new ArrayList<>();
		try {
			stdNo = rs.getInt("stdNo");
		} catch (SQLException e1) {}
		
		try {
			classCode = new Ban(rs.getString("classCode"));
		} catch (SQLException e1) {}
		
		try {
			stdName = rs.getString("stdName");
		} catch (SQLException e1) {}
		
		try {
			a.add(new Score(new Subject(rs.getInt("subj4"), rs.getString("subj국어")),rs.getInt("국어")));
		} catch (SQLException e) {}
		try {
			a.add(new Score(new Subject(rs.getInt("subj5"), rs.getString("subj영어")),rs.getInt("영어")));
		} catch (SQLException e) {}
		try {
			a.add(new Score(new Subject(rs.getInt("subj6"), rs.getString("subj수학")),rs.getInt("수학")));
		} catch (SQLException e) {}
		try {
			a.add(new Score(new Subject(rs.getInt("subj7"), rs.getString("subj사회")),rs.getInt("사회")));
		} catch (SQLException e) {}
		try {
			a.add(new Score(new Subject(rs.getInt("subj8"), rs.getString("subj과학")),rs.getInt("과학")));
		} catch (SQLException e) {}
		
		try {
			avg = rs.getInt("평균");
		} catch (SQLException e) {}
		return new Student(stdNo, classCode, stdName, a,avg);
	}

}
