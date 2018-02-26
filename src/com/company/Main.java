package com.company;

import java.io.*;
import java.util.*;
import java.text.*;

public class Main {

    public static void main(String[] args) {

        NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setMinimumFractionDigits(2);
        formatter.setMaximumFractionDigits(2);
        String name;

        ArrayList<BankAccount> aryList = new ArrayList();
        do {

            Scanner kbReader = new Scanner(System.in);
            System.out.println("Please enter the name to whom the account belongs \"Exit\" to abort");

            name = kbReader.nextLine();

            if (!name.equalsIgnoreCase("EXIT")){
                System.out.println("Please enter the amount of the deposit. ");
                double amount = kbReader.nextDouble();
                System.out.println(" ");
                BankAccount account = new BankAccount(name, amount);
                aryList.add(account);
            }
        }while(!name.equalsIgnoreCase("EXIT"));

        BankAccount ba = aryList.get(0);
        double maxBalance = ba.balance;
        String maxName = ba.name;
        for (int i=0; i<aryList.size(); i++){

            ba = aryList.get(i);
            if (maxBalance<ba.balance){
                maxBalance = ba.balance;
                maxName = ba.name;
            }
        }
        System.out.println("The account with the largest balance is " + maxName + "\n The amount is $" + maxBalance);
    }
}
