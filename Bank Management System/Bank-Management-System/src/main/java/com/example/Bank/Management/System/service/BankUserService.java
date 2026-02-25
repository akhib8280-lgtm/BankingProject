package com.example.Bank.Management.System.service;
import com.example.Bank.Management.System.entity.BankUser;
import com.example.Bank.Management.System.repository.BankUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankUserService
{
    @Autowired
private BankUserRepository repository;
    public BankUser saveUser(BankUser user)
    {
        if(repository.existsByEmail(user.getEmail()))
        {
            throw new RuntimeException("Email already exists");
        }
        if(repository.existsByPhone(user.getPhone())) {
            throw new RuntimeException("Phone number already registered");
        }

        return repository.save(user);
    }

    public List<BankUser> getAllUsers()
    {
        return repository.findAll();
    }
    public BankUser getUserById(Long userId)
    {
        return repository.findById(userId).orElse(null);
    }
    public void deleteUser(Long userId)
    {
        repository.deleteById(userId);
    }
}
