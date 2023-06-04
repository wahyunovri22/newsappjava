package com.example.newsappjava.model;

import com.google.gson.annotations.SerializedName;

public class ResponseLogin{

	@SerializedName("error")
	private boolean error;

	@SerializedName("message")
	private String message;

	@SerializedName("user")
	private User user;

	public boolean isError(){
		return error;
	}

	public String getMessage(){
		return message;
	}

	public User getUser(){
		return user;
	}
}