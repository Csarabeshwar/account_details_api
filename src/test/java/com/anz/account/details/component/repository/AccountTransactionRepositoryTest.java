package com.anz.account.details.component.repository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import com.anz.account.details.model.AccountTransaction;
import com.anz.account.details.repository.IAccountTransactionRepository;

@ComponentTest
@Sql(scripts = {"/db/test_data/data_setup.sql"}, executionPhase = BEFORE_TEST_METHOD)
@Sql(scripts = {"/db/test_data/data_cleanup.sql"}, executionPhase = AFTER_TEST_METHOD)
public class AccountTransactionRepositoryTest {

	 @Autowired
	 private IAccountTransactionRepository accountTransactionRepository;
	 
	 @Test
	  void findByAllAccountDetails_thenReturnAccountList() {
	    List<AccountTransaction> accountSummary = accountTransactionRepository.findByAccountNumber("847257972");
	    assertThat(accountSummary.size(), is(2));
	  }
}
