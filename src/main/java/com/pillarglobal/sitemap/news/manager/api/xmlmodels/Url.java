package com.pillarglobal.sitemap.news.manager.api.xmlmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Url {

    private String loc;
    private String lastmod;
    private String changefreq;
    private String priority;
    @JacksonXmlProperty(isAttribute = false, localName = "news:news")
    private News news;
}
