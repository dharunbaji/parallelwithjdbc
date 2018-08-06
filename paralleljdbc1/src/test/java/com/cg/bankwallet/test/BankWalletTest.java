package com.cg.bankwallet.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import com.cg.beans.Account;
import com.cg.exception.WalletException;
import com.cg.service.ServiceImpl;
import com.cg.service.IService;



public class BankWalletTest {


	private IService service;

	@Before

	public void init() {
		service = new ServiceImpl();
	}

  //Test 1
	@Test
	public void testCreateAccountForMobile() {
		Account ac = new Account();
		ac.setMobileno("1234897565");
		ac.setName("Marria");
		ac.setEmail("marria@cg.com");
		ac.setBalance(200.0);
		try {
			service.createAccount(ac);
		} catch (WalletException e) {
			assertEquals("Mobile number should contain 10 digits", e.getMessage());
		}
	}
	
	//Test 2
	@Test
	public void testCreateAccountForName() {
		Account ac = new Account();
		ac.setMobileno("8185800166");
		ac.setName("Miya12");
		ac.setEmail("miya@cg.com");
		ac.setBalance(500.0);
		try {
			service.createAccount(ac);
		} catch (WalletException e) {
			assertEquals("Name should start with capital letter and should contain only Alphabets", e.getMessage());
		}
	}
	
	//Test 3
	@Test
	public void testCreateAccountForNameIsEmpty() {
		Account ac = new Account();
		ac.setMobileno("8185800167");
		ac.setName("");
		ac.setEmail("Keira@cg.com");
		ac.setBalance(200.0);
		try {
			service.createAccount(ac);
		} catch (WalletException e) {
			assertEquals("Name can't be empty", e.getMessage());
		}
	}	
//	//Test 4
//	@Test
//	public void testCreateAccountForEmailId() {
//		Account ac = new Account();
//		ac.setMobileno("9948032465");
//		ac.setName("Benji");
//		ac.setEmail("benji@cg.com");
//		ac.setBalance(200.0);
//		try {
//			service.createAccount(ac);
//		} catch (WalletException e) {
//			assertEquals("Enter valid emailid", e.getMessage());
//		}
//	}
	//Test5
	@Test
	public void testCreateAccount() {
		Account ac = new Account();
		ac.setMobileno("8185800165");
		ac.setName("Judy");
		ac.setEmail("judy@gmail.com");
		ac.setBalance(200.0);
			try {
				String s=service.createAccount(ac);
				assertNotNull(s);
			} catch (WalletException e) {
						

			}
	}	
	//Test 6
	@Test
	public void testShowBalanceForMobileNo() {
		
		try {
			service.showBalance("818580");
		} catch (WalletException e) {
			assertEquals("Mobile number should contain 10 digits",e.getMessage());
		}
	}	

	//Test 7
	@Test
	public void testShowBalanceForMobileNoDoesNotExist() {
		
		try {
			service.showBalance("818580166");
		} catch (WalletException e) {			
			assertEquals("Mobile number should contain 10 digits",e.getMessage());
		}
	}
	//Test 8
//	@Test
//	public void testShowBalanceForName() {
//		Account ac=new Account();
//		ac.setMobileno("8185800165");
//		try {
//			service.showBalance(ac.getMobileno());
//			assertNotEquals("Miya", ac.getName());
//		} catch (WalletException e) {			
//			assertEquals("The mobile number does not exist",e.getMessage());
//		}
//	}	
	//Test 9
	@Test
	public void testDepositForMobileNo() {
		Account ac=new Account();
		ac.setMobileno("818580016");
		try {
			service.deposit(ac.getMobileno(), 230);
		} catch (WalletException e) {			
			assertEquals("Mobile number should contain 10 digits",e.getMessage());
		}
	}
	/*//Test 10
	@Test
	public void testDepositForMobileNoDoesNotExist() {
		Account ac=new Account();
		ac.setMobileNo("7995522030");
		try {
			service.deposit(ac.getMobileNo(), 230);
		} catch (WalletException e) {
			assertEquals("Mobile Number should contain 10 digits",e.getMessage());
		}
	}*/
	//Test 11
	@Test
	public void testDepositForDepositAmt1() {
		Account ac=new Account();
		ac.setMobileno("8185800166");
		try {
			service.deposit(ac.getMobileno(), -230);
		} catch (WalletException e) {
			assertEquals("Deposit amount must be greater than zero",e.getMessage());
		}
	}	
	//Test 12
	@Test
	public void testDeposit() {
		Account ac=new Account();
		ac.setMobileno("8185800166");
		try {
			Account ac1=service.deposit(ac.getMobileno(), 230);
			assertNotNull(ac1);
		} catch (WalletException e) {
			System.out.println(e.getMessage());
			}
	}	
	//Test 13
	@Test
	public void testWithDrawForMobileNo() {
		Account ac=new Account();
		ac.setMobileno("818580016");
		try {
			service.withdraw(ac.getMobileno(), 230);
		} catch (WalletException e) {
			assertEquals("Mobile number should contain 10 digits",e.getMessage());
		}
	}
	//Test 14
	@Test
	public void testWithdrawForMobileNoDoesNotExist() {
		Account ac=new Account();
		ac.setMobileno("8185800166");
		try {
			service.withdraw(ac.getMobileno(), 230);
		} catch (WalletException e) {
			assertNotEquals("The mobile number does not exist",e.getMessage());
		}
	}
	//Test 15
	@Test
	public void testWithdrawForMobileNoDoesNotExist1() {
		Account ac=new Account();
		ac.setMobileno("8185800167");
		try {
			service.withdraw(ac.getMobileno(), 230);
		} catch (WalletException e) {
			assertNotEquals("The mobile number does not exist",e.getMessage());
		}
	}
	//Test 16
	@Test
	public void testWithdrawForMobileNoDoesNotExist2() {
		Account ac=new Account();
		ac.setMobileno("8185800165");
		try {
			service.withdraw(ac.getMobileno(), 230);
		} catch (WalletException e) {
			assertNotEquals("The mobile number does not exist",e.getMessage());
		}
	}
	//Test 17
	@Test
	public void testWithdrawForMobileNoDoesNotExist3() {
		Account ac=new Account();
		ac.setMobileno("9948032465");
		try {
			service.withdraw(ac.getMobileno(), 230);
		} catch (WalletException e) {
			assertNotEquals("The mobile number does not exist",e.getMessage());
		}
	}
	//Test 18
	@Test
	public void testWithdrawForAmt() {
		Account ac=new Account();
		ac.setMobileno("8185800166");
		try {
			service.withdraw(ac.getMobileno(), -230);
		} catch (WalletException e) {
			assertEquals("The amount to be withdrawn should be greater than available balance and greater than zero",e.getMessage());
		}
	}
	//Test 19
	@Test
	public void testWithdrawForAmt1() {
		Account ac=new Account();
		ac.setMobileno("9948032465");
		try {
			service.withdraw(ac.getMobileno(), -230);
		} catch (WalletException e) {
			assertEquals("The amount to be withdrawn should be greater than available balance and greater than zero",e.getMessage());
		}
	}
	//Test 20
	@Test
	public void testWithdrawForAmt2() {
		Account ac=new Account();
		ac.setMobileno("8185800165");
		try {
			service.withdraw(ac.getMobileno(), -230);
		} catch (WalletException e) {
			assertEquals("The amount to be withdrawn should be greater than available balance and greater than zero",e.getMessage());
		}
	}	
	//Test 21
	@Test
	public void testWithdrawForAmt3() {
		Account ac=new Account();
		ac.setMobileno("8185800167");
		try {
			service.withdraw(ac.getMobileno(), -230);
		} catch (WalletException e) {
			assertEquals("The amount to be withdrawn should be greater than available balance and greater than zero",e.getMessage());
		}
	}
	//Test 22
	@Test
	public void testFundTransferForMobileNo() {
		Account ac=new Account();
		Account ac2=new Account();
		ac.setMobileno("818580");
		ac2.setMobileno("1234");
		try {
			service.fundTransfer(ac.getMobileno(),ac2.getMobileno(), 230);
		} catch (WalletException e) {
			assertEquals("Mobile number should contain 10 digits",e.getMessage());
		}
	}
	//Test 23
	@Test

	public void testFundTransferForMobileNoDoesNotExist() {
		Account ac=new Account();
		Account ac2=new Account();
		ac.setMobileno("8185800167");
		ac2.setMobileno("8185800165");
		try {
			service.fundTransfer(ac.getMobileno(), ac2.getMobileno(),  230);
		} catch (WalletException e) {
			assertNotEquals("The mobile number does not exist",e.getMessage());
		}
	}
	//Test 24
	@Test
	public void testFundTransferForAmt() {
		Account ac=new Account();
		Account ac2=new Account();
		ac.setMobileno("8185800166");
		ac2.setMobileno("8185800165");
		try {
			service.fundTransfer(ac.getMobileno(), ac2.getMobileno(),  -230);
		} catch (WalletException e) {
		assertEquals("The amount to be withdrawn should be greater than available balance and greater than zero",e.getMessage());
		}
	}
	//Test 25
	@Test
	public void testFundTransfer() {
		Account ac=new Account();
		Account ac2=new Account();
		ac.setMobileno("8185800167");
		ac2.setMobileno("9948032465");
		try {
			assertTrue(service.fundTransfer(ac.getMobileno(), ac2.getMobileno(),  230));
		} catch (WalletException e) {
			System.out.println(e.getMessage());
		}
	}
	//Test 26
	@Test
	public void testPrinttransactionDetails() {
		Account ac=new Account();
		ac.setMobileno("9948032465");
		try {
			Account acc=service.printTransactionDetails(ac.getMobileno());
			assertNotNull(acc);
		} catch (WalletException e) {
			System.out.println(e.getMessage());
		}
	}
	//Test 27
	@Test
	public void testPrinttransactionDetails1() {
		Account ac=new Account();
		ac.setMobileno("8185800166");
		try {
			Account acc=service.printTransactionDetails(ac.getMobileno());
			assertNotNull(acc);
		} catch (WalletException e) {
			System.out.println(e.getMessage());
		}
	}
	//Test 28
	@Test
	public void testPrinttransactionDetails2() {
		Account ac=new Account();
		ac.setMobileno("8185800165");
		try {
			Account acc=service.printTransactionDetails(ac.getMobileno());
			assertNotNull(acc);
		} catch (WalletException e) {
			System.out.println(e.getMessage());
		}
	}
	//Test 29
	@Test
	public void testPrinttransactionDetails3() {
		Account ac=new Account();
		ac.setMobileno("8185800167");
		try {
			Account acc=service.printTransactionDetails(ac.getMobileno());
			assertNotNull(acc);
		} catch (WalletException e) {
			System.out.println(e.getMessage());

		}
	}

}
