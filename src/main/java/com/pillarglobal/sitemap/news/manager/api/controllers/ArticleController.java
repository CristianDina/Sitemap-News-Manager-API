package com.pillarglobal.sitemap.news.manager.api.controllers;

import com.pillarglobal.sitemap.news.manager.api.models.Article;
import com.pillarglobal.sitemap.news.manager.api.services.ArticleService;
import com.pillarglobal.sitemap.news.manager.api.xmlmodels.Url;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @GetMapping("/getArticle")
    public ResponseEntity<Article> getArticle(@RequestParam String loc){
        Article article = articleService.getArticle(loc);
        return new ResponseEntity<>(article, HttpStatus.OK);
    }

    @GetMapping("/getAllArticles")
    public ResponseEntity<List<Article>> getAllArticles(){
        List<Article> allArticles = articleService.getAllArticles();
        return new ResponseEntity<>(allArticles,HttpStatus.OK);
    }

    @PostMapping("/addArticle")
    public ResponseEntity<String> addArticle(@RequestBody Article article){
        articleService.addArticle(article);
        return new ResponseEntity<>("Article with url: " + article.toString() + " was added.", HttpStatus.OK);
    }

    @PutMapping("/updateArticle")
    public ResponseEntity<String> updateArticle(@RequestBody Article article){
        articleService.updateArticle(article);
        return new ResponseEntity<>("Article with url: " + article.toString() + " was updated.", HttpStatus.OK);
    }

    @DeleteMapping("/deleteArticle")
    public ResponseEntity<String> deleteArticle(@RequestBody String loc){
        articleService.deleteArticle(loc);
        return new ResponseEntity<>("Article with url: " + loc + " was deleted.", HttpStatus.OK);
    }

    @GetMapping("/getSitemapNews")
    public List<Url> getSitemapNews(){
        return articleService.getSitemapNews();
    }
}
