package com.transaction.TransactionMicroService.Controllers;

import com.transaction.TransactionMicroService.Enteties.Account;
import com.transaction.TransactionMicroService.Repos.AccountRepository;
import com.transaction.TransactionMicroService.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/account")
public class AccountRestController {

    @Autowired
    AccountRepository accountRepository;
    @Autowired
    TransactionService transactionService;

    //Displays the information of the account, right now two accounts are pre-loaded
    @GetMapping("/{id}")
    public Account getAccount(@PathVariable Long id){
    Account account = accountRepository.findById(id).get();
        return account;
    }

    //adds "money" to your account
    @PostMapping("/credit/{id}")
    public ResponseEntity<String> credit(@PathVariable Long id, @RequestParam BigDecimal amount){
        transactionService.credit(id, amount);
        return ResponseEntity.ok("Credit transaction completed successfully");
    }
    //removes money from your account
    //Returns different response depending on if the transaction was successful or not, based on your balance
    @PostMapping("/debit/{id}")
    public ResponseEntity<String> debit(@PathVariable Long id, @RequestParam BigDecimal amount){
        boolean success = transactionService.debit(id, amount);
        if (success){
            return ResponseEntity.ok("Debit transaction completed successfully");
        } else {
            return ResponseEntity.badRequest().body("Insufficient balance");
        }
    }
}
