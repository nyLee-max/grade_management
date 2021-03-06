package grade_management.dao;

import java.util.List;

import grade_management.dto.Subject;

public interface SubjectDao {
	List<Subject> selectSubjectByAll();
	List<Subject> selectSubjectName();
	
	int insertSubject(Subject subject);
	int updateSubject(Subject subject);
	int deleteSubject(Subject subject);
	
}
