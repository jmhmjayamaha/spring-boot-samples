package lk.harshana.dao;

import org.springframework.data.repository.CrudRepository;

import lk.harshana.model.User;

public interface UserDao extends CrudRepository<User, Long>{

}
