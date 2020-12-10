package com.example.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.service.UserService;
import com.example.vo.UserVO;

import lombok.extern.java.Log;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:beans.xml"})
//@ContextConfiguration(classes= {ApplicationConfig.class})

@Log
class MembershipTest {
	@Autowired
	private UserService userService;

	@Disabled @Test
	void test() {
		assertNotNull(this.userService);
		
		UserVO userVO = this.userService.getUser("jimin");
		// System.out.println(userVO);
		
		log.info(userVO.toString());
		
		
	}
	
	@Disabled @Test
	public void test1() {
		//insert
		UserVO userVO = new UserVO("dooly", "둘리", "남", "경기");
		this.userService.insertUser(userVO);
		
		//selectAll
		List<UserVO> list = this.userService.getUserList();
		for(UserVO user : list) {
			//System.out.println(user);
			log.info(user.toString());
		}
		
		assertEquals(2, list.size());
	}
	
	@Disabled @Test
	public void test2() {
		//사용자 정보 수정 test
		this.userService.updateUser(new UserVO("dooly", "김둘리", "여", "부산"));
		UserVO user = this.userService.getUser("dooly");
		// System.out.println(user);
		log.info(user.toString());
		assertEquals("부산", user.getCity());
		
	}
	
	@Disabled @Test
	public void test3() {
		// delete
		this.userService.deleteUser("dooly");
		
		// 모든user 가져와
		this.userService.getUserList().forEach(user -> System.out.println(user));
	}

}
