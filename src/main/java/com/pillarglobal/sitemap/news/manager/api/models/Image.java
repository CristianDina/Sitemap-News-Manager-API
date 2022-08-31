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
@Table(name = "image", schema = "news")
public class Image {
    @Id
    @JacksonXmlProperty(isAttribute = false, localName = "image:loc")
    private String loc;
    @Lob
    @JacksonXmlProperty(isAttribute = false, localName = "image:caption")
    private String caption;
}
