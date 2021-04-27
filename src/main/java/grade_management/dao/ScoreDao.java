package grade_management.dao;

import java.util.ArrayList;
import java.util.List;

import grade_management.dto.Score;
import grade_management.dto.Student;
import grade_management.dto.Subject;

public interface ScoreDao {
	List<Score> selectScoreByAll();
	List<Score> selectScoreBystdNo(Student student);
	
	int insertScore(Score score);
	int updateScore(Score score);
	int deleteScore(Score score);
	
	List<Score> selectScoreBysubNo(Subject subject);
	List<Score> selectstdScoreBysubNo(Subject subject);
}
