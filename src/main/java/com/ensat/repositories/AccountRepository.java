package com.ensat.repositories;

import com.ensat.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


public interface AccountRepository extends JpaRepository<Account, Integer> {
    Account findByUser(String user);

    @Transactional
    @Modifying
    @Query(value = "update account set name=:name, phone=:phone, address=:address, gmail=:gmail where uID=:id", nativeQuery = true)
    Integer update(Integer id, String name, String phone, String address, String gmail);
}