package com.transaction.TransactionMicroService.Enteties;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "transaction_type")
    String transactionType;

    int amount;

    Long userId;

    @Column (name = "transaction_date")
    LocalDateTime transactionDate;

    public Transaction() {
    }

    public Transaction(String transactionType, int amount, Long userId, LocalDateTime transactionDate) {
        this.transactionType = transactionType;
        this.amount = amount;
        this.userId = userId;
        this.transactionDate = transactionDate;
    }
}
