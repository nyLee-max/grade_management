package grade_management.database;

import java.sql.Connection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;


public class JdbcConnTest {

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetConnection() {
		System.out.printf("%s()%n", "testGetConnection");
		Connection con = JdbcConn.getConnection();
		System.out.println("con > "+ con);
		Assert.assertNotNull(con);
	}

}
