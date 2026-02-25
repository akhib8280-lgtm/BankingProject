package com.example.Bank.Management.System.service;

import com.example.Bank.Management.System.entity.BankAccount;
import com.example.Bank.Management.System.entity.BankTransaction;
import com.example.Bank.Management.System.repository.BankAccountRepository;
import com.example.Bank.Management.System.repository.BankTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankTransactionService
{
    @Autowired
    private BankTransactionRepository repository;

    @Autowired
    private BankAccountRepository accountRepository;

    public BankTransaction saveTransaction(BankTransaction transaction)
    {
        Long accountId = transaction.getAccount().getAccountId();
        BankAccount account = accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        transaction.setAccount(account);

        return repository.save(transaction);
    }

    public List<BankTransaction> getAllTransactions()
    {
        return repository.findAll();
    }

    public List<BankTransaction> getTransactionsByAccountId(Long accountId)
    {
        return repository.findByAccount_AccountId(accountId);
    }
    public BankTransaction getTransactionById(Long id)
    {
        return repository.findById(id).orElse(null);
    }
    public void deleteTransaction(Long id)
    {
        repository.deleteById(id);
    }
}
