package com.example.Bank.Management.System.controller;
import com.example.Bank.Management.System.entity.BankUser;
import com.example.Bank.Management.System.service.BankUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/bankuser")
@CrossOrigin(origins = "http://localhost:3000")
public class BankUserController
{
    @Autowired
    private BankUserService service;

    @PostMapping("/users")
    public ResponseEntity<?> saveUser(@Valid @RequestBody BankUser user)
    {

        try {
            BankUser savedUser = service.saveUser(user);
            return new ResponseEntity<>(savedUser, HttpStatus.CREATED);

        } catch (RuntimeException ex) {

            Map<String, String> error = new HashMap<>();
            error.put("message", ex.getMessage());

            return new ResponseEntity<>(error, HttpStatus.CONFLICT);
        }
    }
    @GetMapping
    public List<BankUser> getAllUsers()
    {
        return service.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id)
    {
        try {
            BankUser user = service.getUserById(id);
            return new ResponseEntity<>(user, HttpStatus.OK);

        } catch (RuntimeException ex) {

            Map<String, String> error = new HashMap<>();
            error.put("message", ex.getMessage());

            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id)
    {
        service.deleteUser(id);
    }
}
