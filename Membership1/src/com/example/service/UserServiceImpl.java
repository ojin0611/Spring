package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.UserDao;
import com.example.vo.UserVO;

// Service Layer 
@Service("userService")
public class UserServiceImpl implements UserService {
	
	// Data Access Layer 호출!
	@Autowired
	private UserDao userDao;

	@Override
	public void insertUser(UserVO user) {
		// TODO Auto-generated method stub
		this.userDao.insert(user);
	}

	@Override
	public List<UserVO> getUserList() {
		// TODO Auto-generated method stub
		return this.userDao.readAll();
	}

	@Override
	public void deleteUser(String id) {
		this.userDao.delete(id);

	}

	@Override
	public UserVO getUser(String id) {
		// TODO Auto-generated method stub
		return this.userDao.read(id);
	}

	@Override
	public void updateUser(UserVO user) {
		this.userDao.update(user);

	}

}
