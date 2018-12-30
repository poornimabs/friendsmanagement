package org.socialnetwork.apis.friendsmanagement.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
* Entity class for Users
*
* @author  Poornima.BS
* @version 1.0
* @since   1.0 
*/

@Entity
public class Users implements Serializable{
	private static final long serialVersionUID = 4611252234581144064L;

	@Id
    private String email;
	
	public Users() {
		
	}
	
	public Users(String email2) {
		super();
		this.email = email2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

}
