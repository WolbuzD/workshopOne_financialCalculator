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


        scanner.close();
    }
}