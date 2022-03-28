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
    private User postBy;

    @Column(name = "content",columnDefinition = "TEXT")
    private String content;

    @Column(name = "alike")
    private Integer alike;


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

    public User getPostBy() {
        return postBy;
    }

    public void setPostBy(User postBy) {
        this.postBy = postBy;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
                ", postBy=" + postBy +
                ", content='" + content + '\'' +
                ", alike=" + alike +
                '}';
    }
}