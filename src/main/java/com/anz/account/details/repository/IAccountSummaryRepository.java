package com.anz.account.details.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anz.account.details.model.AccountSummary;

@Repository
public interface IAccountSummaryRepository extends JpaRepository<AccountSummary, String> {
	
	List<AccountSummary> findAll();
}
