package com.example.newsappjava.model;

import com.google.gson.annotations.SerializedName;

public class NewsItem{

	@SerializedName("cover")
	private String cover;

	@SerializedName("userinput")
	private String userinput;

	@SerializedName("id")
	private String id;

	@SerializedName("deskripsi")
	private String deskripsi;

	@SerializedName("tanggal")
	private String tanggal;

	@SerializedName("judul")
	private String judul;

	public String getCover(){
		return cover;
	}

	public String getUserinput(){
		return userinput;
	}

	public String getId(){
		return id;
	}

	public String getDeskripsi(){
		return deskripsi;
	}

	public String getTanggal(){
		return tanggal;
	}

	public String getJudul(){
		return judul;
	}
}