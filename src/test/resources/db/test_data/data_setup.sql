insert into Account_Summary(ACCOUNT_ID,ACCOUNT_NUMBER, ACCOUNT_NAME, ACCOUNT_TYPE, BALANCE_DATE, CURRENCY, AVAILABLE_BALANCE) 
values(1,'585309209','SGSavings726', 'Savings' , '08/11/2018' , 'SGD', 84327.51);

insert into Account_Summary(ACCOUNT_ID,ACCOUNT_NUMBER, ACCOUNT_NAME, ACCOUNT_TYPE, BALANCE_DATE, CURRENCY, AVAILABLE_BALANCE) 
values(2,'791066619','AUSavings933', 'Savings' , '08/11/2018' , 'AUD', 88005.93);

insert into Account_Summary(ACCOUNT_ID,ACCOUNT_NUMBER, ACCOUNT_NAME, ACCOUNT_TYPE, BALANCE_DATE, CURRENCY, AVAILABLE_BALANCE) 
values(3,'321143048','AUCurrent433', 'Current' , '08/11/2018' , 'AUD', 38010.62);

insert into Account_Summary(ACCOUNT_ID,ACCOUNT_NUMBER, ACCOUNT_NAME, ACCOUNT_TYPE, BALANCE_DATE, CURRENCY, AVAILABLE_BALANCE) 
values(4,'347786244','SGCurrent166', 'Current' , '08/11/2018' , 'SGD', 60664.65);
	                
insert into Account_Summary(ACCOUNT_ID,ACCOUNT_NUMBER, ACCOUNT_NAME, ACCOUNT_TYPE, BALANCE_DATE, CURRENCY, AVAILABLE_BALANCE) 
values(5,'68016813','AUCurrent374', 'Current' , '08/11/2018' , 'AUD', 41387.32);

insert into Account_Summary(ACCOUNT_ID,ACCOUNT_NUMBER, ACCOUNT_NAME, ACCOUNT_TYPE, BALANCE_DATE, CURRENCY, AVAILABLE_BALANCE) 
values(6,'136056165','AUSavings938', 'Savings' , '08/11/2018' , 'AUD', 48928.50);

insert into Account_Summary(ACCOUNT_ID,ACCOUNT_NUMBER, ACCOUNT_NAME, ACCOUNT_TYPE, BALANCE_DATE, CURRENCY, AVAILABLE_BALANCE) 
values(7,'453963528','SGSavings842', 'Savings' , '08/1/12018' , 'SGD', 72117.23);

insert into Account_Summary(ACCOUNT_ID,ACCOUNT_NUMBER, ACCOUNT_NAME, ACCOUNT_TYPE, BALANCE_DATE, CURRENCY, AVAILABLE_BALANCE) 
values(8,'334666982','AUSavings253', 'Savings' , '08/11/2018' , 'SGD', 20522.65);

insert into Account_Summary(ACCOUNT_ID,ACCOUNT_NUMBER, ACCOUNT_NAME, ACCOUNT_TYPE, BALANCE_DATE, CURRENCY, AVAILABLE_BALANCE) 
values(9,'793949180','AUCurrent754', 'Current' , '08/11/2018' , 'SGD', 5906.30);

insert into Account_Summary(ACCOUNT_ID,ACCOUNT_NUMBER, ACCOUNT_NAME, ACCOUNT_TYPE, BALANCE_DATE, CURRENCY, AVAILABLE_BALANCE) 
values(10,'847257972','AUCurrent591', 'Current' , '08/11/2018' , 'SGD', 92561.30);
	                
--Account Transation---

insert into Account_Transaction_Details(id,ACCOUNT_NUMBER, ACCOUNT_NAME, VALUE_DATE , CURRENCY, DEBIT_AMOUNT , CREDIT_AMOUNT,DEBIT_CREDIT_INDICATOR , TRANSACTION_NARRATIVE) 
values(1,'847257972','AUCurrent591', '12/01/2012 00:00:00' , 'SGD', 8.33,0 ,'Debit', '');

insert into Account_Transaction_Details(id,ACCOUNT_NUMBER, ACCOUNT_NAME, VALUE_DATE , CURRENCY, DEBIT_AMOUNT , CREDIT_AMOUNT,DEBIT_CREDIT_INDICATOR , TRANSACTION_NARRATIVE) 
values(2,'847257972','AUSavings591', '04/01/2012' , 'AUD', 0, 83,'Credit', '');

insert into Account_Transaction_Details(id,ACCOUNT_NUMBER, ACCOUNT_NAME, VALUE_DATE , CURRENCY, DEBIT_AMOUNT , CREDIT_AMOUNT,DEBIT_CREDIT_INDICATOR , TRANSACTION_NARRATIVE) 
values(3,'334666982','AUSavings253', '12/12/2012' , 'SGD', 8100.33, 0,'Debit', '');

insert into Account_Transaction_Details(id,ACCOUNT_NUMBER, ACCOUNT_NAME, VALUE_DATE , CURRENCY, DEBIT_AMOUNT , CREDIT_AMOUNT,DEBIT_CREDIT_INDICATOR , TRANSACTION_NARRATIVE) 
values(4,'136056165','AUSaving938', '12/11/2012' , 'SGD', 158.33, 0,'Debit', '');

insert into Account_Transaction_Details(id,ACCOUNT_NUMBER, ACCOUNT_NAME, VALUE_DATE , CURRENCY, DEBIT_AMOUNT , CREDIT_AMOUNT,DEBIT_CREDIT_INDICATOR , TRANSACTION_NARRATIVE) 
values(5,'136056165','AUCurrent938', '12/09/2012' , 'SGD', 0, 963.33,'Credit', '');

insert into Account_Transaction_Details(id,ACCOUNT_NUMBER, ACCOUNT_NAME, VALUE_DATE , CURRENCY, DEBIT_AMOUNT , CREDIT_AMOUNT,DEBIT_CREDIT_INDICATOR , TRANSACTION_NARRATIVE) 
values(6,'585309209','AUCurrent591', '02/05/2014' , 'AUD',15.25,0 ,'Debit', '');

insert into Account_Transaction_Details(id,ACCOUNT_NUMBER, ACCOUNT_NAME, VALUE_DATE , CURRENCY, DEBIT_AMOUNT , CREDIT_AMOUNT,DEBIT_CREDIT_INDICATOR , TRANSACTION_NARRATIVE) 
values(7,'347786244','SGCurrent166', '09/12/2012' , 'SGD', 0, 8.33,'Credit', '');

insert into Account_Transaction_Details(id,ACCOUNT_NUMBER, ACCOUNT_NAME, VALUE_DATE , CURRENCY, DEBIT_AMOUNT , CREDIT_AMOUNT,DEBIT_CREDIT_INDICATOR , TRANSACTION_NARRATIVE) 
values(8,'347786244','SGSaving166', '01/01/2014' , 'AUD', 1000.00,0 ,'Debit', '');