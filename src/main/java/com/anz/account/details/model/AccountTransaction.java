package com.anz.account.details.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "account_transaction_details")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table
public class AccountTransaction {

	@Id
	private String id;

//	@ManyToOne()
//	@JoinColumn(name = "accountId")
//	private AccountSummary accountSummary;
	
	@Column(name ="account_number")
	private String accountNumber;

	@Column(name ="account_name")
	private String accountName;

	@Column(name ="currency")
	private String currency;

	@Column(name ="value_date")
	private String valueDate;

	@Column(name ="debit_amount")
	private String debitAmount;

	@Column(name ="credit_amount")
	private String creditAmount;

	@Enumerated(EnumType.STRING)
	@Column(name ="debit_credit_indicator")
	private DebitCreditIndicator debitCreditIndicator;

	@Column(name ="transaction_narrative")
	private String transactionNarrative;

}
