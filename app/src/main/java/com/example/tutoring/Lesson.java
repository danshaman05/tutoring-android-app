package com.example.tutoring;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Lesson {
    @SerializedName("id")
    Long id;
    @SerializedName("date")
    Date date;
    @SerializedName("price")
    Integer price;
    @SerializedName("language")
    String language;

}
