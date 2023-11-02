package com.jusan.task.solidbank;

import com.jusan.task.solidbank.cli.impl.AccountBasicCLI;
import com.jusan.task.solidbank.cli.impl.MyCLI;
import com.jusan.task.solidbank.cli.impl.TransactionDepositCLI;
import com.jusan.task.solidbank.cli.impl.TransactionWithdrawCLI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@SpringBootApplication
@EnableJdbcRepositories
public class SolidbankApplication implements CommandLineRunner {

    private ApplicationContext context;
    private MyCLI myCLI;
    private AccountBasicCLI accountBasicCLI;
    private TransactionDepositCLI transactionDepositCLI;
    private TransactionWithdrawCLI transactionWithdrawCLI;
    @Autowired
    public SolidbankApplication(ApplicationContext context,
                                MyCLI myCLI,
                                AccountBasicCLI accountBasicCLI,
                                TransactionDepositCLI transactionDepositCLI,
                                TransactionWithdrawCLI transactionWithdrawCLI) {
        this.context = context;
        this.myCLI = myCLI;
        this.accountBasicCLI = accountBasicCLI;
        this.transactionDepositCLI = transactionDepositCLI;
        this.transactionWithdrawCLI = transactionWithdrawCLI;
    }

    public static void main(String[] args) {
        SpringApplication.run(SolidbankApplication.class);
    }

    @Override
    public void run(String... arg0) throws Exception {
        String helpMessage = "1 - show accounts\n2 - create account\n3 - deposit\n4 - withdraw\n5 - transfer\n6 - this message\n7 - exit\n";
        System.out.println("Welcome to CLI bank service");
        System.out.println("Enter operation number");
        System.out.println(helpMessage);

        boolean isRunning = true;
        String clientID = "1";

        while (isRunning) {
            switch (myCLI.getScanner().nextLine()) {
                case "1":
                    accountBasicCLI.getAccounts(clientID);
                    break;

                case "2":
                    accountBasicCLI.createAccountRequest(clientID);
                    break;

                case "3":
                    transactionDepositCLI.depositMoney(clientID);
                    break;

                case "4":
                    transactionWithdrawCLI.withdrawMoney(clientID);
                    break;

                case "6":
                    System.out.println(helpMessage);
                    break;

                case "7":
                    System.out.println("Application Closed");
                    isRunning = false;
                    break;

                default:
                    System.out.println("Command not recognized!");
                    break;
            }
        }
        ((AbstractApplicationContext) context).registerShutdownHook();
    }
}
