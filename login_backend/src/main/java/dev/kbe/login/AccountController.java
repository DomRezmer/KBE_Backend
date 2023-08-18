package dev.kbe.login;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = { "http://localhost:3000" }, allowedHeaders = { "*" })
@RequestMapping("/api/v1/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts() {
        return new ResponseEntity<List<Account>>(accountService.allAccounts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Account>> getSingleAccount(@PathVariable ObjectId id) {
        return new ResponseEntity<Optional<Account>>(accountService.singleAccount(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Map<String, String> payload) {
        return new ResponseEntity<Account>(accountService.createAccount(payload.get("email"), payload.get("name"),
                payload.get("dateofBirth"), payload.get("password")), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Map<String, String> payload) {
        if (accountService.checkCredentials(payload.get("email"), payload.get("password"))) {
            return new ResponseEntity<String>("Login successful", HttpStatus.OK);
        }
        return new ResponseEntity<String>("Login failed", HttpStatus.UNAUTHORIZED);
    }
}
