package com.readcovery.server.repository;

import com.readcovery.server.model.SaveArticle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaveArticleRepository extends JpaRepository<SaveArticle, Long> {
}
