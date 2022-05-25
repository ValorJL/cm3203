package com.c2086696.cm3203.DAO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;


@Entity
@Table(name = "users")
@SequenceGenerator(name = "user_seq_gen", sequenceName = "user_seq", initialValue = 1, allocationSize = 1)
public class User implements UserDetails {


    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "user_seq_gen")
    @Column(name = "id")
    private Long id;


    @Column(name = "username",nullable = false,unique = true)
    private String username;

    @Column(name = "password",nullable = false)
    @JsonIgnore
    private String password;

    @Column(name = "enabled",nullable = false)
    private Boolean enabled;

    @OneToMany(mappedBy = "user")
    private Collection<Article> articles;


    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable(
            name = "users_authorities",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id")
    )
    private Collection<Authority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<Authority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean isAccountNonExpired() {//Account non-expired
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {//Account non-locked
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {//Credentials non-expired
        return true;
    }

    @Override
    public boolean isEnabled() {//Account enabled
        return this.enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}