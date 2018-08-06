package com.cg.service;



import java.time.LocalDateTime;

import com.cg.beans.Account;
import com.cg.dao.IDao;
import com.cg.dao.DaoImpl;
import com.cg.exception.WalletException;

public class ServiceImpl implements IService {
	IDao dao = new DaoImpl();

	public String createAccount(Account acc) throws WalletException {

		if (!acc.getMobileno().matches("\\d{10}")) {
			throw new WalletException("Mobile number should contain 10 digits");
		}
		if (acc.getName().isEmpty() || acc.getName() == null) {
			throw new WalletException("Name cannot be empty");
		} else {
			if (!acc.getName().matches("[A-Z][A-Za-z]{3,}")) {
				throw new WalletException(
						"Name should start with capital letter and should contain only alphabets");
			}
		}
		if (acc.getBalance() < 0) {
			throw new WalletException("Balance should be greater than zero");
		}
		if (!acc.getEmail().matches("[a-z]+@[a-z]+\\.com")) {
			throw new WalletException("Enter valid emailid");
		}

		return dao.createAccount(acc);
	}

	public double showBalance(String mobileNo) throws WalletException {
		if (!mobileNo.matches("\\d{10}")) {
			throw new WalletException("Mobile number should contain 10 digits");
		}
		return dao.showBalance(mobileNo);
	}

	public Account deposit(String mobileNo, double depositAmt)
			throws WalletException {
		if (!mobileNo.matches("\\d{10}")) {
			throw new WalletException("Mobile number should contain 10 digits");
		}
	
		if (depositAmt <= 0) {
			throw new WalletException(
					"Deposit amount must be greater than zero");
		}
		
		return dao.deposit(mobileNo,depositAmt);
		 
	}

	public Account withdraw(String mobileNo, double withdrawAmt)
			throws WalletException {
		if (!mobileNo.matches("\\d{10}")) {
			throw new WalletException("Mobile number should contain 10 digits");
		}
		
		if ( withdrawAmt <= 0) {
			throw new WalletException(
					"The amount to be withdrawn should be greater than available balance and greater than zero");
		}
	
		Account acc1 = dao.withdraw(mobileNo,withdrawAmt);
		return acc1;
	}

	public boolean fundTransfer(String sourceMobileNo, String destMobileNo,
			double transferAmt) throws WalletException {
		if (!sourceMobileNo.matches("\\d{10}")) {
			throw new WalletException("Mobile number should contain 10 digits");
		}
		if (!destMobileNo.matches("\\d{10}")) {
			throw new WalletException("Mobile number should contain 10 digits");
		}
		IService service = new ServiceImpl();
		Account acc1 = service.withdraw(sourceMobileNo, transferAmt);
		Account d2 = service.deposit(destMobileNo, transferAmt);
		return true;
	}

	public Account printTransactionDetails(String mobileNo)
			throws WalletException {
		return dao.printTransactionDetails(mobileNo);

	}

}
