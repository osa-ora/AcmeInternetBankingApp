/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package osa.ora.beans;

import java.util.Map;
import java.util.Optional;

/**
 *
 * @author ooransa
 */
public class Services {

    String userAccountService = "http://localhost:8083/api/v1/accounts/login";
        //"http://localhost:8083/AccountService/V1/accounts/";
    String userAccountServiceKey = "USER_ACCOUNT_SERVICE";
    String customerDataService = "http://localhost:8085/api/v1/customers/";
        //"http://localhost:8085/CustomersService/V1/customers/";
    String customerDataServiceKey = "CUSTOMER_DATA_SERVICE";
    String bankingService = "http://localhost:8086/api/v1/bankaccounts/";
        //"http://localhost:8086/BankAccountService/V1/bankaccounts/";
    String bankingServiceKey = "BANKING_SERVICE";
    String loanService = " http://localhost:8000/LoanService/V1/loan/";
        //http://localhost:8000/LoanService/V1/";
    String loanServiceKey = "LOAN_SERVICE";
    String exchangeRateService = "http://localhost:8881/api/v1/exchange/";
    String exchangeRateServiceKey = "EXCHANGE_RATE_SERVICE";
    private static Services services = new Services();

    private Services() {
    }

    public static Services getInstance() {
        return services;
    }

    public String getUserAccountService() {
        String value = System.getenv(userAccountServiceKey);
        System.out.println("for Key=" + userAccountServiceKey + " & Env=" + value);
        if (value == null) {
            return userAccountService;
        } else {
            return value;
        }
    }

    public String getCustomerDataService() {
        String value = System.getenv(customerDataServiceKey);
        if (value == null) {
            return customerDataService;
        } else {
            return value;
        }
    }

    public String getBankingService() {
        String value = System.getenv(bankingServiceKey);
        if (value == null) {
            return bankingService;
        } else {
            return value;
        }
    }

    public String getLoanServiceService() {
        String value = System.getenv(loanServiceKey);
        if (value == null) {
            return loanService;
        } else {
            return value;
        }
    }

    public String getExchangeRateService() {
        String value = System.getenv(exchangeRateServiceKey);
        if (value == null) {
            return exchangeRateService;
        } else {
            return value;
        }
    }
}
