package com.example.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.config.ApplicationConfig;
import com.example.service.UserService;
import com.example.vo.UserVO;

import lombok.extern.java.Log;

@ExtendWith(SpringExtension.class)
// @ContextConfiguration(locations = { "classpath:beans.xml" })
@ContextConfiguration(classes = {ApplicationConfig.class})
@Log
class UserTest {
	@Autowired
	private UserService userService;

	@Disabled
	@Test
	public void test() {
		UserVO user = this.userService.getUser("jimin");
//		System.out.println(user);
		log.info(user.toString());
		assertEquals("한지민", user.getName());
	}

	@Disabled
	@Test
	public void test1() {
		this.userService.insertUser(new UserVO("dooly", "둘리", "남", "경기"));
		/*
		 * for(UserVO user : this.userService.getUserList()){ System.out.println(user);
		 */
		List<UserVO> list = this.userService.getUserList();
		list.forEach(user -> log.info(user.toString()));

		assertEquals(2, list.size());
	}

	@Disabled
	@Test
	public void test2() {
		userService.updateUser(new UserVO("dooly", "김둘리", "여", "부산"));
		UserVO user = userService.getUser("dooly");
		log.info(user.toString());
		assertEquals("부산", user.getCity());
	}

	@Disabled
	@Test
	public void test3() {
		// 사용자 정보 삭제 test
		this.userService.deleteUser("dooly");
		for (UserVO user : userService.getUserList()) {
			System.out.println(user);
		}
	}
}
