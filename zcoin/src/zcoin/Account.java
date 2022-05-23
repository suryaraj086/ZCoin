package zcoin;

public class Account {
	private long hid;
	private int zCoinBalance;
	private int currency;
	private long zid;

	public long getHid() {
		return hid;
	}

	public void setHid(long hid) {
		this.hid = hid;
	}

	public int getzCoinBalance() {
		return zCoinBalance;
	}

	public void setzCoinBalance(int zCoinBalance) {
		this.zCoinBalance = zCoinBalance;
	}

	public int getCurrency() {
		return currency;
	}

	public void setCurrency(int currency) {
		this.currency = currency;
	}

	public long getZid() {
		return zid;
	}

	public void setZid(long id) {
		this.zid = id;
	}

	@Override
	public String toString() {
		return "Account [hid=" + hid + ", zCoinBalance=" + zCoinBalance + ", currency=" + currency + ", zid=" + zid
				+ "]";
	}

}
