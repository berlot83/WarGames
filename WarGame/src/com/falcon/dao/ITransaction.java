package com.falcon.dao;

import java.sql.SQLException;
import java.util.HashMap;

import com.falcon.io.FileLog;

public interface ITransaction<Airplane> extends IConnection{
	void insert(String type, int crew, String weapons, boolean radar, double autonomy, double fuel) throws ClassNotFoundException, SQLException, FileLog;
	
	void update(Airplane airplane, int id);
	
	boolean delete(int id);
	
	HashMap<Integer, Airplane> getAll();
}
