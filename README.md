# Account Details API

## Microservice to retrieve account details and transaction

### API Background

The sample application being requested by the candidate to build the backend REST APIs
needed to support a web application to that allows a user to view accounts and
subsequently view transactions on any of the accounts they hold.

Required functionality:
* View account list
* View account transactions

---

## Solution Brief

The solution is implemented using SpringBoot with Gradle. Solution consists of:

* Account List/Details enquiry
* Account Transaction enquiry

In addition to above, the code has below features:

* DB can be started using `gradlew composeUp`
* Integrated DB Migration using Flyway
* Code has tests in 3 categories:
  * unit test for logic tests 
  * component test for Data Repos
  * integration test to validate end to end API calls using RestAssured
* Enabled actuator for health check

## Important Gradle Tasks

| Gradle Tasks | Description | Pre-requisite |
| ------------ | ----------- | ------------- |
| `gradlew composeUp` | Starts postgres container | |
| `gradlew bootRun`| Starts Application| `gradlew composeUp` ||


## Steps to get the code running

* Checkout the code from Github repository
* Go to the terminal under `/account_details`
* Execute `gradlew composeUp` to start Postgres DB
* To load sample data:
  * Go to `/account_details/src/test/resources/db/test_data` and execute the `data_setup.sql` script. This will
    load sample data into DB
* Execute `gradlew bootRun`

### Interface Specification

Swagger File having all the API Specification is defined in (/src/main/java/com/anz/account/details/api)

### Application Base URL

Base URL is exposed at 8090: **[Base URL](http://localhost:8090/account-details)**

### Endpoints Exposed

| Request Type | Endpoint | Description |
  | ------------ | -------- | ----------- |
| GET | `/actuator/health` | Gets the status of the service |
| GET | `/v1/accounts/details` | Returns all accounts and it's details from DB |
| POST | `/v1/accounts/{accountNumber}` | Returns account transaction details based on accountNumber |

### Assumptions

* This is an Internal facing API presumably implemented through an API or Kong Gateway
* I assumed accountDetails/AccountList and Account Transaction table to present already and are populated with data.
* Assumed that other application-sit, prod files are not required to be updated

### Enhancements

* Pagination needs to be implemented to protect the API from timing out as well as for consistent performance
* Header validation needs to be added
* Add additional test cases for better coverage and exceptions
* Use of accountId instead of accountNumber. 
* Database normalization in terms of relationship between table
* Enhance the accountTransaction details by implementing a post and use external accountId and map it to internal AccountId(considering it is for OPEN BANKING)
* Enhance the  accountTransaction details to accept more than one accountNumber.
