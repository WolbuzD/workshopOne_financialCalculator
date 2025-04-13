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
                double annualInterestRate = scanner.nextDouble() / 100;

                System.out.print("Enter the loan term in years: ");
                int years = scanner.nextInt();

                double monthlyInterestRate = annualInterestRate / 12;
                int loanTermMonths = years * 12;

                double monthlyPayment = principal * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, loanTermMonths)) /
                        (Math.pow(1 + monthlyInterestRate, loanTermMonths) - 1);
                double totalInterest = (monthlyPayment * loanTermMonths) - principal;

                System.out.printf("Monthly Payment: $%.2f\n", monthlyPayment);
                //Notes: I am adding "\n" to print whatever variable I want to display on a new line
                System.out.printf("Total Interest Paid: $%.2f\n", totalInterest);

                //I want to add a Detailed summary of everything that happened:
                System.out.println("\n--- Calculation Summary ---");
                System.out.printf("Loan Amount: $%.2f\n", principal);
                System.out.printf("Interest Rate: %.3f%%\n", annualInterestRate);
                System.out.printf("Monthly Payment: $%.2f\n", monthlyPayment);
                System.out.printf("Total Interest Paid: $%.2f\n", totalInterest);
                break;
            case 2:
                System.out.println("\n--- Future Value Calculator ---");
                System.out.print("Enter the initial deposit: ");
                double initialDeposit = scanner.nextDouble();

                System.out.print("Enter the annual interest rate: ");
                double annualInterestRate_fvCal = scanner.nextDouble() / 100; //fv: stands for future value

                System.out.print("Enter the number of years: ");
                int investmentYears = scanner.nextInt();

                double futureValue = initialDeposit * Math.pow((1 + annualInterestRate_fvCal / 365), 365 * investmentYears);
                double totalInterestEarned = futureValue - initialDeposit;

                System.out.printf("Future Value: $%.2f\n", futureValue);
                System.out.printf("Total Interest Earned: $%.2f\n", totalInterestEarned);

                //See the Summary below
                System.out.println("\n--- Calculation Summary ---");
                System.out.printf("Initial Deposit: $%.2f\n", initialDeposit);
                System.out.printf("Interest Rate: %.3f%%\n", annualInterestRate_fvCal);
                System.out.printf("Future Value: $%.2f\n", futureValue);
                System.out.printf("Total Interest Earned: $%.2f\n", totalInterestEarned);
                break;
            case 3:
                System.out.println("\n--- Present Value of Annuity Calculator ---");
                System.out.print("Enter the monthly payout: ");
                double monthlyPayout = scanner.nextDouble();
                   //pv= present value
                System.out.print("Enter the annual interest rate: ");
                double annualInterestRate_pvaCal = scanner.nextDouble() / 100;

                System.out.print("Enter the number of years: ");
                int annuityYears = scanner.nextInt();

                double monthlyInterestRate_pvaCal = annualInterestRate_pvaCal / 12;
                int totalMonths = annuityYears * 12;

                double presentValue = monthlyPayout * (1 - Math.pow(1 + monthlyInterestRate_pvaCal, -totalMonths)) / monthlyInterestRate_pvaCal;

                System.out.printf("Present Value Needed Today: $%.2f\n", presentValue);

                //See the Summary bellow:
                System.out.println("\n--- Calculation Summary ---");
                System.out.printf("Monthly Payout: $%.2f\n", monthlyPayout);
                System.out.printf("Interest Rate: %.3f%%\n", annualInterestRate_pvaCal * 100);
                System.out.printf("Present Value Needed: $%.2f\n", presentValue);
                break;

            default:
                System.out.println("Invalid choice. Please run the program again.");
        }

        scanner.close();

    }
}