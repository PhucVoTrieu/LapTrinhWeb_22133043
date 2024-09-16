package vn.iotstar.services.impl;

import java.sql.Date;

import vn.iotstar.dao.IUserDao;
import vn.iotstar.dao.impl.UserDao;
import vn.iotstar.models.User;
import vn.iotstar.services.IUserService;

public class UserServiceImpl implements IUserService {
	// Lấy tất cả hàm của tầng dao
	IUserDao userDao = new UserDao();

	@Override
	public User login(String username, String password) {
		User user = this.findByUserName(username);
		if (user != null && password.equals(user.getPassword())) {
			return user;
		}
		return null;
	}

	@Override
	public User findByUserName(String username) {
		return userDao.findByUserName(username);
	}

	@Override
	public void insert(User user) {
		userDao.insert(user);
	}

	@Override
	public boolean checkExistEmail(String email) {
		return userDao.checkExistEmail(email);
	}

	@Override
	public boolean checkExistUsername(String username) {
		return userDao.checkExistUsername(username);
	}

	@Override
	public boolean checkExistPhone(String phone) {
		return userDao.checkExistPhone(phone);
	}

	@Override
	public boolean register(String username, String email, String fullname, String images, String password,
			String phone) {
		if (userDao.checkExistUsername(username)) {
			return false;
		}
		long millis = System.currentTimeMillis();
		Date date = new java.sql.Date(millis);
		userDao.insert(new User(username, email, fullname, images, password, phone, date));
		return true;
	}

	@Override
	public boolean updatePassword(String username, String newPassword) {
		if (!userDao.checkExistUsername(username)) {
			return false;
		}
		userDao.updatePassword(username, newPassword);
		return true;
	}

}
