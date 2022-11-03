package com.example.news.database;

import androidx.room.TypeConverter;

import com.google.gson.Gson;

public class Converters {
    @TypeConverter
    public static String fromSourceModelToJson(SourceModel user){
        return new Gson().toJson(user);
    }
    @TypeConverter
    public static SourceModel fromJsonToSourceModel(String json){
        return new Gson().fromJson(json,SourceModel.class);
    }
}
