package ru.titov.course.task9.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AccountServiceConfig {
    @Bean
    @Scope("prototype")
    public FileRepository fileRepository() {
        return new FileRepository();
    }

    @Bean
    @Scope("singleton")
    public AccountService accountService() {
        return new AccountService(fileRepository());
    }

}
