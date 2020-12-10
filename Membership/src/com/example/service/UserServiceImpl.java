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
	private UserDao userDao2;

	@Override
	public void insertUser(UserVO user) {
		// TODO Auto-generated method stub
		this.userDao2.insert(user);
	}

	@Override
	public List<UserVO> getUserList() {
		// TODO Auto-generated method stub
		return this.userDao2.readAll();
	}

	@Override
	public void deleteUser(String id) {
		this.userDao2.delete(id);

	}

	@Override
	public UserVO getUser(String id) {
		// TODO Auto-generated method stub
		return this.userDao2.read(id);
	}

	@Override
	public void updateUser(UserVO user) {
		this.userDao2.update(user);

	}

}
