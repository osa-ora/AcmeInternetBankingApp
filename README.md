# AcmeInternetBankingApp
A Sample internet banking web application using simple Java Web Technologies

# Solution Components

  <img width="915" alt="Solution_Architecture" src="https://user-images.githubusercontent.com/18471537/72225660-0a761280-3599-11ea-843b-f5155f6674d0.png">

This web application uses 5 different micro-services, optionally you can connect via API Manager or directly to these services.
Three of these Micro-services already uses MySQL to persist and query data, while one services (BankingService) connect to ActiveMQ to send messages to one Queue and another service (ExchangeRateService) connect to Redis to cache some results.

These services are:

- UserAccountService : 
 repository: https://github.com/osa-ora/UserAccountService

- CustomerDataService :  
 repository: https://github.com/osa-ora/CustomerDataService

- BankingService :  
 repository: https://github.com/osa-ora/BankingService

- LoanValService : 
 repository: https://github.com/osa-ora/LoanValService

- ExchangeRateService :  
 repository: https://github.com/osa-ora/ExchangeRateService

- Note: the dotted services is not implemented but a typical internet banking microservices application should implement them.

# It is a Netbeans based project that uses Maven to build it simply run: 

- mvn clean install compile package

- Then deploy the war file from the target folder into either Tomcat or Glassfish or any other web container such as JBoss, WebLogic or Websphere

# The service do expect 5 different environment variables to connect to different backend microservices:

- USER_ACCOUNT_SERVICE the default value is http ://localhost:8083/api/v1/accounts/login 
- CUSTOMER_DATA_SERVICE the default value is http ://localhost:8085/api/v1/customers/
- BANKING_SERVICE the default value is http ://localhost:8086/api/v1/bankaccounts/
- LOAN_SERVICE the default value is http ://localhost:8000/LoanService/V1/ 
- EXCHANGE_RATE_SERVICE the default value is http ://localhost:8881/api/v1/exchange/

# Web Interface

This is how it looks like:

![InternetBanking](https://user-images.githubusercontent.com/18471537/71548532-c7287b00-29c0-11ea-9e4d-71315af2bda0.jpeg)

And as you can see every widget get the data from different source i.e. micro-services and if one service is down, only the related widget get affected while the rest will resume working normally.
