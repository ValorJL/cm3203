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
    @JoinColumn(name = "user.userName")
    private User postBy;

    @Column(name = "content",columnDefinition = "TEXT")
    private String content;

    @Column(name = "like")
    private Integer like;


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

    public String getPostBy() {
        return postBy.getUserName();
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

    public Integer getLike() {
        return like;
    }

    public void setLike(Integer like) {
        this.like = like;
    }

    @Override
    public String toString() {
        return "Article{" +
                "aid=" + aid +
                ", title='" + title + '\'' +
                ", postBy=" + postBy +
                ", content='" + content + '\'' +
                ", like=" + like +
                '}';
    }
}
