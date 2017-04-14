package lk.harshana.repo;

import org.springframework.data.repository.CrudRepository;

import lk.harshana.model.User;

public interface UserRepository extends CrudRepository<User, Integer>{

}
