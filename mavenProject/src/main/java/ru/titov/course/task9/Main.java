package ru.titov.course.task9;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.titov.course.task9.exception.*;
import ru.titov.course.task9.service.AccountService;
import ru.titov.course.task9.service.AccountServiceConfig;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AccountServiceConfig.class);

        Account titov = new Account(0, 12345.01, new Holder("Titov"));
        Account krom = new Account(1, 42734512.05, new Holder("Krom"));

        AccountService accountService = context.getBean("accountService", AccountService.class);
        try {
//            accountService.insert(titov);
//            accountService.insert(krom);
            try {
                System.out.println(accountService.getById(titov.getId()).getBalance());
                System.out.println(accountService.getById(krom.getId()).getBalance());
            } catch (UnknownAccountException e) {
                e.printStackTrace();
            }
            try {
                accountService.transfer(krom.getId(), titov.getId(), 2000);
            } catch (NotEnoughMoneyException e) {
                e.printStackTrace();
            } catch (UnknownAccountException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                System.out.println(accountService.getById(titov.getId()).getBalance());
                System.out.println(accountService.getById(krom.getId()).getBalance());
            } catch (UnknownAccountException e) {
                e.printStackTrace();
            }
        } catch (AccountException e) {
            e.printStackTrace();
        } catch (DublicatePrimaryKeyException e) {
            e.printStackTrace();
        } catch (DaoException e) {
            e.printStackTrace();
        }



    }
}
