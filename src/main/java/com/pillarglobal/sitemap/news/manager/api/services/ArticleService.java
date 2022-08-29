package com.pillarglobal.sitemap.news.manager.api.services;

import com.ctc.wstx.stax.WstxInputFactory;
import com.ctc.wstx.stax.WstxOutputFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlFactory;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.pillarglobal.sitemap.news.manager.api.clients.SitemapNewsClient;
import com.pillarglobal.sitemap.news.manager.api.exceptions.ArticleNotFoundException;
//import com.pillarglobal.sitemap.news.manager.api.models.Article;
import com.pillarglobal.sitemap.news.manager.api.repositories.UrlRepository;
import com.pillarglobal.sitemap.news.manager.api.xmlmodels.Url;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.stream.XMLInputFactory;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ArticleService {

    UrlRepository urlRepository;

    SitemapNewsClient sitemapNewsClient;

    @Autowired
    public ArticleService(UrlRepository urlRepository, SitemapNewsClient sitemapNewsClient){
        this.urlRepository = urlRepository;
        this.sitemapNewsClient = sitemapNewsClient;
    }
    public Url getArticle(String loc) {
        Optional<Url> byId = urlRepository.findById(loc);
        if (byId.isPresent()){
            return byId.get();
        }
        else throw new ArticleNotFoundException("Article with url: " + loc + " was not found.");
    }

    public List<Url> getAllArticles() {
        return urlRepository.findAll();
    }

    public void addArticle(Url article) {
        urlRepository.save(article);
    }

    public void updateArticle(Url article) {
        if(urlRepository.existsById(article.getLoc())){
            urlRepository.save(article);
        }
        else throw new ArticleNotFoundException("Article with url: " + article.getLoc() + " was not found.");
    }

    public void deleteArticle(String loc) {
        if (urlRepository.existsById(loc))
            urlRepository.deleteById(loc);
        else throw new ArticleNotFoundException("Article with url: " + loc + " was not found.");
    }

    public List<Url> getSitemapNews() {
        String stringResponse = sitemapNewsClient.getStringResponse();
        XMLInputFactory input = new WstxInputFactory();
        input.setProperty(XMLInputFactory.IS_NAMESPACE_AWARE, Boolean.FALSE);
        XmlMapper xmlMapper = new XmlMapper(new XmlFactory(input, new WstxOutputFactory()));
        try {
            List<Url> value = xmlMapper.readValue(stringResponse, new TypeReference<List<Url>>() {});
            value = value.stream().filter(url -> url.getLoc() != null).collect(Collectors.toList());
            return value;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
