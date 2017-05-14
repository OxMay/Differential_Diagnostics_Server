package model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
//@SequenceGenerator(name = "user_", sequenceName = "user_")
@Table(name = "Users",uniqueConstraints = @UniqueConstraint(columnNames = {"login"}))
public class Users {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
//    @GeneratedValue(generator = "user_")
    private Long usersId;

    @Column(name = "secretKey", nullable = false, length = 36)
    private String secretKey;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "login", nullable = false)
    private String login;

    @Column(name = "password", nullable = false)
    private String password;

    public Users(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.secretKey = UUID.randomUUID().toString();
    }

    public Users() {
    }

    public Users(String login, String password) {
        this.login = login;
        this.password = password;
        this.secretKey = UUID.randomUUID().toString();
    }

    public Long getUsersId() {
        return usersId;
    }

    public void setId(Long id) {
        this.usersId = id;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
