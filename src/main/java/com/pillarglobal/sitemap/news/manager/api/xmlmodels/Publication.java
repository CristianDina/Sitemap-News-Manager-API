package com.pillarglobal.sitemap.news.manager.api.xmlmodels;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

@Data
public class Publication {
    @JacksonXmlProperty(isAttribute = false, localName = "news:name")
    private String name;
    @JacksonXmlProperty(isAttribute = false, localName = "news:language")
    private String language;
}
