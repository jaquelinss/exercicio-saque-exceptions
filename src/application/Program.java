package application;

import models.entities.Account;
import models.exceptions.DomainException;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Enter account data");
            System.out.print("Account number: ");
            int number = sc.nextInt();
            sc.nextLine();
            System.out.print("Holder name: ");
            String name = sc.nextLine();
            System.out.print("Initial balance: ");
            double balance = sc.nextDouble();
            System.out.print("Withdraw limit: ");
            double withdrawLimit = sc.nextDouble();

            Account account = new Account(number, name, balance, withdrawLimit);

            System.out.println(account);
            System.out.println();
            System.out.print ("Enter amount for withdraw: ");
            double amount = sc.nextDouble();

            account.withdraw(amount);
            System.out.println("Updated data");
            System.out.print(account);


        } catch (DomainException e){
            System.out.println("Error: " + e.getMessage());

        }

        catch (RuntimeException e) {
            System.out.println("Unexpected error");
        }
        sc.close();
    }

}
