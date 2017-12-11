package org.sample.java;

import static org.junit.Assert.*;

import org.junit.Test;

public class ConnectionPoolTest {
	
	@Test
	public void test() {
	
		ConnectionPool connectionPool = new ConnectionPool(5);
		assertTrue(5 == connectionPool.size());
		
		Connection connection1 = connectionPool.getConnection(); 
		assertTrue(connection1 != null);
		assertTrue(4 == connectionPool.size());
		
		Connection connection2 = connectionPool.getConnection();
		assertTrue(connection2 != null);
		assertTrue(3 == connectionPool.size());
		
		Connection connection3 = connectionPool.getConnection();
		assertTrue(connection3 != null);
		assertTrue(2 == connectionPool.size());
		
		connectionPool.release(connection1);
		assertTrue(3 == connectionPool.size());
		
		connectionPool.getConnection();
		connectionPool.getConnection();
		connectionPool.getConnection();
		assertNull(connectionPool.getConnection());
		
	}

}
