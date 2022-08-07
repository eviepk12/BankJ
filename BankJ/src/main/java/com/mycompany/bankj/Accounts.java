/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bankj;
import java.util.Scanner;

/**
 *
 * @author eviep
 */
public class Accounts {
    // Global class variable
    int balance;
    int previousTransaction;
    String customerUserName;
    String customerID;
    
    // Class constructor
    Accounts(String cname, String cid) {
        customerUserName = cname;
        customerID = cid;
    }
    
    void deposit(int amount) {
        if (amount != 0){ // will not do anything if the input is 0
            balance += amount;
            previousTransaction = amount;
        }
    }
    
    void withdraw(int amount) {
        if(amount != 0){
            balance -= amount;
            previousTransaction = -amount;
        }
    }
    
    void interest(int years) {
        double rate = .0185;
        double newBalance = (balance * rate * years) + balance;
        System.out.print("The current interest rate is " + (100 * rate) + "%");
        System.out.print("After " + years + " years, your balance will be: " + newBalance);
    } 
    
    void showPreviousTransaction() {
        if (previousTransaction > 0){
            System.out.print("Deposited: " + previousTransaction);
        }
        else if (previousTransaction < 0){
            System.out.print("Withdrew: " + previousTransaction);
        }
        else{
            System.out.print("No previous transaction was made: ");
        }
    }
    
    void showMenu() {
        char option;
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome, " + customerUserName + "!");
        System.out.println("Your ID is: " + customerID + "\n" );
        System.out.println("What would you like to do? \n");
        System.out.println("A. Check your Balance");
        System.out.println("B. Make a deposit");
        System.out.println("C. Make a withdrawal");
        System.out.println("D. View previous transaction");
        System.out.println("E. Calculate interest");
        System.out.println("F. Exit \n");
        
        do {
            System.out.print("Enter an option: ");
            char option1 = scan.next().charAt(0);
            option = Character.toUpperCase(option1);
            System.out.println();
            
            switch (option){
                case 'A':
                    System.out.println("====================================");
                    System.out.println("Balance = $" + balance);
                    System.out.println("==================================== \n");
                    break;
                case'B':
                    System.out.print("Enter the amount of deposit: ");
                    int amount = scan.nextInt();
                    deposit(amount);
                    System.out.println();
                    break;
                case 'C':
                    System.out.print("Enter the amount of withdrawal: ");
                    int amount2 = scan.nextInt();
                    withdraw(amount2);
                    System.out.println();
                    break;
                case 'D':
                    System.out.println("====================================");
                    showPreviousTransaction();
                    System.out.println("==================================== \n");
                    break;
                case 'E':
                    System.out.print("Enter the amount of years of interest: ");
                    int years = scan.nextInt();
                    interest(years);
                    System.out.println();
                case 'F':
                    System.out.println("====================================");
                    break;
            }
        }
        while(option !='F');
        System.out.println("Thank you for banking with us!!");
    }
    
}
