package lk.harshana.dao;

import org.springframework.data.repository.CrudRepository;

import lk.harshana.model.Course;

public interface CourseDao extends CrudRepository<Course, Long> {

}
