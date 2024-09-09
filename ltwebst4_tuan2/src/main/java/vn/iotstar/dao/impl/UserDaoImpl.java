package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.configs.DBConnectSQLServer;
import vn.iotstar.dao.IUserDao;
import vn.iotstar.models.UserModel;

public class UserDaoImpl extends DBConnectSQLServer implements IUserDao {
	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;
	@Override
	public List<UserModel> findAll() {
		String sql = "select * from users";
		List<UserModel> list = new ArrayList<>();
		
		try {
			conn = super.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				list.add(
						new UserModel(rs.getInt("id"),
							rs.getString("username"),
							rs.getString("email"),
							rs.getString("password"),
							rs.getString("images"),
							rs.getString("fullname")
							)
						);
			}
			return list;
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public UserModel findByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(UserModel user) {
		String sql = "INSERT INTO users(id,username,email,password,images,fullname) VALUES (?,?,?,?,?,?) ";
		
		try {
			conn = super.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getId());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getPassword());
			ps.setString(5, user.getImages());
			ps.setString(6, user.getFullname());
			
			ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main (String[] args){
		UserDaoImpl userDao = new UserDaoImpl();
		
		userDao.insert(new UserModel(6,"abc1","abc@gmail.com","123","","abssd"));
		List<UserModel> list = userDao.findAll();
		
		for (UserModel user : list) {
			System.out.println(user);
		}
	}
	
	
}
