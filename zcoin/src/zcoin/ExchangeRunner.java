package zcoin;

import java.util.Scanner;

public class ExchangeRunner {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Zcoin obj = new Zcoin();
		boolean bool = true;
		while (bool) {
			System.out.println("1.Create new account\n2.Login");
			int val = scan.nextInt();
			switch (val) {
			case 1:
				scan.nextLine();
				System.out.println("Enter full name");
				String name = scan.nextLine();
				System.out.println("Enter email id");
				String email = scan.nextLine();
				System.out.println(
						"1.password should be 8 letters 2. password should not contain name or email \nEnter the password");
				String password = scan.nextLine();
				System.out.println("Confirm the password");
				String password1 = scan.nextLine();
				System.out.println("Enter the HID");
				long hid = scan.nextLong();
				System.out.println("Enter the mobile number");
				long mobile = scan.nextLong();
				User user = null;
				try {
					user = ObjectSetter.userSetter(name, email, mobile, password1, 100, false, hid);
					obj.checkPassword(password, password1, user);
					obj.userSignup(user);
					System.out.println("Created successfully");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			case 2:
				scan.nextLine();
				System.out.println("Enter email id");
				String emailid = scan.nextLine();
				System.out.println("Confirm the password");
				String pass = scan.nextLine();
				String role = null;
				try {
					role = obj.getLogin(emailid, pass);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				switch (role) {
				case "Admin":
					System.out.println("1.Pending approval\n2.Transaction History");
					int num = scan.nextInt();
					switch (num) {
					case 1:
						System.out.println(obj.listUser());
						int approve = scan.nextInt();
						if (approve == 0) {
							continue;
						}
						try {
							obj.allowUser(approve);
						} catch (Exception e1) {
							System.out.println(e1.getMessage());
							continue;
						}
						System.out.println("Approved");
						break;
					case 2:
						System.out.println(obj.listTransaction());
						break;
					default:
						break;
					}
					break;
				case "Customer":
					System.out.println(
							"1.Show details\n2.Transaction History\n3.RC Transaction\n4.Zcoin Transaction\n5.Transfer to another zid");
					int num1 = scan.nextInt();
					switch (num1) {
					case 1:
						System.out.println(obj.userDetails(emailid));
						break;
					case 2:
						System.out.println(obj.listUserHistory(emailid));
						break;
					case 3:
						System.out.println("Enter amount");
						int amount1 = scan.nextInt();
						TransactionHistory History = ObjectSetter.transactionHistory(System.currentTimeMillis(),
								amount1, "Rc to zcoin transaction");

						try {
							obj.currencyToZCoin(emailid, amount1, History);
						} catch (Exception e) {
							System.out.println(e.getMessage());
							continue;
						}
						System.out.println("Transaction successfull");
						break;
					case 4:
						System.out.println("Enter amount");
						int amount2 = scan.nextInt();
						TransactionHistory traHistory = ObjectSetter.transactionHistory(System.currentTimeMillis(),
								amount2, "Zcoin to Rc transaction");

						try {
							obj.zCoinToCurrency(emailid, amount2, traHistory);
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
						System.out.println("Transaction successful");
						break;

					default:
						break;
					}
					break;

				default:
					System.out.println("Not found");
					break;
				}
				break;
			default:
				bool = false;
				break;
			}
		}
		scan.close();
	}

}
