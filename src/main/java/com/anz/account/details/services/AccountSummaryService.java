package com.anz.account.details.services;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.anz.account.details.common.HttpHeader;
import com.anz.account.details.model.AccountSummary;
import com.anz.account.details.repository.IAccountSummaryRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountSummaryService {

	private final IAccountSummaryRepository accountSummaryRepo;

	public List<AccountSummary> getAccountSummary(HttpHeaders httpHeaders) {
		String correlationId = httpHeaders.getFirst(HttpHeader.X_CORRELATION_ID);

		log.debug("Fetching account summary from backend for request with correlationId: {}", correlationId);

		return accountSummaryRepo.findAll();
	}

}
