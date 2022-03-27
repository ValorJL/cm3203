package com.c2086696.cm3203.Entity;

import org.springframework.web.bind.annotation.ControllerAdvice;

import javax.persistence.*;
import java.io.Serializable;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class User{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String userName;

    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}