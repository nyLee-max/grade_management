package grade_management.dao.impl;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import grade_management.dto.Subject;

public class SubjectDaoImplTest {

	private SubjectDaoImpl dao = SubjectDaoImpl.getInstance();
	
	@Test
	public void test01SelectSubjectByAll() {
		System.out.printf("%s%n", "testSelectSubjectByAll");
		List<Subject> list = dao.selectSubjectByAll();
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);
	}

	@Test
	public void test02InsertSubject() {
		System.out.printf("%s%n", "testInsertSubject");
		Subject newSub = new Subject(6, "기술과 가정");
		int res = dao.insertSubject(newSub);
		Assert.assertEquals(1, res);
		System.out.println(dao.selectSubjectByAll());
	}

	@Test
	public void test03UpdateSubject() {
		System.out.printf("%s%n", "testUpdateSubject");
		Subject newSub = new Subject(6, "역사");
		int res = dao.updateSubject(newSub);
		Assert.assertEquals(1, res);
		System.out.println(dao.selectSubjectByAll());
	}

	@Test
	public void test04DeleteSubject() {
		System.out.printf("%s%n", "testDeleteSubject");
		Subject newSub = new Subject(6);
		int res = dao.deleteSubject(newSub);
		Assert.assertEquals(1, res);
		dao.selectSubjectByAll().stream().forEach(System.out::println);
	}
	
	@Test
	public void test05SelectSubjectName() {
		System.out.printf("%s%n", "test05SelectSubjectName");
		List<Subject> list = dao.selectSubjectName();
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);
	}

}
