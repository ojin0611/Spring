package com.example.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.vo.UserVO;

// Data Access Layer
@Repository("userDaoJdbc")
public class UserDaoImplJdbcTemplate implements UserDao {

	// JDBC Interface
	@Autowired
	private JdbcTemplate jdbcTemplate;

//	class MyRowMapper<userVO> implements RowMapper<UserVO>{
//
//		@Override
//		public UserVO mapRow(ResultSet rs, int rowNum) throws SQLException {
//			UserVO userVO = new UserVO();
//			return userVO;
//		}
//	}
	@SuppressWarnings("deprecation")
	@Override
	public UserVO read(String id) {
		String sql = "SELECT * FROM users WHERE userid = ?";
		return this.jdbcTemplate.queryForObject(sql, new Object[] { id }, (rs, rowNum) -> {
			UserVO userVO = new UserVO();
			userVO.setUserId(rs.getString("userid"));
			userVO.setName(rs.getString("name"));
			userVO.setGender(rs.getString("gender"));
			userVO.setCity(rs.getString("city"));
			return userVO;

			/*
			 * 위의 lambda 식을 풀면 아래와 같다.
			 * 
			 * @Override public UserVO mapRow(ResultSet rs, int rowNum) throws SQLException
			 * { UserVO userVO = new UserVO(); userVO.setUserId(rs.getString("userid"));
			 * userVO.setName(rs.getString("name"));
			 * userVO.setGender(rs.getString("gender"));
			 * userVO.setCity(rs.getString("city")); return userVO; }
			 */
		});

	}

	@Override
	public void insert(UserVO user) {
		String sql = "INSERT INTO users (userid, name, gender,city) VALUES (?, ?, ?, ?)";
		this.jdbcTemplate.update(sql, user.getUserId(), user.getName(), user.getGender(), user.getCity());
	}

	@Override
	public List<UserVO> readAll() {
		String sql = "SELECT * FROM users ORDER BY userid";
		return this.jdbcTemplate.query(sql, new RowMapper<UserVO>() {

			@Override
			public UserVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				UserVO userVO = new UserVO();
				userVO.setUserId(rs.getString("userid"));
				userVO.setName(rs.getString("name"));
				userVO.setGender(rs.getString("gender"));
				userVO.setCity(rs.getString("city"));
				return userVO;
			}

		});
	}

	@Override
	public void update(UserVO user) {
		String sql = "UPDATE users SET name = ?, gender = ?, city = ? WHERE userid = ?";
		this.jdbcTemplate.update(sql, user.getName(), user.getGender(), user.getCity(), user.getUserId());
	}

	@Override
	public void delete(String id) {
		String sql = "DELETE FROM users WHERE userid = ?";
		this.jdbcTemplate.update(sql, id);
	}
}
