package dao;

import bean.Account;

public interface AccountDAO{
    Account getAccountById(int STUID);
    Account getAccountByNameAndAge(String STUNAME, int STUAGE);
}
