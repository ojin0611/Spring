package com.example.service;

import java.util.List;

import com.example.vo.UserVO;

public interface UserService {
	void insertUser(UserVO user); // C
	List<UserVO> getUserList(); // R
	void deleteUser(String id); // D
	UserVO getUser(String id); // R
	void updateUser(UserVO user); // U
}
