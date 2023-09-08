package dev.kbe.login;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "accounts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    private ObjectId id;
    private String email;
    private String name;
    private String dateofBirth;
    private String password;

    public Account(String email, String name, String dateofBirth, String password) {
        this.email = email;
        this.name = name;
        this.dateofBirth = dateofBirth;
        this.password = password;
    }
}
