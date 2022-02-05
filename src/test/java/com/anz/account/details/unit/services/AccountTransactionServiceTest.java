package com.anz.account.details.unit.services;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpHeaders;

import com.anz.account.details.model.AccountTransaction;
import com.anz.account.details.model.AccountTransactionRequest;
import com.anz.account.details.model.DebitCreditIndicator;
import com.anz.account.details.repository.IAccountTransactionRepository;
import com.anz.account.details.services.AccountTransactionService;

@ExtendWith(MockitoExtension.class)
public class AccountTransactionServiceTest {
	
	@InjectMocks
	private AccountTransactionService accountTxnService;

	@Mock
	private IAccountTransactionRepository accountTxnRepo;
	
	@Test
	public void getTxnFromAccountNumber_thenReturnTxns() {
		
		List<AccountTransaction> accountTxn = createAccountTxnMockData();
		when(accountTxnRepo.findByAccountNumber("123587")).thenReturn(accountTxn);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("X_CORRELATION_ID", "TEST_04022022");
		List<AccountTransaction> accountTxnResponse = accountTxnService.getAccountTransactionBy("123587", httpHeaders);
		assertThat(accountTxnResponse.size(), is(1));
		assertThat(accountTxnResponse.get(0).getAccountName(), is("TestSavingsAccount"));
		assertThat(accountTxnResponse.get(0).getValueDate(), is("December 12, 2021"));
	}

	private List<AccountTransaction> createAccountTxnMockData() {
		return Arrays.asList(AccountTransaction.builder().id("12").accountNumber("123587")
				.accountName("TestSavingsAccount")
				.creditAmount("0")
				.debitAmount("125.25")
				.currency("SGD").debitCreditIndicator(DebitCreditIndicator.Credit)
				.transactionNarrative(null).valueDate("2021-12-12 00:00:00").build());
	}

}
