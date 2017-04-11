package lk.harshana.service;

import java.util.List;

import lk.harshana.model.Course;

public interface CourseService {

	void saveCourse(Course course);
	List<Course> getAllCourses();
	
}
