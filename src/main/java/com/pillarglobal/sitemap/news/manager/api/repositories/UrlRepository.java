package com.pillarglobal.sitemap.news.manager.api.repositories;

//import com.pillarglobal.sitemap.news.manager.api.models.Article;
import com.pillarglobal.sitemap.news.manager.api.xmlmodels.Url;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlRepository extends JpaRepository<Url, String> {
}
