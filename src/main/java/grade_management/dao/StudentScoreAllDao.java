package grade_management.dao;

import java.util.List;

import grade_management.dto.Ban;
import grade_management.dto.Score;
import grade_management.dto.Student;
import grade_management.dto.StudentScoreAll;
import grade_management.dto.Subject;

public interface StudentScoreAllDao {
	List<StudentScoreAll> selectStudentScoreByAll();
	List<StudentScoreAll> selectStudentScoreByClassCode(Ban ban);
	List<StudentScoreAll> selectStudentScoreBySubject(Subject subject);
	List<StudentScoreAll> selectStudentScoreByBanSubject(Ban ban, Subject subject);
	StudentScoreAll selectStudentScoreByStdNo(Student student);
	List<StudentScoreAll> selectStudentScoreByAvg();
}
