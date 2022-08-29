package com.pillarglobal.sitemap.news.manager.api.xmlmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
//    @JacksonXmlProperty(isAttribute = false, localName = "news:news")
//    @OneToOne
//    private News news;
//    @JacksonXmlProperty(isAttribute = false, localName = "image:image")
//    @JacksonXmlElementWrapper(useWrapping = false)
//    @OneToMany
//    private List<Image> images;
}
