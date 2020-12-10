package com.example.dao;

import java.util.List;

import com.example.vo.StudentVO;

public interface StudentDao {
	void insertStudent(StudentVO student);
	StudentVO selectStudent(String hakbun);
	List<StudentVO> selectAllStudent();
	void updateStudent(StudentVO student);
	void deleteStudent(String hakbun);
}
