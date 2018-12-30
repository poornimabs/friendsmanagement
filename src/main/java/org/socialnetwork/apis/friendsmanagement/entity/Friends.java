package org.socialnetwork.apis.friendsmanagement.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
* Entity class for Friends
*
* @author  Poornima.BS
* @version 1.0
* @since   1.0 
*/

@Entity
public class Friends implements Serializable{
	
	private static final long serialVersionUID = 89096439103242259L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String user_one;
	private String user_two;
	
	public Friends(String userOne, String userTwo) {
		super();
		this.user_one = userOne;
		this.user_two = userTwo;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUser_one() {
		return user_one;
	}
	public void setUser_one(String user_one) {
		this.user_one = user_one;
	}
	public String getUser_two() {
		return user_two;
	}
	public void setUser_two(String user_two) {
		this.user_two = user_two;
	}
	

}
