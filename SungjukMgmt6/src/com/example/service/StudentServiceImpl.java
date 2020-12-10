package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.StudentDao;
import com.example.vo.StudentVO;

@Service("studentService")
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDao studentDao;
	
	@Override
	public void create(StudentVO student) {
		this.calculate(student);
		this.studentDao.insertStudent(student);
	}
	
	private void calculate(StudentVO student) {
		int tot = student.getKor() + student.getEng() + student.getMat();
		double avg = tot / 3.;
		char grade = (avg >= 90) ? 'A' :
						(avg >= 80) ? 'B' :
							(avg >= 70) ? 'C' :
								(avg >= 60) ? 'D' : 'F';
		student.setTot(tot);
		student.setAvg(avg);
		student.setGrade(grade);
	}

	@Override
	public StudentVO read(String hakbun) {
		return this.studentDao.selectStudent(hakbun);
	}

	@Override
	public List<StudentVO> readAll() {
		return this.studentDao.selectAllStudent();
	}

	@Override
	public void update(StudentVO student) {
		this.calculate(student); // 다시 계산
		this.studentDao.updateStudent(student);
	}

	@Override
	public void delete(String hakbun) {
		this.studentDao.deleteStudent(hakbun);
	}

}
