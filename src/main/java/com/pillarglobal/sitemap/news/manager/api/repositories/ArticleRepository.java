package com.pillarglobal.sitemap.news.manager.api.repositories;

import com.pillarglobal.sitemap.news.manager.api.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, String> {
}
