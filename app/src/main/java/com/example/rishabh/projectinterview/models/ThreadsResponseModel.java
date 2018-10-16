package com.example.rishabh.projectinterview.models;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ThreadsResponseModel{

	@SerializedName("user_image_url")
	private String userImageUrl;

	@SerializedName("user_name")
	private String userName;

	@SerializedName("time")
	private String time;

	@SerializedName("text")
	private String text;

	@SerializedName("title")
	private String title;

	@SerializedName("tags")
	private List<String> tags;

	public void setUserImageUrl(String userImageUrl){
		this.userImageUrl = userImageUrl;
	}

	public String getUserImageUrl(){
		return userImageUrl;
	}

	public void setUserName(String userName){
		this.userName = userName;
	}

	public String getUserName(){
		return userName;
	}

	public void setTime(String time){
		this.time = time;
	}

	public String getTime(){
		return time;
	}

	public void setText(String text){
		this.text = text;
	}

	public String getText(){
		return text;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setTags(List<String> tags){
		this.tags = tags;
	}

	public List<String> getTags(){
		return tags;
	}

	@Override
 	public String toString(){
		return 
			"ThreadsResponseModel{" + 
			"user_image_url = '" + userImageUrl + '\'' + 
			",user_name = '" + userName + '\'' + 
			",time = '" + time + '\'' + 
			",text = '" + text + '\'' + 
			",title = '" + title + '\'' + 
			",tags = '" + tags + '\'' + 
			"}";
		}
}