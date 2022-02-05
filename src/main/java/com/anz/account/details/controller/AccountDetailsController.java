package com.anz.account.details.controller;

import java.util.List;
import java.util.concurrent.Callable;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.anz.account.details.model.AccountSummary;
import com.anz.account.details.model.AccountTransaction;
import com.anz.account.details.model.AccountTransactionRequest;
import com.anz.account.details.services.AccountSummaryService;
import com.anz.account.details.services.AccountTransactionService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
@RequiredArgsConstructor
public class AccountDetailsController {

	
	private final AccountSummaryService accountSummaryService;
	
	private final AccountTransactionService accountTransactionService;
	
	@GetMapping(value = "v1/accounts/getAccountList")
	public  Callable<ResponseEntity<List<AccountSummary>>> getAccountSummary(final @RequestHeader HttpHeaders httpHeaders){
		
		 return () -> new ResponseEntity<>(accountSummaryService.getAccountSummary(httpHeaders),HttpStatus.OK);
	}
	
	
	@PostMapping(value = "v1/accounts/getAccountTransactionByAccountId")
	public Callable<ResponseEntity<List<AccountTransaction>>> getAccountTransactionBy(@RequestBody final AccountTransactionRequest accountTxn,final @RequestHeader HttpHeaders httpHeaders){
			
		return () ->  new ResponseEntity<>(accountTransactionService.getAccountTransactionBy(accountTxn,httpHeaders),HttpStatus.OK);
	} 
}
