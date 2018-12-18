package com.readcovery.server.repository;

import com.readcovery.server.model.SaveArticle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SaveArticleRepository extends JpaRepository<SaveArticle, Long> {
    List<SaveArticle> findByUserId(long id);
}
