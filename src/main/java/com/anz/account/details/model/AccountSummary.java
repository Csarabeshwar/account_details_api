package com.anz.account.details.model;

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

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
@Table(name = "account_summary")
public class AccountSummary {


	@Id
	@Column(name ="account_id")
	private String accountId;
	
	@Column(name ="account_number")
    private String accountNo;
    
	@Column(name ="account_name")
    private String accountName;
    
    @Enumerated(EnumType.STRING)
    @Column(name ="account_type")
    private AccountType accountType;
    
    @Column(name ="balance_date")
    private String balanceDate;
    
    private String currency;
    
    @Column(name ="available_balance")
    private String availableBalance;
    
//    @OneToMany(targetEntity=AccountTransaction.class, mappedBy="accountSummary",
//            cascade= CascadeType.ALL, fetch = FetchType.EAGER)
//    List<AccountTransaction> accountTransactions;
	
	  
}
