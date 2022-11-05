package com.example.news.database;

import androidx.room.TypeConverter;

import com.google.gson.Gson;

public class Converters {
    @TypeConverter
    public static String fromSourceModelToJson(SourceModel sourceModel){
        return new Gson().toJson(sourceModel);
    }
    @TypeConverter
    public static SourceModel fromJsonToSourceModel(String json){
        return new Gson().fromJson(json,SourceModel.class);
    }

}
