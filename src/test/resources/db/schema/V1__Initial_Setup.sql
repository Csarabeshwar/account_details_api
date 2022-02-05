create EXTENSION IF NOT EXISTS "uuid-ossp";


create table account_summary(

    account_id varchar NOT NULL  ,
    
    account_number varchar  NOT NULL , 
    
    account_name varchar NOT NULL, 
    
    account_type varchar NOT NULL,
    
    balance_date timestamp NOT NULL,
    
    currency varchar NOT NULL,
    
    available_balance varchar NOT NULL,
    
    CONSTRAINT summary_pkey PRIMARY KEY (account_id)
	
);


create table account_transaction_details(

	id varchar NOT NULL  ,
	
    account_number varchar  NOT NULL , 
    
    account_name varchar NOT NULL, 
    
    currency varchar NOT NULL,
    
    value_date timestamp NOT NULL,
    
    debit_amount varchar NOT NULL,
    
    credit_amount varchar NOT NULL,
    
    debit_credit_indicator varchar NOT NULL,
    
    transaction_narrative varchar,
    
    CONSTRAINT transaction_pkey PRIMARY KEY (id)
    
);


CREATE UNIQUE INDEX accountId_idx ON account_summary USING btree (account_id);
CREATE UNIQUE INDEX txn_id_idx ON account_transaction_details USING btree (id);
