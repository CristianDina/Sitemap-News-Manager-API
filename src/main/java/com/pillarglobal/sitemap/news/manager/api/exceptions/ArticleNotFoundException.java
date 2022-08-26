package com.pillarglobal.sitemap.news.manager.api.exceptions;

public class ArticleNotFoundException extends RuntimeException{
    public ArticleNotFoundException(String message){
        super(message);
    }
}
