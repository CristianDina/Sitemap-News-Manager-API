package com.pillarglobal.sitemap.news.manager.api.models;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@Table(name = "news", schema = "news")
public class News {
    @JacksonXmlProperty(isAttribute = false, localName = "news:publication")
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "publication_name", referencedColumnName = "name")
    private Publication publication;
    @JacksonXmlProperty(isAttribute = false, localName = "news:publication_date")
    private String publicationDate;
    @Id
    @JacksonXmlProperty(isAttribute = false, localName = "news:title")
    private String title;
    @JacksonXmlProperty(isAttribute = false, localName = "news:keywords")
    private String keywords;
}
