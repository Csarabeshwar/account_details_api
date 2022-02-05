package com.anz.account.details.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anz.account.details.model.AccountTransaction;

@Repository
public interface IAccountTransactionRepository extends JpaRepository<AccountTransaction, String>{

	List<AccountTransaction> findByAccountNumber(String accountNumber);
}
