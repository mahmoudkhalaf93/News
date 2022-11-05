package com.example.news.maper;


import com.example.news.database.NewsEgypt;
import com.example.news.database.SourceModel;
import com.example.news.network.response.Article;
import com.example.news.network.response.Source;

public class Maper {

    public static NewsEgypt maperFromNewsResponsToNewsEgyptDB(Article article) {
        NewsEgypt newsEgypt = new NewsEgypt();
        newsEgypt.setAuthor(article.getAuthor());
        newsEgypt.setContent(article.getContent());
        newsEgypt.setDescription(article.getDescription());
        SourceModel sourceModel = new SourceModel();
        sourceModel.setId(article.getSource().getId());
        sourceModel.setName(article.getSource().getName());
        newsEgypt.setSourceModel(sourceModel);
        newsEgypt.setInFavorite(false);
        newsEgypt.setTitle(article.getTitle());
        newsEgypt.setUrl(article.getUrl());
        newsEgypt.setPublishedAt(article.getPublishedAt());
        newsEgypt.setUrlToImage(article.getUrlToImage());

        return newsEgypt;
    }
    public static   Article  maperFromNewsEgyptDBToNewsRespons (NewsEgypt newsEgypt) {

        Article article = new Article();
        article.setAuthor(newsEgypt.getAuthor());
        article.setContent(newsEgypt.getContent());
        article.setDescription(newsEgypt.getDescription());
        Source source = new Source();
        source.setId(newsEgypt.getSourceModel().getId());
        source.setName(newsEgypt.getSourceModel().getName());
        article.setSource(source);
        article.setTitle(newsEgypt.getTitle());
        article.setUrl(newsEgypt.getUrl());
        article.setPublishedAt(newsEgypt.getPublishedAt());
        article.setUrlToImage(newsEgypt.getUrlToImage());

        return article;
    }
}
