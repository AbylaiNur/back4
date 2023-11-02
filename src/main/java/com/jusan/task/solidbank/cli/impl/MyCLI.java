package com.jusan.task.solidbank.cli.impl;

import com.jusan.task.solidbank.cli.CLIUI;
import com.jusan.task.solidbank.model.enums.AccountType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Scanner;

@Component
public class MyCLI implements CLIUI {
    private Scanner scanner;

    public MyCLI() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public double requestClientAmount() {
        System.out.println("Type amount of money: ");

        String amountString = null;
        boolean isDouble = false;
        while (!isDouble) {
            try {
                amountString = scanner.nextLine();
                Double.parseDouble(amountString);
                isDouble = true;
            } catch (Exception e) {
                System.out.println("Not a number. Enter again:");
            }
        }
        return Double.parseDouble(amountString);
    }

    @Override
    public String requestClientAccountNumber() {
        System.out.println("Type account ID: ");
        return scanner.nextLine();
    }

    @Override
    public AccountType requestAccountType() {
        System.out.println("Choose account type");
        System.out.println(Arrays.toString(AccountType.values()));

        String accountType = scanner.nextLine();
        boolean isAccountTypeValid = false;

        while (!isAccountTypeValid) {
            try {
                AccountType.valueOf(accountType);
                isAccountTypeValid = true;
            } catch (Exception e) {
                System.out.println("Invalid account type. Enter again.");
                accountType = scanner.nextLine();
            }
        }
        return AccountType.valueOf(accountType);
    }

    public Scanner getScanner() {
        return scanner;
    }
}
