package org.sample.java;

import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
	
	private int numConnections;
	private List<Connection> connectionList;
	
	public ConnectionPool(int numConnections) {
		this.numConnections = numConnections;
		
		// initialize connections
		connectionList = new ArrayList<Connection>(numConnections);
		for(int i = 1; i <= numConnections; i++) {
			connectionList.add(new Connection(i));
		}
	}
	
	public Connection getConnection() {
		if(connectionList.isEmpty()) {
			System.out.println("No Connection Avaialable!");
			return null;
		}
		
		return connectionList.remove(connectionList.size()-1);
	}

	public void release(Connection connection) {
		connectionList.add(connection);
	}
	
	public int size() {
		return connectionList.size();
	}
}
