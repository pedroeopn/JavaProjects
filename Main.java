package application;

import entities.Account;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        Account acc;

        System.out.print("Enter account number: ");
        Integer number = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter account holder: ");
        String holder = sc.nextLine();
        System.out.print("Is there an initial deposit (y/n)? ");
        char choice = sc.next().charAt(0);

        if(choice == 'y'){
            System.out.print("Enter initial deposit value: ");
            Double amount = sc.nextDouble();
            acc = new Account(number, holder, amount);
        } else {
            acc = new Account(number, holder);
        }

        System.out.println("Account data:");
        System.out.println(acc);

        System.out.print("Enter a deposit value: ");
        Double amount = sc.nextDouble();
        acc.deposit(amount);
        System.out.println("Updated account data:");
        System.out.println(acc);

        System.out.print("Enter a withdraw value: ");
        Double withdraw = sc.nextDouble();
        acc.withdraw(withdraw);
        System.out.println("Updated account data:");
        System.out.println(acc);
    }
}
