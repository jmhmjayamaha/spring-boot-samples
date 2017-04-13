package lk.harshana.dao;

import org.springframework.data.repository.CrudRepository;

import lk.harshana.model.Student;

public interface StudentDao extends CrudRepository<Student, Integer> {

}
