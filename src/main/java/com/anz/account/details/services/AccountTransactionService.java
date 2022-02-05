package com.anz.account.details.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.anz.account.details.common.HttpHeader;
import com.anz.account.details.exceptions.AccountNotFoundException;
import com.anz.account.details.model.AccountTransaction;
import com.anz.account.details.model.AccountTransactionRequest;
import com.anz.account.details.repository.IAccountTransactionRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountTransactionService {

	private final IAccountTransactionRepository accountTransactionRepo;

	public List<AccountTransaction> getAccountTransactionBy(String accountNumber, HttpHeaders httpHeaders) {

		String correlationId = httpHeaders.getFirst(HttpHeader.X_CORRELATION_ID);
		log.info("No Account found for accountId :" + "X_CORRELATION_ID = " + correlationId);
		List<AccountTransaction> accountTxn = accountTransactionRepo.findByAccountNumber(accountNumber);
		log.info("After fetching fromDB");
		if (CollectionUtils.isEmpty(accountTxn)) {
			log.error("No Account found for accountId :" + accountNumber + "X_CORRELATION_ID");
			throw new AccountNotFoundException("No Account found for accountId :" + accountNumber);
		}

		accountTxn.forEach(txn -> {
			txn.setValueDate(formatDate(txn.getValueDate()));
		});

		return accountTxn;

	}

	private String formatDate(String date) {

		DateTimeFormatter sourceDate = new DateTimeFormatterBuilder().appendPattern("yyyy-MM-dd HH:mm:ss")
				.toFormatter();
		LocalDate parsedDate = LocalDate.parse(date, sourceDate);
		DateTimeFormatter targetDate = DateTimeFormatter.ofPattern("MMMM d, YYYY");
		return parsedDate.format(targetDate);
	}
}
