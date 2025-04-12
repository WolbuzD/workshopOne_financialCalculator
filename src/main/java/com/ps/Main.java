package com.ps;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Financial Calculator App!");
        System.out.println("Please select a calculator:");
        System.out.println("1 - Mortgage Calculator");
        System.out.println("2 - Future Value Calculator");
        System.out.println("3 - Present Value of Annuity Calculator");

        System.out.print("Enter your choice (1, 2 or 3): ");
        int choice = scanner.nextInt();

        switch (choice){
            case 1:
                System.out.println("\n--- You Chose Mortgage Calculator ---");
                System.out.print("Enter the loan amount (principal): ");
                double principal = scanner.nextDouble();

                System.out.print("Enter the annual interest rate: ");
                double annualRate = scanner.nextDouble() / 100;

                System.out.print("Enter the loan term in years: ");
                int years = scanner.nextInt();

                double monthlyRate = annualRate / 12;
                int months = years * 12;

                double monthlyPayment = principal * (monthlyRate * Math.pow(1 + monthlyRate, months)) /
                        (Math.pow(1 + monthlyRate, months) - 1);
                double totalInterest = (monthlyPayment * months) - principal;

                System.out.printf("Monthly Payment: $%.2f\n", monthlyPayment);
                //Notes: I am adding "\n" to print whatever variable I want to display on a new line
                System.out.printf("Total Interest Paid: $%.2f\n", totalInterest);
                break;
            case 2:
            case 3:
            default:
        }



    }
}