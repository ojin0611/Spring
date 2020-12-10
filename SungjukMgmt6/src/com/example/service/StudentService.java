package com.example.service;

import java.util.List;

import com.example.vo.StudentVO;

public interface StudentService {
	void create(StudentVO student);
	StudentVO read(String hakbun);
	List<StudentVO> readAll();
	void update(StudentVO student);
	void delete(String hakbun);
	
}
