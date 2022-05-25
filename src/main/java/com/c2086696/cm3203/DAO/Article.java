package com.c2086696.cm3203.DAO;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "article")
@SequenceGenerator(name = "post_seq_gen", sequenceName = "post_seq", initialValue = 1, allocationSize = 1)
public class Article {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "aid")
    private Long aid;

    @Column(name = "title",nullable = false)
    private String title;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    @Column(name = "body",columnDefinition = "TEXT",nullable = false)
    private String body;

    public Long getAid() {
        return aid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Article{" +
                "aid=" + aid +
                ", title='" + title + '\'' +
//                ", user=" + user +
                ", body='" + body + '\'' +
                '}';
    }
}