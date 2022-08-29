//package com.pillarglobal.sitemap.news.manager.api.xmlmodels;
//
//import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;
//
//@AllArgsConstructor
//@Data
//@NoArgsConstructor
//@Entity
//@Table(name = "news", schema = "news")
//public class News {
//    @JacksonXmlProperty(isAttribute = false, localName = "news:publication")
//    @OneToOne
//    private Publication publication;
//    @JacksonXmlProperty(isAttribute = false, localName = "news:publication_date")
//    private String publicationDate;
//    @Id
//    @JacksonXmlProperty(isAttribute = false, localName = "news:title")
//    private String title;
//    @JacksonXmlProperty(isAttribute = false, localName = "news:keywords")
//    private String keywords;
//
//}
