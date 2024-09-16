package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.models.User;

public interface IUserDao {

	List<User> findAll();

	User findByUserName(String username);

	void insert(User user);
	void updatePassword(String username, String newPassword);
	boolean checkExistEmail(String email);
	boolean checkExistUsername(String username);
	boolean checkExistPhone(String phone);
}
