package com.pillarglobal.sitemap.news.manager.api.models;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
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
@Table(name = "publication", schema = "news")
public class Publication {
    @Id
    @JacksonXmlProperty(isAttribute = false, localName = "news:name")
    private String name;
    @JacksonXmlProperty(isAttribute = false, localName = "news:language")
    private String language;
}
