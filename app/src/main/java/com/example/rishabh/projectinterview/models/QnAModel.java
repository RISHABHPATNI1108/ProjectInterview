package com.example.rishabh.projectinterview.models;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class QnAModel{

	@SerializedName("user_image_url")
	private String userImageUrl;

	@SerializedName("upvotes")
	private int upvotes;

	@SerializedName("user_name")
	private String userName;

	@SerializedName("time")
	private String time;

	@SerializedName("text")
	private String text;

	@SerializedName("downvotes")
	private int downvotes;

	@SerializedName("tags")
	private List<String> tags;

	public void setUserImageUrl(String userImageUrl){
		this.userImageUrl = userImageUrl;
	}

	public String getUserImageUrl(){
		return userImageUrl;
	}

	public void setUpvotes(int upvotes){
		this.upvotes = upvotes;
	}

	public int getUpvotes(){
		return upvotes;
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

	public void setDownvotes(int downvotes){
		this.downvotes = downvotes;
	}

	public int getDownvotes(){
		return downvotes;
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
			"QnAModel{" + 
			"user_image_url = '" + userImageUrl + '\'' + 
			",upvotes = '" + upvotes + '\'' + 
			",user_name = '" + userName + '\'' + 
			",time = '" + time + '\'' + 
			",text = '" + text + '\'' + 
			",downvotes = '" + downvotes + '\'' + 
			",tags = '" + tags + '\'' + 
			"}";
		}
}