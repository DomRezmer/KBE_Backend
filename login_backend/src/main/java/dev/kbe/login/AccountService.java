package dev.kbe.login;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Account> allAccounts(){
        return accountRepository.findAll();
    }

    public Optional<Account> singleAccount(ObjectId id){
        return accountRepository.findById(id);
    }

    public Account createAccount(String email, String name, String dateofBirth, String password){
        Account account = new Account(email, name, dateofBirth, password);
        accountRepository.insert(account);

        mongoTemplate.insert(account);

        return account;
    }
}
