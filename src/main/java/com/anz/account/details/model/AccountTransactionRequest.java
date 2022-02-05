package com.anz.account.details.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter
@AllArgsConstructor @Builder @NoArgsConstructor
public class AccountTransactionRequest implements Serializable{

	private String accountNumber;
	
}
