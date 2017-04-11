package lk.harshana.service;

import java.util.List;

import lk.harshana.model.Student;

public interface StudentService {

	void saveStudent(Student student);
	List<Student> getAllStudents();
	
}
