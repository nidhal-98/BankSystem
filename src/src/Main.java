package src;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
	static Scanner hold = new Scanner(System.in);
	static SavingsAccount newAccount = new SavingsAccount();
	
	public static void main(String[] args) throws IOException {
		
		while (true) {
			System.out.println("[1] New Account");
			System.out.println("[2] Deposit");
			System.out.println("[3] Withdraw");
			System.out.println("[4] Interest");
			System.out.println("[5] Limeted");
			String option = hold.next();

			switch (option) {
			case "1":
				System.out.println("Enter Acount Name: ");
				String userName = hold.next();
				newAccount.setName(userName);
				System.out.println("Enter Account Number");
				String accNumEntry = hold.next();
				try {
					Long accNum = Long.parseLong(accNumEntry);
					newAccount.setAccountNum(accNum);

				} catch (Exception e) {
					System.out.println("Invalid Input!");
					break;
				}
				try {
					LocalDateTime now = LocalDateTime.now();
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
					String formatDateTime = now.format(formatter);
					File file = new File("Accounts.txt");
					FileWriter writer = new FileWriter(file, true);
					writer.write("\nAccount Name & Number Updated\n");
					writer.write(formatDateTime);
					writer.write(
							"\n ========================================================================================================== \n");
					writer.write(String.format("%20s %20s %20s %20s %20s\n", "Acount Name", "Account Number", "Balance",
							"Deposit Amount", "Withdraw Amount"));
					writer.write(String.format("%20s %20s %20s %20s %20s\n", newAccount.getName(),
							newAccount.getAccountNum(), newAccount.getBalance(), newAccount.getDepositBalance(),
							"-" + newAccount.getWithdrawBalnce()));
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

				break;

			case "2":
				SavingsAccount.deposite();
				break;

			case "3":
				SavingsAccount.withdrawl();
				break;

			case "4":
				if( newAccount.getBalance() == 0) {
					System.out.println("You can not do it");
					break;
				}
				System.out.println("Enter Monthes:");
				try {
					String monthEntry = hold.next();
					double month = Double.parseDouble(monthEntry);
					newAccount.setTime(month);
					double interest  = newAccount.getBalance() * newAccount.rate * newAccount.getTime();
					newAccount.setInterest(interest);
					System.out.println("The interest: " + newAccount.getInterest());
					
				} catch (Exception e) {
					System.out.println("Invalid Input!");
				}
				break;

			case "5":
				CheckingAccount.withdrawl();
				break;
			default:
				System.out.println("Invalid Input!");
				break;
			}
		}

	}
}
