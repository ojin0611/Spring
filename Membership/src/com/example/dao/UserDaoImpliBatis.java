package com.example.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.vo.UserVO;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

// Data Access Layer
@Repository("userDao2")
public class UserDaoImpliBatis implements UserDao {

	@Override
	public UserVO read(String id) {
		Reader rd = null;
		SqlMapClient smc = null;
		UserVO userVO = null;
		try {
			rd = Resources.getResourceAsReader("SqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			userVO = (UserVO) smc.queryForObject("Users.useResultMap", id);
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userVO;
	}

	@Override
	public void insert(UserVO user) {
		Reader rd = null;
		SqlMapClient smc = null;
		UserVO userVO = null;
		try {
			rd = Resources.getResourceAsReader("SqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			smc.insert("Users.insert", user);
			System.out.println("등록된 Record UserId=" + user.getUserId() + " Name=" + user.getName());
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<UserVO> readAll() {
		Reader rd = null;
		SqlMapClient smc = null;
		List<UserVO> userList = null;
		try {
			rd = Resources.getResourceAsReader("SqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			userList = (List<UserVO>) smc.queryForList("Users.getAll", null);
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userList;
	}

	@Override
	public void update(UserVO user) {
		Reader rd = null;
		SqlMapClient smc = null;
		UserVO userVO = null;
		try {
			rd = Resources.getResourceAsReader("SqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			smc.update("Users.update", user);
			System.out.println("갱신된 Record with ID = " + user.getUserId());
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(String id) {
		Reader rd = null;
		SqlMapClient smc = null;
		UserVO userVO = null;
		try {
			rd = Resources.getResourceAsReader("SqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			smc.delete("Users.delete", id);
			System.out.println("삭제된 Record with ID = " + id);
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
