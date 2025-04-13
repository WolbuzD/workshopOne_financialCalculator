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
                double deposit = scanner.nextDouble();

                System.out.print("Enter the annual interest rate: ");
                double fvAnnualRate = scanner.nextDouble() / 100; //fv: stands for future value

                System.out.print("Enter the number of years: ");
                int fvYears = scanner.nextInt();

                double futureValue = deposit * Math.pow((1 + fvAnnualRate / 365), 365 * fvYears);
                double fvInterest = futureValue - deposit;

                System.out.printf("Future Value: $%.2f\n", futureValue);
                System.out.printf("Total Interest Earned: $%.2f\n", fvInterest);

                //See the Summary below
                System.out.println("\n--- Calculation Summary ---");
                System.out.printf("Initial Deposit: $%.2f\n", deposit);
                System.out.printf("Interest Rate: %.3f%%\n", fvAnnualRate);
                System.out.printf("Future Value: $%.2f\n", futureValue);
                System.out.printf("Total Interest Earned: $%.2f\n", fvInterest);
                break;
            case 3:
                System.out.println("\n--- Present Value of Annuity Calculator ---");
                System.out.print("Enter the monthly payout: ");
                double payout = scanner.nextDouble();
                   //pv= present value
                System.out.print("Enter the annual interest rate: ");
                double pvAnnualRate = scanner.nextDouble() / 100;

                System.out.print("Enter the number of years: ");
                int pvYears = scanner.nextInt();

                double pvMonthlyRate = pvAnnualRate / 12;
                int pvMonths = pvYears * 12;

                double presentValue = payout * (1 - Math.pow(1 + pvMonthlyRate, -pvMonths)) / pvMonthlyRate;

                System.out.printf("Present Value Needed Today: $%.2f\n", presentValue);

                //See the Summary bellow:
                System.out.println("\n--- Calculation Summary ---");
                System.out.printf("Monthly Payout: $%.2f\n", payout);
                System.out.printf("Interest Rate: %.3f%%\n", pvAnnualRate * 100);
                System.out.printf("Present Value Needed: $%.2f\n", presentValue);
                break;

            default:
                System.out.println("Invalid choice. Please run the program again.");
        }

        scanner.close();

    }
}