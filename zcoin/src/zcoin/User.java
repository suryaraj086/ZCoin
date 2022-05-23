package zcoin;

public class User {
	private String fullName;
	private String emailId;
	private long mobileNumber;
	private long hId;
	private String password;
	private boolean admin = false;
	private int intialCurrency;

	public int getIntialCurrency() {
		return intialCurrency;
	}

	public void setIntialCurrency(int intialCurrency) {
		this.intialCurrency = intialCurrency;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public long gethId() {
		return hId;
	}

	public void sethId(long hId) {
		this.hId = hId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "User [fullName=" + fullName + ", emailId=" + emailId + ", mobileNumber=" + mobileNumber + ", hId=" + hId
				+ ", password=" + password + ", admin=" + admin + "]";
	}

}
