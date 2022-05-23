package zcoin;

public class ObjectSetter {
	public static User userSetter(String name, String email, long mobile, String password, int currency, boolean role,
			long hId) throws Exception {
		nullChecker(name, email, password);
		User user = new User();
		user.setAdmin(role);
		user.setEmailId(email);
		user.setFullName(name);
		user.sethId(hId);
		user.setMobileNumber(mobile);
		user.setPassword(password);
		user.setIntialCurrency(currency);
		return user;
	}

	public static Account accountSetter(long zid, int zCoinBalance, int currency, int hid) {
		Account acc = new Account();
		acc.setCurrency(currency);
		acc.setHid(hid);
		acc.setzCoinBalance(zCoinBalance);
		acc.setZid(zid);
		return acc;
	}

	public static TransactionHistory transactionHistory(long time, int amount, String transferString) {
		TransactionHistory transfer = new TransactionHistory();
		transfer.setAmount(amount);
		transfer.setTime(time);
		transfer.setTransaction(transferString);
		return transfer;
	}

	public static void nullChecker(Object inp, Object inp1, Object inp2) throws Exception {
		if (inp == null || inp1 == null || inp2 == null) {
			throw new Exception("Error");
		}
	}
}
