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
@Table(name = "image", schema = "news")
public class Image {
    @Id
    @JacksonXmlProperty(isAttribute = false, localName = "image:loc")
    private String loc;
    @JacksonXmlProperty(isAttribute = false, localName = "image:caption")
    private String caption;
}
