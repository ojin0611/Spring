package com.example.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.vo.StudentVO;

@Repository("studentDao")
public class StudentDaoImpl implements StudentDao {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void insertStudent(StudentVO student) {
		this.sqlSession.insert("insert", student);
	}

	@Override
	public StudentVO selectStudent(String hakbun) {
		//return this.sqlSession.selectOne("selectOne", hakbun);
		Map<String, Object> map= new HashMap<String, Object>();
		map.put("hakbun", hakbun);
		this.sqlSession.selectOne("selectOneSP", map);
		List<StudentVO> list = (List<StudentVO>)map.get("result");
		return list.get(0);
	}

	@Override
	public List<StudentVO> selectAllStudent() {
		//return this.sqlSession.selectList("selectAll");
		Map<String, Object> map= new HashMap<String, Object>();
		this.sqlSession.selectList("selectAllSP", map);
		List<StudentVO> list = (List<StudentVO>)map.get("result");
		return list;
	}

	@Override
	public void updateStudent(StudentVO student) {
		this.sqlSession.update("update", student);
	}

	@Override
	public void deleteStudent(String hakbun) {
		this.sqlSession.delete("delete", hakbun);
	}

}
