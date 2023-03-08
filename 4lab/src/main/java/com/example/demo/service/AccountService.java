package com.example.demo.service;

import com.example.demo.domain.dto.AccountCreateDTO;
import com.example.demo.domain.event.AccountCreatedEvent;
import com.example.demo.domain.model.Result;
import com.example.demo.domain.model.account.Account;
import com.example.demo.repository.AccountRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AccountService {
    private final AccountRepository accountRepository;

    private final ApplicationEventPublisher eventPublisher;

    public List<Account> findAllAccounts() {
        return accountRepository.findAll();
    }

    public Account createAccount(AccountCreateDTO accountCreateDTO) throws JsonProcessingException {
        Account account = new Account();
        account.setEmail(accountCreateDTO.getEmail());
        account.setPassword(accountCreateDTO.getPassword());
        account.setUsername(accountCreateDTO.getUsername());
        Account savedAccount = accountRepository.save(account);

        AccountCreatedEvent event = new AccountCreatedEvent();
        event.setEmittedDate(LocalDateTime.now());
        event.setAggregateObjectType("Account created");
        event.setAggregateObjectId(String.valueOf(savedAccount.getId()));

        ObjectMapper mapper = new ObjectMapper();
        event.setMessagePayload(mapper.writeValueAsString(savedAccount));

        eventPublisher.publishEvent(event);
        return savedAccount;
    }
    public Result deleteAccount(long id) throws JsonProcessingException {
        AccountCreatedEvent event = new AccountCreatedEvent();
        event.setAggregateObjectId(Long.toString(id));
        ObjectMapper mapper = new ObjectMapper();
        Result result = new Result();
        try {
            accountRepository.deleteById(id);
            event.setEmittedDate(LocalDateTime.now());
            event.setAggregateObjectType("Account deleted");
            //        event.setMessagePayload(String.format("{ \"Message\":\"Deleted account with id:%d\"}",id));
            result.setResult(true);
        } catch (Exception e) {
            event.setEmittedDate(LocalDateTime.now());
            event.setAggregateObjectType("Account failed to be deleted");
            result.setResult(false);
        }
        event.setMessagePayload(mapper.writeValueAsString(result));
        eventPublisher.publishEvent(event);
        return result;
    }
    public Account updateAccount(long id,AccountCreateDTO accountCreateDTO) throws JsonProcessingException {
        Optional<Account> accountData = accountRepository.findById(id);

        Account updatedAccount = accountData.get();
        updatedAccount.setEmail(accountCreateDTO.getEmail());
        updatedAccount.setPassword(accountCreateDTO.getPassword());
        updatedAccount.setUsername(accountCreateDTO.getUsername());

        Account savedAccount = accountRepository.save(updatedAccount);

        AccountCreatedEvent event = new AccountCreatedEvent();
        event.setEmittedDate(LocalDateTime.now());
        event.setAggregateObjectType("Account updated");
        event.setAggregateObjectId(String.valueOf(savedAccount.getId()));

        ObjectMapper mapper = new ObjectMapper();
        event.setMessagePayload(mapper.writeValueAsString(savedAccount));

        eventPublisher.publishEvent(event);
        return savedAccount;
    }
}
