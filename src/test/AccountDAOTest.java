package test;

import bean.Account;
import dao.AccountDAO;
import dao.impl.AccountDAOOracleImpl;

public class AccountDAOTest {
    public static void main(String[] args) {
        // 构建一个DAO对象
        AccountDAO dao = new AccountDAOOracleImpl();
        Account account = dao.getAccountById(1);
        System.out.println(account);
        System.out.println(dao.getAccountByNameAndAge("小明",23));
    }
    
    
}
