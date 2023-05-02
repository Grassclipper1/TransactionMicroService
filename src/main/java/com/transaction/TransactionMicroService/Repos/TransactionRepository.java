package com.transaction.TransactionMicroService.Repos;

import com.transaction.TransactionMicroService.Enteties.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository <Transaction, Long> {
}
