package com.pillarglobal.sitemap.news.manager.api.xmlmodels;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

@Data
public class News {
    @JacksonXmlProperty(isAttribute = false, localName = "news:publication")
    private Publication news;
    @JacksonXmlProperty(isAttribute = false, localName = "news:publication_date")
    private String date;
    @JacksonXmlProperty(isAttribute = false, localName = "news:title")
    private String title;
    @JacksonXmlProperty(isAttribute = false, localName = "news:keywords")
    private String keywords;

}
