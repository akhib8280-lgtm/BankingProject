package com.example.Bank.Management.System.service;

import com.example.Bank.Management.System.entity.BankAccount;
import com.example.Bank.Management.System.entity.BankUser;
import com.example.Bank.Management.System.repository.BankAccountRepository;
import com.example.Bank.Management.System.repository.BankUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankAccountService {
    @Autowired
    private BankAccountRepository repository;
    @Autowired
    private BankUserRepository userRepository;
    public BankAccount saveAccount(BankAccount account, Long userId)
    {
        BankUser user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        account.setUser(user);

        return repository.save(account);
    }
    public List<BankAccount> getAllAccounts()
    {
        return repository.findAll();
    }

    public BankAccount getAccountById(Long id)
    {
        return repository.findById(id).orElse(null);
    }

    public void deleteAccount(Long id)
    {
        repository.deleteById(id);
    }
}
