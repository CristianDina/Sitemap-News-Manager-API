package com.pillarglobal.sitemap.news.manager.api.repositories;

import com.pillarglobal.sitemap.news.manager.api.models.Publication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicationRepository extends JpaRepository<Publication, Long> {
}

