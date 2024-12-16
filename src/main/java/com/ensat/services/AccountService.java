package com.ensat.services;

import com.ensat.Security.PasswordEncoder;
import com.ensat.entities.Account;
import com.ensat.entities.Role;
import com.ensat.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;
    private PasswordEncoder passwordEncoder;


    public List<Account> listAll() {
        return accountRepository.findAll();
    }

    public void save(Account account) {
        accountRepository.save(account);
    }

    public Integer update(Account account) {
        return accountRepository.update(account.getUID(), account.getName(), account.getPhone(), account.getAddress(), account.getGmail());
    }

    public Account get(Integer uID) {
        return accountRepository.findById(uID).get();
    }

    public void delete(Integer uID) {
        accountRepository.deleteById(uID);
    }

    public Account createAccount(Account account) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        Role defaultRole = new Role(2, "user");
        account.setRole(defaultRole);
        String user = account.getUser();
        Account existingAccount = accountRepository.findByUser(user);
        if (existingAccount != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Tên tài khoản đã tồn tại");
        }
        account.setPass(passwordEncoder.encode(account.getPass()));
        Account newAccount = accountRepository.save(account);
        return newAccount;
    }


    public Account findByUser(String user, String pass) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        Account account = accountRepository.findByUser(user);
        if (account != null) {
            if (passwordEncoder.encode(pass).equals(account.getPass())) {
                Integer rID = account.getRole().getrID();
                account.setrID(rID);
                return account;
            }
        }
        return null;
    }

    public boolean changePassword(Account account, String oldPassword, String newPassword) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        if (passwordEncoder.encode(oldPassword).equals(account.getPass())) {
            account.setPass(passwordEncoder.encode(newPassword));
            accountRepository.save(account);
            return true;
        }
        return false;
    }

    public Account findById(Integer uID) {
        return accountRepository.findById(uID).orElse(null);
    }
}
