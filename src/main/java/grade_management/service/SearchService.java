package grade_management.service;

import java.util.List;

import grade_management.dao.BanDao;
import grade_management.dao.ScoreDao;
import grade_management.dao.StudentDao;
import grade_management.dao.SubjectDao;
import grade_management.dao.impl.BanDaoImpl;
import grade_management.dao.impl.ScoreDaoImpl;
import grade_management.dao.impl.StudentDaoImpl;
import grade_management.dao.impl.SubjectDaoImpl;
import grade_management.dto.Ban;
import grade_management.dto.Score;
import grade_management.dto.Student;
import grade_management.dto.Subject;

public class SearchService {
	private ScoreDao dao = ScoreDaoImpl.getInstance();
	private BanDao banDao = BanDaoImpl.getInstance();
	private StudentDao stuDao = StudentDaoImpl.getInstance();
	private SubjectDao subDao = SubjectDaoImpl.getInstance();

	public List<Ban> showBanList() {
		return banDao.selectBanByAll();
	}

	public List<Student> showStudent() {
		return stuDao.selectStudentByAll();
	}

	public List<Student> showStudentByClasscode(Student student) {
		return stuDao.selectStudentByclassCode(student);
	}

	public Student showStudentBystdNo(Student student) {
		return stuDao.selectStudent(student);
	}

//	int insertScore(Score score);
	public int insertScore(Score score) {
		return dao.insertScore(score);
	}

	public List<Subject> showSubList() {
		return null;
	}
}
