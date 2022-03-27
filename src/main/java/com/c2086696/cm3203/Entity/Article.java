package com.c2086696.cm3203.Entity;

import javax.persistence.*;

@Entity
@Table(name = "article", uniqueConstraints = @UniqueConstraint(columnNames = "Aid"))
public class Article {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer Aid;

    private String title;

    private Integer postBy;

    private String content;

    private Integer like;


    public Integer getAid() {
        return Aid;
    }

    public void setAid(Integer aid) {
        Aid = aid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPostBy() {
        return postBy;
    }

    public void setPostBy(Integer postBy) {
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

}
