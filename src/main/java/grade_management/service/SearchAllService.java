package grade_management.service;

import java.util.List;

import grade_management.dao.StudentDao;
import grade_management.dao.impl.StudentDaoImpl;
import grade_management.dto.Student;

public class SearchAllService {
	private StudentDao dao = StudentDaoImpl.getInstance();

	public List<Student> showStudent() {
		return dao.selectStudentByAll();
	}
}
