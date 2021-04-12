package com.example.tutoring;

import com.google.gson.annotations.SerializedName;

public class Student {
    @SerializedName("id")
    Long id;
    @SerializedName("name")     // e.g. Rypak-Matus
    String name;
    @SerializedName("current-language")     // e.g. languages, that we use in our lessons Python / Java
    String language;
}
