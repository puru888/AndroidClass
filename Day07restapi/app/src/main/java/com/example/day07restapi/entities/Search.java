package com.example.day07restapi.entities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Search {
    @SerializedName("total_count")
    private int totalCount;
    private List<SearchItem> items;

}
