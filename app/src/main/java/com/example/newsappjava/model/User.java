package com.example.newsappjava.model;

import com.google.gson.annotations.SerializedName;

public class User{

	@SerializedName("role")
	private String role;

	@SerializedName("nama")
	private String nama;

	@SerializedName("alamat")
	private String alamat;

	public String getRole(){
		return role;
	}

	public String getNama(){
		return nama;
	}

	public String getAlamat(){
		return alamat;
	}
}