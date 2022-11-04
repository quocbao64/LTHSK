package test;

import dao.Acount_dao;
import entity.Account;

public class Account_dao_test {
	public static void main(String[] args) throws Exception {
		Acount_dao acount_dao = new Acount_dao();
		
		Account account1 = new Account(1000,"son12", "12345");
//		System.out.println(acount_dao.addAccount(account1));
	}
}
