package com.example.Bank.Management.System;

import com.example.Bank.Management.System.entity.BankUser;
import com.example.Bank.Management.System.repository.BankUserRepository;
import com.example.Bank.Management.System.service.BankUserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BankUserServiceTest {

    @Mock
    private BankUserRepository repository;

    @InjectMocks
    private BankUserService service;

    @Test
    void testSaveUser() {
        BankUser user = new BankUser();
        user.setName("Akhib");
        user.setEmail("akhib@gmail.com");

        when(repository.save(user)).thenReturn(user);

        BankUser savedUser = service.saveUser(user);

        assertNotNull(savedUser);
        assertEquals("Akhib", savedUser.getName());
        verify(repository, times(1)).save(user);
    }

    @Test
    void testGetAllUsers() {
        BankUser user1 = new BankUser();
        user1.setName("Akhib");
        BankUser user2 = new BankUser();
        user2.setName("Haleema");

        when(repository.findAll()).thenReturn(Arrays.asList(user1, user2));

        List<BankUser> users = service.getAllUsers();

        assertEquals(2, users.size());
        verify(repository, times(1)).findAll();
    }

    @Test
    void testGetUserById() {
        BankUser user = new BankUser();
        user.setUserId(1L);
        user.setName("Akhib");
        user.setUserId(2L);
        user.setUserId("sakib");

        when(repository.findById(1L)).thenReturn(Optional.of(user));

        BankUser foundUser = service.getUserById(1L);

        assertNotNull(foundUser);
        assertEquals(1L, foundUser.getUserId());
        verify(repository, times(1)).findById(1L);
    }

    @Test
    void testDeleteUser() {
        doNothing().when(repository).deleteById(1L);

        service.deleteUser(1L);

        verify(repository, times(1)).deleteById(1L);
    }
}
