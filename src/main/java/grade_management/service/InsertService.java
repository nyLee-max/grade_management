package grade_management.service;

import java.util.ArrayList;

import grade_management.dao.ScoreDao;
import grade_management.dao.StudentDao;
import grade_management.dao.impl.ScoreDaoImpl;
import grade_management.dao.impl.StudentDaoImpl;
import grade_management.dto.Score;
import grade_management.dto.Student;

public class InsertService {
	private StudentDao dao = StudentDaoImpl.getInstance();
	private ScoreDao scoredao = ScoreDaoImpl.getInstance();

	public void addStudent(Student student) {
		dao.insertStudent(student);
	}

	public void addScore(Score score) {
		scoredao.insertScore(score);
	}
	public void modifyStudent(Student student) {
		dao.updateStudent(student);
	}
}
