package com.pillarglobal.sitemap.news.manager.api.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@Table(name = "publication", schema = "news")
public class Publication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;
    @JacksonXmlProperty(isAttribute = false, localName = "news:name")
    private String name;
    @JacksonXmlProperty(isAttribute = false, localName = "news:language")
    private String language;
}
