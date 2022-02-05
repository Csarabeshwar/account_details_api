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

import com.anz.account.details.model.AccountSummary;
import com.anz.account.details.model.AccountType;
import com.anz.account.details.repository.IAccountSummaryRepository;
import com.anz.account.details.services.AccountSummaryService;

@ExtendWith(MockitoExtension.class)
public class AccountSummaryServicesTest {

	@InjectMocks
	private AccountSummaryService accountService;

	@Mock
	private IAccountSummaryRepository accountSummaryRepo;

	@Test
	void getAll_accountDetails_thenReturnAllAccountInfo() {
		List<AccountSummary> accountSummary = mockAccountSummary();
		when(accountSummaryRepo.findAll()).thenReturn(accountSummary);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("X_CORRELATION_ID", "TEST_04022022");
		List<AccountSummary> accountSummaries = accountService.getAccountSummary(httpHeaders);
		assertThat(accountSummaries.size(), is(1));
		assertThat(accountSummaries.get(0).getAccountName(), is("TestCurrentAccount"));

	}

	private List<AccountSummary> mockAccountSummary() {
		return Arrays.asList(AccountSummary.builder().accountId("1").accountName("TestCurrentAccount")
				.accountNo("12365479").accountType(AccountType.Current).availableBalance("10230.00")
				.balanceDate("11/02/2022").build());
	}

}
