package src;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Account extends Main {
	private String name;
	private Long accountNum;
	private double balance = 0;
	private double withdrawBalnce = 0;
	private double depositBalance = 0;
	private double time;
	double rate = 0.05;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	/* ------------------------------------------- */
	public void setAccountNum(Long accountNum) {
		this.accountNum = accountNum;
	}
	
	public Long getAccountNum() {
		return accountNum;
	}
	/* ------------------------------------------- */
	public void setDepositBalance(double depositBalance) {
		this.depositBalance = depositBalance;
	}
	
	public double getDepositBalance() {
		return depositBalance;
	}
	/* ------------------------------------------- */
	public void setWithdrawBalnce(double withdrawBalnce) {
		this.withdrawBalnce = withdrawBalnce;
	}
	
	public double getWithdrawBalnce() {
		return withdrawBalnce;
	}
	/* ------------------------------------------- */
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public double getBalance() {
		return balance;
	}
	/* ------------------------------------------- */
	public void setTime(double time) {
		this.time = time;
	}
	
	public double getTime() {
		return time;
	}
	
	public static void withdrawl() {
		boolean loop2 = true;
		while (loop2) {
			System.out.println("Enter the withdrawl amount:");
			try {
				double withdrawlAmount = Main.hold.nextDouble();
				newAccount.setWithdrawBalnce(withdrawlAmount);
				if (withdrawlAmount > newAccount.getBalance()) {
					System.out.println("Insafficent funds");
					break;
				}
				double balnce1 = newAccount.getBalance() - newAccount.getWithdrawBalnce();
				newAccount.setBalance(balnce1);
				newAccount.setDepositBalance(0);
				try {
					LocalDateTime now = LocalDateTime.now();
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
					String formatDateTime = now.format(formatter);
					File file = new File("Accounts.txt");
					FileWriter writer = new FileWriter(file, true);
					writer.write("\nWithdrawl Amount Updated\n");
					writer.write(formatDateTime);
					writer.write(
							"\n ========================================================================================================== \n");
					writer.write(String.format("%20s %20s %20s %20s %20s\n", "Acount Name", "Account Number",
							"Balance", "Deposit Amount", "Withdraw Amount"));
					writer.write(String.format("%20s %20s %20s %20s %20s\n", newAccount.getName(),
							newAccount.getAccountNum(), newAccount.getBalance(), newAccount.getDepositBalance(),
							"-" + newAccount.getWithdrawBalnce()));
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println("Do you want to deposite more money?");
				String yN = hold.next();
				if (yN.equalsIgnoreCase("y") || yN.equalsIgnoreCase("yes")) {

				} else if (yN.equalsIgnoreCase("n") || yN.equalsIgnoreCase("no")) {
					loop2 = false;
				} else {
					System.out.println("Invalid Input!");
				}

			} catch (Exception e) {
				System.out.println("Invalid Input!");
			}
		}
	}
	
	public static void deposite() {
		boolean loop1 = true;
		while (loop1) {
			System.out.println("Enter the amount");
			String depositeAmountEntry = hold.next();
			try {
				double depositeAmount = Double.parseDouble(depositeAmountEntry);
				newAccount.setDepositBalance(depositeAmount);
				double Balance = (newAccount.getBalance() + depositeAmount);
				newAccount.setBalance(Balance);
				newAccount.setWithdrawBalnce(0);
			} catch (Exception e) {
				System.out.println("Invalid Input!");
			}
			try {
				LocalDateTime now = LocalDateTime.now();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
				String formatDateTime = now.format(formatter);
				File file = new File("Accounts.txt");
				FileWriter writer = new FileWriter(file, true);
				writer.write("\nDeposite Amount Updated\n");
				writer.write(formatDateTime);
				writer.write(
						"\n ========================================================================================================== \n");
				writer.write(String.format("%20s %20s %20s %20s %20s\n", "Acount Name", "Account Number",
						"Balance", "Deposit Amount", "Withdraw Amount"));
				writer.write(String.format("%20s %20s %20s %20s %20s\n", newAccount.getName(),
						newAccount.getAccountNum(), newAccount.getBalance(), newAccount.getDepositBalance(),
						"-" + newAccount.getWithdrawBalnce()));
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("Do you want to deposite more money?");
			String yN = hold.next();
			if (yN.equalsIgnoreCase("y") || yN.equalsIgnoreCase("yes")) {

			} else if (yN.equalsIgnoreCase("n") || yN.equalsIgnoreCase("no")) {
				loop1 = false;
			} else {
				System.out.println("Invalid Input");
			}
		}
	}
}
