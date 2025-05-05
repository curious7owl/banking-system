package com.example.banking.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {
    private double balance = 0;

    @GetMapping("/balance")
    public String getBalance() {
        return "Balance: Rs. " + balance;
    }

    @PostMapping("/deposit")
    public String deposit(@RequestParam double amount) {
        balance += amount;
        return "Deposited Rs. " + amount + ", New Balance: Rs. " + balance;
    }

    @PostMapping("/withdraw")
    public String withdraw(@RequestParam double amount) {
        if (amount <= balance) {
            balance -= amount;
            return "Withdrew Rs. " + amount + ", New Balance: Rs. " + balance;
        } else {
            return "Insufficient balance!";
        }
    }
}