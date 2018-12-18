package com.readcovery.server.model;

import org.springframework.data.annotation.CreatedDate;

import com.readcovery.server.model.Article;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "save_article")
public class SaveArticle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Column(name = "article_id")
    private long articleId;

    @NotNull
    @Column(name = "user_id")
    private long userId;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_at")
    private Date createAt;

    protected SaveArticle(){}

    public SaveArticle(long articleId, long userId){
        this.setArticleId(articleId);
        this.setUserId(userId);
    }

    public long getId() {
        return id;
    }

    public long getArticleId() {
        return articleId;
    }

    public void setArticleId(long articleId) {
        this.articleId = articleId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt() {
        this.createAt = new Date();
    }
}
