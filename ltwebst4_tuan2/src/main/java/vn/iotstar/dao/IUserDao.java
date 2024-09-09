package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.models.UserModel;

public interface IUserDao {
	List<UserModel> findAll();
	
	UserModel findByID (int id);
	
	void insert (UserModel user);
}
