package com.pillarglobal.sitemap.news.manager.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@Table(name = "url", schema = "news")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Url {

    @Id
    private String loc;
    private String lastmod;
    private String changefreq;
    private String priority;
    @JacksonXmlProperty(isAttribute = false, localName = "news:news")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "news_title", referencedColumnName = "title")
    private News news;
    @JacksonXmlProperty(isAttribute = false, localName = "image:image")
    @JacksonXmlElementWrapper(useWrapping = false)
    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "url_loc", referencedColumnName = "loc")
    private List<Image> images;
}
