package com.example.Bank.Management.System.controller;

import com.example.Bank.Management.System.entity.BankAccount;
import com.example.Bank.Management.System.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bankaccounts")
@CrossOrigin(origins = "http://localhost:3000")
public class AccountController
{
    @Autowired
    private BankAccountService accountService;

    @PostMapping("/accounts")
    public BankAccount saveAccount(@RequestBody BankAccount account,
                                   @RequestParam Long userId)
    {
        return accountService.saveAccount(account, userId);
    }


    @GetMapping
    public List<BankAccount> getAllAccounts()
    {
        return accountService.getAllAccounts();
    }

    @GetMapping("/{id}")
    public BankAccount getAccountById(@PathVariable Long id)
    {
        return accountService.getAccountById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable Long id)
    {
        accountService.deleteAccount(id);
    }

}
