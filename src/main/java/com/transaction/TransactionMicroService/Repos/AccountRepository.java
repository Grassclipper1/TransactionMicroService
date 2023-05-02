package com.transaction.TransactionMicroService.Repos;

import com.transaction.TransactionMicroService.Enteties.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository <Account, Long> {
}
