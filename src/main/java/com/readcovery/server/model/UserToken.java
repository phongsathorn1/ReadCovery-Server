package com.readcovery.server.model;

import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
@Table(name = "user_token")
public class UserToken {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NonNull
    @Column(name = "user_id")
    private long userId;

    @NonNull
    private String token;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_id",
//            nullable = false, insertable = false, updatable = false)
//    private User user;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
}
