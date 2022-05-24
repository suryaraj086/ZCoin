package zcoin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Zcoin {
	Map<String, User> login = new HashMap<>();
	List<User> signup = new ArrayList<>();
	Map<String, Account> account = new HashMap<>();
	Map<String, List<TransactionHistory>> transaction = new HashMap<>();
	Map<Integer, String> connect = new HashMap<>();
	int zId = 0;
	int exchange = 2;

	public Zcoin() {
		User user = new User();
		user.setEmailId("s@123.com");
		user.setPassword("123");
		user.setAdmin(true);
		login.put("s@123.com", user);
		User user1 = new User();
		user1.setEmailId("s@12.com");
		user1.setPassword("123");
		user1.setAdmin(false);
		login.put("s@12.com", user1);
		Account acc = ObjectSetter.accountSetter(1234, 100, 100, 0);
		account.put(user1.getEmailId(), acc);
	}

	public String getLogin(String email, String password) throws Exception {
		User data = login.get(email);
		nullChecker(data);
		if (data.getPassword().equals(password) && data.isAdmin()) {
			return "Admin";
		} else if (data.getPassword().equals(password) && !data.isAdmin()) {
			return "Customer";
		}
		return "Invalid user";
	}

	public void userSignup(User data) {
		signup.add(data);
	}

	public void nullChecker(Object inp) throws Exception {
		if (inp == null) {
			throw new Exception("Error");
		}
	}

	public void allowUser(int val) throws Exception {
		User data = signup.get(val - 1);
		nullChecker(data);
		Account acc = ObjectSetter.accountSetter(data.gethId(), 100, data.getIntialCurrency(), zId++);
		login.put(data.getEmailId(), data);
		account.put(data.getEmailId(), acc);
	}

	public String listUser() {
		String output = "";
		int length = signup.size();
		for (int i = 0; i < length; i++) {
			output += i + 1 + " " + signup.get(i).toString();
		}
		return output;
	}

	public String listTransaction() {
		String out = "";
		for (List<TransactionHistory> arr : transaction.values()) {
			int size = arr.size();
			for (int i = 0; i < size; i++) {
				out += arr.get(i);
			}
		}
		return out;
	}

	public void zCoinToCurrency(String email, int amount, TransactionHistory transfer) throws Exception {
		Account acc = account.get(email);
		int balance = acc.getzCoinBalance();
		balanceChecker(balance, amount);
		balance -= amount;
		int deposit = amount / exchange;
		double value = deposit * 0.15;
		int rc = acc.getCurrency() + (int) (deposit - value);
		acc.setCurrency(rc);
		acc.setzCoinBalance(balance);
		List<TransactionHistory> temp = transaction.get(email);
		if (temp == null) {
			temp = new ArrayList<>();
		}
		temp.add(transfer);
		transaction.put(email, temp);
	}

	public void balanceChecker(int balance, int amount) throws Exception {
		if (amount > balance) {
			throw new Exception("insufficient balance");
		}
	}

	public void currencyToZCoin(String email, int amount, TransactionHistory transfer) throws Exception {
		Account acc = account.get(email);
		int balance = acc.getCurrency();
		balanceChecker(balance, amount);
		balance += exchange * amount;
		int rc = acc.getCurrency() - amount;
		acc.setCurrency(rc);
		acc.setzCoinBalance(balance);
		List<TransactionHistory> temp = transaction.get(email);
		if (temp == null) {
			temp = new ArrayList<>();
		}
		temp.add(transfer);
		transaction.put(email, temp);
	}

	public String userDetails(String email) {
		String output = "";
		for (User temp : login.values()) {
			output += temp.toString();
		}
		return output;
	}

	public String listUserHistory(String email) {
		List<TransactionHistory> data = transaction.get(email);
		String out = "";
		System.out.println(data);
		for (int i = 0; i < data.size(); i++) {
			out += data.get(i).toString();
		}
		return out;
	}

	public void changePassword(String emailId, String password) throws Exception {
		User temp = login.get(emailId);
		nullChecker(temp);
		temp.setPassword(password);
	}

	public void zCoinUserTransaction(String email, int zid, int amount) throws Exception {
		String toEmail = connect.get(zid);
		Account fromUser = account.get(email);
		Account toUser = account.get(toEmail);
		int balance = fromUser.getzCoinBalance();
		balanceChecker(balance, amount);
		balance -= amount;
		toUser.setzCoinBalance(toUser.getzCoinBalance() + amount);
	}

	public void checkPassword(String password, String password1, User data) throws Exception {
		if (password.equals(password1)) {
			if (password.contains(data.getFullName()) || password.contains(data.getEmailId())
					|| password.contains("" + data.getMobileNumber()) || password.length() < 8) {
				throw new Exception("Invalid password");
			}
			data.setPassword(password);
			return;
		}
		throw new Exception("Invalid password");
	}
}
