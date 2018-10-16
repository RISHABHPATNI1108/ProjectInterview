package com.example.rishabh.projectinterview.models;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ChatResponseModel{


			@SerializedName("user_image_url")
			private String userImageUrl;

			@SerializedName("user_name")
			private String userName;

			@SerializedName("is_sent_by_me")
			private boolean isSentByMe;

			@SerializedName("text")
			private String text;

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

			public void setIsSentByMe(boolean isSentByMe){
				this.isSentByMe = isSentByMe;
			}

			public boolean isIsSentByMe(){
				return isSentByMe;
			}

			public void setText(String text){
				this.text = text;
			}

			public String getText(){
				return text;
			}

			@Override
			public String toString(){
				return
						"ChatResponseModel{" +
								"user_image_url = '" + userImageUrl + '\'' +
								",user_name = '" + userName + '\'' +
								",is_sent_by_me = '" + isSentByMe + '\'' +
								",text = '" + text + '\'' +
								"}";
			}
		}
