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
@Table(name = "image", schema = "news")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;
    @JacksonXmlProperty(isAttribute = false, localName = "image:loc")
    private String loc;
    @Lob
    @JacksonXmlProperty(isAttribute = false, localName = "image:caption")
    private String caption;
}
