package com.transaction.TransactionMicroService.Enteties;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "account_number")
    String accountNumber;

    int balance;

    public Account() {
    }

    public Account(Long id, String accountNumber, int balance) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
}


