package com.example.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.service.StudentService;
import com.example.vo.StudentVO;

import lombok.extern.java.Log;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:beans.xml"})
@Log
class StudentTest {
	@Autowired
	private StudentService studentService;
	
	@Disabled @Test
	public void test() {
		// insert
		StudentVO student = new StudentVO("2020-03", "이지민", 81, 47, 100);
		this.studentService.create(student);
		
		// Select All
		this.studentService.readAll().forEach(s -> log.info(s.toString()));
	}
	
	@Disabled @Test
	public void test1() {
		// Select One
		Scanner scan = new Scanner(System.in);
		System.out.print("학번 : ");
		String hakbun = scan.next().trim();
		StudentVO student = this.studentService.read(hakbun);
		log.info(student.toString());
	}
	
	@Disabled @Test
	public void test2() {
		// update        (insert와 update는 VO째로 넘어온다)
		StudentVO student = new StudentVO("2020-01", "한지민", 100, 100, 100);
		this.studentService.update(student);
		
		StudentVO student1 = this.studentService.read("2020-01");
		assertEquals(300, student1.getTot());
	}
	
	@Disabled @Test
	public void test3() {
		Scanner scan = new Scanner(System.in);
		System.out.print("삭제할 학생의 학번 : ");
		String hakbun = scan.next().trim();
		this.studentService.delete(hakbun);
		
		List<StudentVO> list = this.studentService.readAll();
		assertEquals(2, list.size());
	}
	
	@Test
	public void test4() {
		this.studentService.readAll().forEach(s -> log.info(s.toString()));
	}

}
