package com.c2086696.cm3203.DAO;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import javax.persistence.SequenceGenerator;
import java.util.Collection;

@Entity
@Table(name = "authorities")
@SequenceGenerator(name = "authority_seq_gen", sequenceName = "authority_seq", initialValue = 1, allocationSize = 1)
public class Authority implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "authority_seq_gen")
    @Column(name = "id")
    private Long id;

    @Column(name = "authority", unique = true, nullable = false)
    private String authority;

    @ManyToMany(mappedBy = "authorities", cascade = CascadeType.ALL)
    private Collection<User> users;

    @Override
    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }

}
