package lk.harshana.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import lk.harshana.entities.User;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
