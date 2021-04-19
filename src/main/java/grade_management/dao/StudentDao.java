package grade_management.dao;

import java.util.List;

import grade_management.dto.Student;

public interface StudentDao {
	List<Student> selectStudentByAll();
	List<Student> selectStudentByclassCode(Student student);
	Student selectStudent(Student student);
	
	int insertStudent(Student student);
	int updateStudent(Student student);
	int deleteStudent(Student student);
	
}
