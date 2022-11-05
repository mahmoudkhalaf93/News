package com.example.news.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;
//
//@Entity(tableName = "news")
//public class News {
//    @ColumnInfo(name = "id")
//    @PrimaryKey(autoGenerate = true)
//    private int id;
//    @ColumnInfo(name = "source")
//    private SourceModel sourceModel;
//    @ColumnInfo(name = "author")
//    private String author;
//    @ColumnInfo(name = "title")
//    private String title;
//    @ColumnInfo(name = "description")
//    private String description;
//    @ColumnInfo(name = "url")
//    private String url;
//    @ColumnInfo(name = "urlToImage")
//    private String urlToImage;
//    @ColumnInfo(name = "publishedAt")
//    private String publishedAt;
//    @ColumnInfo(name = "content")
//    private String content;
//    @ColumnInfo(name = "inFavorite")
//    private Boolean inFavorite;
//
//    public SourceModel getSourceModel() {
//        return sourceModel;
//    }
//
//    public void setSourceModel(SourceModel sourceModel) {
//        this.sourceModel = sourceModel;
//    }
//
//    public String getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(String author) {
//        this.author = author;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getUrl() {
//        return url;
//    }
//
//    public void setUrl(String url) {
//        this.url = url;
//    }
//
//    public String getUrlToImage() {
//        return urlToImage;
//    }
//
//    public void setUrlToImage(String urlToImage) {
//        this.urlToImage = urlToImage;
//    }
//
//    public String getPublishedAt() {
//        return publishedAt;
//    }
//
//    public void setPublishedAt(String publishedAt) {
//        this.publishedAt = publishedAt;
//    }
//
//    public String getContent() {
//        return content;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public Boolean getInFavorite() {
//        return inFavorite;
//    }
//
//    public void setInFavorite(Boolean inFavorite) {
//        this.inFavorite = inFavorite;
//    }
//
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        News news = (News) o;
//        return id == news.id && Objects.equals(sourceModel, news.sourceModel) && Objects.equals(author, news.author) && Objects.equals(title, news.title) && Objects.equals(description, news.description) && Objects.equals(url, news.url) && Objects.equals(urlToImage, news.urlToImage) && Objects.equals(publishedAt, news.publishedAt) && Objects.equals(content, news.content) && Objects.equals(inFavorite, news.inFavorite);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, sourceModel, author, title, description, url, urlToImage, publishedAt, content, inFavorite);
//    }
//}