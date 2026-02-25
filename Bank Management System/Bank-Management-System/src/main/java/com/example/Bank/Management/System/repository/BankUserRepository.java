package com.example.Bank.Management.System.repository;

import com.example.Bank.Management.System.entity.BankUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankUserRepository extends JpaRepository<BankUser, Long>
{
    boolean existsByEmail(String email);
    boolean existsByPhone(String Phone);
}
