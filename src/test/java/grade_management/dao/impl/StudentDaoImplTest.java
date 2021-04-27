package grade_management.dao.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import grade_management.dao.StudentDao;
import grade_management.dto.Ban;
import grade_management.dto.Student;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentDaoImplTest {
	private static StudentDao dao = StudentDaoImpl.getInstance();
	
	//@Test
	public void test01SelectStudentByAll() {
		System.out.printf("%s%n", "test01SelectStudentByAll");
		List<Student> list = dao.selectStudentByAll();
		Assert.assertNotNull(list);
		/*
		 * for(Student s : list) { System.out.println(s);
		 * System.out.printf("score >> ");
		 * s.getScore().stream().forEach(System.out::print); }
		 */
	}

	//@Test
	public void test02SelectStudentByclassCode() {
		System.out.printf("%s%n","testSelectStudentByclassCode");
		List<Student> list = dao.selectStudentByclassCode(new Student(new Ban("A01")));
		list.stream().forEach(System.out::println);
		Assert.assertNotNull(list);
		
	}

	//@Test
	public void test03InsertStudent() {
		System.out.printf("%s%n", "testInsertStudent");
		Student newStudent = new Student(20031, new Ban("A01"), "김상건", new Date(119,3,2));
		System.out.println(newStudent);
		int res = dao.insertStudent(newStudent);
		Assert.assertEquals(1, res);
		System.out.println(dao.selectStudentByclassCode(newStudent));
		
	}

	//@Test
	public void test04UpdateStudent() {
		System.out.printf("%s%n", "testUpdateStudent");
		Student newStudent = new Student(20031, new Ban("A02"),"이나연",new Date(120,3,2));
		int res = dao.updateStudent(newStudent);
		Assert.assertEquals(1, res);
		System.out.println(dao.selectStudentByclassCode(newStudent));
	}

	//@Test
	public void test05DeleteStudent() {
		System.out.printf("%s%n0", "testDeleteStudent");
		Student newStudent = new Student(20031);
		int res = dao.deleteStudent(newStudent);
		Assert.assertEquals(1, res);
		dao.selectStudentByAll().stream().forEach(System.out::println);
	}

	//@Test
	public void test06SelectStudent() {
		System.out.printf("%s%n", "select06Student");
		Student student = dao.selectStudent(new Student(20001));
		System.out.println(student);
		Assert.assertNotNull(student);
	}
	
	@Test
	public void test07SelectStudentTable() {
		System.out.printf("%s%n", "test07SelectStudentTable");
		List<Student> student = dao.selectStudentTable(new Student(new Ban("A01")));
		Assert.assertNotNull(student);
		student.stream().forEach(System.out::println);
	}
}
