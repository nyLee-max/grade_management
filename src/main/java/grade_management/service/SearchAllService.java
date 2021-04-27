package grade_management.service;

import java.util.List;

import grade_management.dao.ScoreDao;
import grade_management.dao.StudentDao;
import grade_management.dao.StudentScoreAllDao;
import grade_management.dao.SubjectDao;
import grade_management.dao.impl.ScoreDaoImpl;
import grade_management.dao.impl.StudentDaoImpl;
import grade_management.dao.impl.StudentScoreAllImpl;
import grade_management.dao.impl.SubjectDaoImpl;
import grade_management.dto.Score;
import grade_management.dto.Student;
import grade_management.dto.StudentScoreAll;
import grade_management.dto.Subject;

public class SearchAllService {
	private StudentDao dao = StudentDaoImpl.getInstance();
	private ScoreDao scoreDao = ScoreDaoImpl.getInstance();
	private SubjectDao subDao = SubjectDaoImpl.getInstance();
	private StudentScoreAllDao scoDao = StudentScoreAllImpl.getInstance();

	public List<Student> showStudent() {
		return dao.selectStudentByAll();
	}

	public List<Subject> showSubList() {
		return subDao.selectSubjectName();
	}

	public List<StudentScoreAll> showStudentScoreBySubject(Subject subject) {
		return scoDao.selectStudentScoreBySubject(subject);
	}
	public List<StudentScoreAll> showStudentScoreByAvg(){
		return scoDao.selectStudentScoreByAvg();
	}
	
	public List<Score> showStdScoreBySubNo(Subject subject){
		return scoreDao.selectstdScoreBysubNo(subject);
	}

}
