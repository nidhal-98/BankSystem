package src;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CheckingAccount extends Account {
	
public static void withdrawl() {
		boolean loop2 = true;
		while (loop2) {
			System.out.println("Enter the withdrawl amount:");
			try {
				double withdrawlAmount = Main.hold.nextDouble();
				newAccount.setWithdrawBalnce(withdrawlAmount);
				if (withdrawlAmount > 50 || withdrawlAmount > newAccount.getBalance()) {
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
}
