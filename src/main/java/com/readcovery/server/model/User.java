package com.readcovery.server.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.readcovery.server.utils.PasswordUtils;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name = "user")
@JsonIgnoreProperties(value={"password", "created_at"})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank
    private String name;

    @NotBlank
    private String password;

    @NotBlank
    private String email;

    @Column(name = "interested_category")
    private String interestedCategory;

    @Column(name = "created_at", nullable = false, updatable = false)
//    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    protected User(){}

    public User(String name, String password, String email, String interestedCategory){
        this.name = name;
        this.password = PasswordUtils.getHashed(password);
        this.email = email;
        this.interestedCategory = interestedCategory;
        this.createdAt = new Date();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = PasswordUtils.getHashed(password);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInterestedCategory() {
        return interestedCategory;
    }

    public void setInterestedCategory(String interestedCategory) {
        this.interestedCategory = interestedCategory;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
}
