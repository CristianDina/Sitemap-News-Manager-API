package com.pillarglobal.sitemap.news.manager.api.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@Table(name = "news", schema = "news")
public class Article {
    @Id
    private String loc;
    private String lastmod;
    private String changefreq;
    private String priority;
    private String news_name;
    private String news_language;
    private String news_publication_date;
    private String news_title;
    private String news_keywords;
    private String image_loc;
    private String image_caption;
}
