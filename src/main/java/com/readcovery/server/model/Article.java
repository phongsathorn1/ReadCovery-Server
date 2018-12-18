package com.readcovery.server.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name = "Article")
@EntityListeners(AuditingEntityListener.class)
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank
    private String title;

    @NotBlank
    private String content;

    @NotBlank
    @Column(name = "link")
    private String url;

    @NotBlank
    private long category;

    @NotBlank
    @Column(name = "image_url")
    private String urlToImage;

    private Date published_at;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date created_at;

    protected Article(){}

    public Article(String title, String content, String url, String urlToImage, Date published_at){
        this.title = title;
        this.content = content;
        this.url = url;
        this.urlToImage = urlToImage;
        this.published_at = published_at;
    }

    public long getId(){
        return id;
    }

    public long getCategory(){
        return category;
    }

    public void setCategory(long category){
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String image_url) {
        this.urlToImage = image_url;
    }
}
