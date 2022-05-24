package zcoin;

import java.util.Date;

public class TransactionHistory {

	private String transaction;
	private long time;
	private int amount;

	public String getTransaction() {
		return transaction;
	}

	public void setTransaction(String transaction) {
		this.transaction = transaction;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		Date d = new Date(time);
		return "TransactionHistory [transaction=" + transaction + ", time=" + d + ", amount=" + amount + "]";
	}

}
