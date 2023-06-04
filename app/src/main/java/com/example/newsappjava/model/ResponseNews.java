package com.example.newsappjava.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseNews{

	@SerializedName("news")
	private List<NewsItem> news;

	@SerializedName("error")
	private boolean error;

	public List<NewsItem> getNews(){
		return news;
	}

	public boolean isError(){
		return error;
	}
}