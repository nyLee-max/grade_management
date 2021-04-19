package grade_management.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import grade_management.dao.ScoreDao;
import grade_management.dto.Score;
import grade_management.dto.Student;
import grade_management.dto.Subject;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ScoreDaoImplTest {
	private static ScoreDao dao = ScoreDaoImpl.getInstance();
	
	@Test
	public void test01SelectScoreByAll() {
		System.out.printf("%s%n", "testSelectScoreByAll");
		List<Score> list = dao.selectScoreByAll();
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);
	}

	@Test
	public void test05SelectScoreBystdNo() {
		System.out.printf("%s()%n", "testSelectScoreBystdNo");
		List<Score> scorelist = dao.selectScoreBystdNo(new Student(20001));
		Assert.assertNotNull(scorelist);
		scorelist.stream().forEach(System.out::println);	
	}

	@Test
	public void test02InsertScore() {
		System.out.printf("%s()%n", "test02InsertScore");
		Score newScore = new Score(new Student(20028), new Subject(5), 90);
		int res = dao.insertScore(newScore);
		Assert.assertEquals(1, res);
		System.out.println(dao.selectScoreBystdNo(newScore.getStudent()));
	}

	@Test
	public void test03UpdateScore() {
		System.out.printf("%s()%n", "test03UpdateScore");
		Score newScore = new Score(new Student(20028), new Subject(4),100);
		int res = dao.updateScore(newScore);
		Assert.assertEquals(1, res);
		System.out.println(dao.selectScoreBystdNo(newScore.getStudent()));
	}

	@Test
	public void test04DeleteScore() {
		System.out.printf("%s()%n", "test04DeleteScore");
		Score newScore = new Score(new Student(20028));
		int res = dao.deleteScore(newScore);
		Assert.assertEquals(1, res);
		dao.selectScoreByAll().stream().forEach(System.out::println);
	}

	@Test
	public void test05SelectScoreBysubNo() {
		System.out.printf("%s()%n", "test05SelectScoreBysubNo()");
		
		List<Score> scoreList = dao.selectScoreBysubNo(new Subject(5));
		Assert.assertNotNull(scoreList);
		
		scoreList.stream().forEach(System.out::println);
	}

}
