package com.example.rishabh.projectinterview.models;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class CodesModels{

	@SerializedName("user_image_url")
	private String userImageUrl;

	@SerializedName("code")
	private String code;

	@SerializedName("code_language")
	private String codeLanguage;

	@SerializedName("comments")
	private int comments;

	@SerializedName("upvotes")
	private int upvotes;

	@SerializedName("user_name")
	private String userName;

	@SerializedName("time")
	private long time;

	@SerializedName("title")
	private String title;

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

	public void setCode(String code){
		this.code = code;
	}

	public String getCode(){
		return code;
	}

	public void setCodeLanguage(String codeLanguage){
		this.codeLanguage = codeLanguage;
	}

	public String getCodeLanguage(){
		return codeLanguage;
	}

	public void setComments(int comments){
		this.comments = comments;
	}

	public int getComments(){
		return comments;
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

	public void setTime(long time){
		this.time = time;
	}

	public long getTime(){
		return time;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
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
			"CodesModels{" + 
			"user_image_url = '" + userImageUrl + '\'' + 
			",code = '" + code + '\'' + 
			",code_language = '" + codeLanguage + '\'' + 
			",comments = '" + comments + '\'' + 
			",upvotes = '" + upvotes + '\'' + 
			",user_name = '" + userName + '\'' + 
			",time = '" + time + '\'' + 
			",title = '" + title + '\'' + 
			",downvotes = '" + downvotes + '\'' + 
			",tags = '" + tags + '\'' + 
			"}";
		}
}