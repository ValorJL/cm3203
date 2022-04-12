package com.c2086696.cm3203.Entity;

import javax.persistence.*;

@Entity
@Table(name = "article", uniqueConstraints = @UniqueConstraint(columnNames = "aid"))
public class Article {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "aid")
    private Integer aid;

    @Column(name = "title")
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "name", referencedColumnName = "name", nullable = false)
    private User name;

    @Column(name = "body",columnDefinition = "TEXT")
    private String body;

    @Column(name = "alike",columnDefinition = "Integer default '0'")
    private Integer alike = 0;


    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getName() {
        return name;
    }

    public void setName(User name) {
        this.name = name;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Integer getAlike() {
        return alike;
    }

    public void setAlike(Integer alike) {
        this.alike = alike;
    }

    @Override
    public String toString() {
        return "Article{" +
                "aid=" + aid +
                ", title='" + title + '\'' +
                ", name=" + name +
                ", body='" + body + '\'' +
                ", alike=" + alike +
                '}';
    }
}