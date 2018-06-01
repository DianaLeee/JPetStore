package com.example.jpetstore.domain;

import java.io.Serializable;


@SuppressWarnings("serial")
public class BlackList implements Serializable {

  /* Private Fields */

  private String username;
  private String userId;
  
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

  /* JavaBeans Properties */
}
