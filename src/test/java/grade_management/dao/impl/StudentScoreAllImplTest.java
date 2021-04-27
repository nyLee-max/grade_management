package grade_management.dao.impl;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import grade_management.dto.Ban;
import grade_management.dto.Student;
import grade_management.dto.StudentScoreAll;
import grade_management.dto.Subject;

public class StudentScoreAllImplTest {
	private static StudentScoreAllImpl dao = StudentScoreAllImpl.getInstance();
	
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSelectStudentScoreByAll() {
		System.out.printf("%s%n","testSelectStudentScoreByAll");
		List<StudentScoreAll> list = dao.selectStudentScoreByAll();
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);
	}

	@Test
	public void testSelectStudentScoreByClassCode() {
		System.out.printf("%s%n","testSelectStudentScoreByClassCode");
		List<StudentScoreAll> list = dao.selectStudentScoreByClassCode(new Ban("A01"));
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);
	}
	@Test
	public void testSelectStudentScoreBySubject() {
		System.out.printf("%s%n", "testSelectStudentScoreBySubject");
		List<StudentScoreAll> list = dao.selectStudentScoreBySubject(new Subject("국어"));
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);
	}
	
	@Test
	public void testSelectStudentScoreByBanSubject() {
		System.out.printf("%s%n", "testSelectStudentScoreByBanSubject");
		List<StudentScoreAll> list = dao.selectStudentScoreByBanSubject(new Ban("A01"), new Subject("국어"));
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);
	}
	
	@Test
	public void testSelectStudentScoreByStdNo() {
		System.out.printf("%s%n", "testSelectStudentScoreByStdNo");
		StudentScoreAll list = dao.selectStudentScoreByStdNo(new Student(4444));
		Assert.assertNotNull(list);
		System.out.println(list);
	}
	
	@Test
	public void testSelectStudentScoreByAvg() {
		System.out.printf("%s%n","testSelectStudentScoreByAvg");
		List<StudentScoreAll> list = dao.selectStudentScoreByAvg();
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);
	}
}
