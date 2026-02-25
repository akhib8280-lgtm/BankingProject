package com.example.Bank.Management.System.controller;
import com.example.Bank.Management.System.entity.BankTransaction;
import com.example.Bank.Management.System.service.BankTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/banktransaction")
@CrossOrigin(origins = "http://localhost:3000")
public class TransactionController
{
    @Autowired
    private BankTransactionService transactionService;

    @PostMapping("/transactions")
    public BankTransaction saveTransaction(@RequestBody BankTransaction transaction)
    {
        return transactionService.saveTransaction(transaction);
    }

    @GetMapping
    public List<BankTransaction> getAllTransactions()
    {
        return transactionService.getAllTransactions();
    }

    @GetMapping("/transactions")
    public List<BankTransaction> getTransactionsByAccountId(@RequestParam Long accountId)
    {
        return transactionService.getTransactionsByAccountId(accountId);
    }

    @GetMapping("/{id}")
    public BankTransaction getTransactionById(@PathVariable Long id)
    {
        return transactionService.getTransactionById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteTransaction(@PathVariable Long id)
    {
        transactionService.deleteTransaction(id);
    }
}
