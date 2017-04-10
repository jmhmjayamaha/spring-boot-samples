package lk.harshana.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lk.harshana.dao.CourseDao;
import lk.harshana.model.Course;

@Service("courseService")
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDao courseDao;
	
	@Override
	public void saveCourse(Course course) {
		courseDao.save(course);
	}

}
