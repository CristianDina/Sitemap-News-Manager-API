package com.pillarglobal.sitemap.news.manager.api.repositories;

import com.pillarglobal.sitemap.news.manager.api.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}

