package model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Long userID;

    @Column(name = "name")
    private String user_name;

    @Column(name = "balance")
    @Min(0)
    private int balance;

    @Pattern(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "username")
    private String username;

    public User(String user_name, int balance, String email, String password, String username) {
        this.user_name = user_name;
        this.balance = balance;
        this.email = email;
        this.password = password;
        this.username = username;
    }

    public User(){}

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<Bet> betList;

    public void addBetList(Bet bet){
        if(betList == null)
            betList = new ArrayList<>();
        betList.add(bet);
    }
}