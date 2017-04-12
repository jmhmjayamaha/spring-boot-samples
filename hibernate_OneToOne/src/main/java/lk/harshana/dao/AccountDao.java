package lk.harshana.dao;

import org.springframework.data.repository.CrudRepository;

import lk.harshana.model.Account;

public interface AccountDao extends CrudRepository<Account, Long>{

}
