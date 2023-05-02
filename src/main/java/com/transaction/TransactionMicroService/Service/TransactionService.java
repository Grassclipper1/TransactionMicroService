package com.transaction.TransactionMicroService.Service;

import com.transaction.TransactionMicroService.Enteties.Account;
import com.transaction.TransactionMicroService.Enteties.Transaction;
import com.transaction.TransactionMicroService.Repos.AccountRepository;
import com.transaction.TransactionMicroService.Repos.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class TransactionService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    TransactionRepository transactionRepository;

    //deposits the defined amount into the chosen account
    public void credit(Long id, BigDecimal amount){
        Account account = accountRepository.findById(id).get();
        account.setBalance(account.getBalance().add(amount));
        accountRepository.save(account);

        Transaction transaction = new Transaction();
        transaction.setUserId(id);
        transaction.setTransactionType("credit");
        transaction.setAmount(amount);
        transaction.setTransactionDate(LocalDateTime.now());
        transactionRepository.save(transaction);
    }

    //checks the balance of the account, and then takes money from the account if the funds are sufficient

    public boolean debit(Long id, BigDecimal amount){
        Account account = accountRepository.findById(id).get();
        if (account.getBalance().compareTo(amount) >= 0  && amount.compareTo(BigDecimal.ZERO) > 0){
            account.setBalance(account.getBalance().subtract(amount));
            accountRepository.save(account);

            Transaction transaction = new Transaction();
            transaction.setUserId(id);
            transaction.setTransactionType("debit");
            transaction.setAmount(amount);
            transaction.setTransactionDate(LocalDateTime.now());
            transactionRepository.save(transaction);
            return true;
        } else {
            return false;
        }
    }
}
