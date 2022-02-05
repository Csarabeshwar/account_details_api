package com.anz.account.details.component.repository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import com.anz.account.details.model.AccountSummary;
import com.anz.account.details.repository.IAccountSummaryRepository;

@ComponentTest
@Sql(scripts = {"/db/test_data/data_setup.sql"}, executionPhase = BEFORE_TEST_METHOD)
@Sql(scripts = {"/db/test_data/data_cleanup.sql"}, executionPhase = AFTER_TEST_METHOD)
public class AccountSummaryRepoTest {

	 @Autowired
	 private IAccountSummaryRepository accountSummaryRepository;
	 
	 @Test
	  void findByAllAccountDetails_thenReturnAccountList() {
	    List<AccountSummary> accountSummary = accountSummaryRepository.findAll();
	    assertThat(accountSummary.size(), is(10));
	  }
}
