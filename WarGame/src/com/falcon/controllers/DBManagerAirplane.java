package com.falcon.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import com.falcon.dao.IConnection;
import com.falcon.dao.ITransaction;
import com.falcon.entities.Airplane;
import com.falcon.entities.User;
import com.falcon.io.FileLog;


public class DBManagerAirplane implements ITransaction {

	public static boolean validated = false;
	
	@Override
	public void insert(String type, int crew, String weapons, boolean radar, double autonomy, double fuel) throws FileLog, ClassNotFoundException, SQLException {

		try {

			IConnection connection = new IConnection() {};

			if (connection != null) {
				PreparedStatement ps;
				String sql = "INSERT INTO airplanes(type, crew, weapons, radar, autonomy, fuel) VALUES(?,?,?,?,?,?)";
				ps = connection.getConnection().prepareStatement(sql);
				ps.setString(1, type);
				ps.setInt(2, crew);
				ps.setString(3, weapons);
				ps.setBoolean(4, radar);
				ps.setDouble(5, autonomy);
				ps.setDouble(6, fuel);
				ps.executeUpdate();
				ps.close();
				System.out.println("Inserted successfull");

			} else {
				System.out.println("Connection appears to be null on Query");
			}

		} catch (FileLog error) {
			error.printStackTrace();
			System.out.println("Cannot even connect");
			throw new FileLog("Imposible to connect");
		}
	}

	@Override
	public void update(Object airplane, int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public HashMap getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static boolean getUserLogin(String user, String password) {
		
		User validateUser = new User();
		String stringUser = null;
		String stringPassword = null;
		
		try {
			IConnection connection = new IConnection() {};
			if(connection != null) {
				System.out.println("Connection successfully");
				Statement st;
				String sql = "SELECT user, password FROM users";
				st = connection.getConnection().createStatement();
				ResultSet rs = st.executeQuery(sql);
				while(rs.next()) {
					
					validateUser.setUser(rs.getString("user"));
					validateUser.setPasswrord(rs.getString("password"));
					stringUser = validateUser.getUser();
					stringPassword = validateUser.getPasswrord();
				}
			}else {
				System.out.println("Connection appears to be null");
			}
		}catch(Exception error) {
			error.printStackTrace();
		}
		
		if(stringUser.equals(user) && stringPassword.equals(password)) {
			validated = true;
		}
		return validated;
	}

}
