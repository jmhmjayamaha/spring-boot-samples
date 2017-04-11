package lk.harshana.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lk.harshana.dao.StudentDao;
import lk.harshana.model.Student;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao;
	
	@Override
	public void saveStudent(Student student) {
		studentDao.save(student);
	}

	@Override
	public List<Student> getAllStudents() {
		return (List<Student>) studentDao.findAll();
	}

}
