package com.pillarglobal.sitemap.news.manager.api.repositories;

import com.pillarglobal.sitemap.news.manager.api.models.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, String> {
}

