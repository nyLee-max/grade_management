package grade_management.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import grade_management.dao.impl.BanDaoImpl;
import grade_management.dto.Ban;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BanDaoImplTest {
	
	private static BanDaoImpl dao = BanDaoImpl.getInstance();

	@Test
	public void test03SelectBanByAll() {
		System.out.printf("%s()%n", "testSelectBanByAll");
		List<Ban> list = dao.selectBanByAll();
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);
	}

	@Test
	public void test01InsertBan() {
		System.out.printf("%s()%n", "testInsertBan");
		Ban newBan = new Ban("A04");
		int res = dao.insertBan(newBan);
		Assert.assertEquals(1, res);
		System.out.println(newBan);
	}


 	@Test
	public void test02DeleteBan() {
		System.out.printf("%s()%n", "test02DeleteBan");
		Ban newBan = new Ban("A04");
		int res = dao.deleteBan(newBan);
		Assert.assertEquals(1, res);
		dao.selectBanByAll().stream().forEach(System.out::println);
	}

}
