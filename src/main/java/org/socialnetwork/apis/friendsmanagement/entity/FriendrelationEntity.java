package org.socialnetwork.apis.friendsmanagement.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

/**
 * Entity class for Friendship
 *
 * @author  Poornima.BS
 * @version 1.0
 * @since   1.0 
 */

@Entity(name="FriendrelationEntity")
@Table (name="friendrelation")

@NamedNativeQueries({
	@NamedNativeQuery(
			name = "FriendrelationEntity.getFriends",
			query = "SELECT userTwo AS friend FROM friendrelation WHERE userOne =:user AND status=1"  + " UNION "
					+ "SELECT userOne AS friend FROM friendrelation WHERE userTwo =:user AND status=1"
			),
	@NamedNativeQuery(
			name = "FriendrelationEntity.getCommonFriends",
			query = "SELECT UserOneFriends.id FROM"
					+ "( SELECT userTwo id FROM friendrelation WHERE userOne = :userone AND status=1" + " UNION "
					+ "SELECT userOne id FROM friendrelation WHERE userTwo = :userone AND status=1)" + " AS UserOneFriends"  
					+ " JOIN "
					+ "( SELECT userTwo id FROM friendrelation WHERE userOne = :usertwo AND status=1" + " UNION "
					+ "SELECT userOne id FROM friendrelation WHERE userTwo = :usertwo AND status=1)" + " AS UserTwoFriends"  
					+ " ON UserOneFriends.id = UserTwoFriends.id"
			),
	@NamedNativeQuery(
			name = "FriendrelationEntity.getFriendConnection",
			query = "SELECT id FROM friendrelation WHERE "
					+ "(userOne =:userone AND userTwo =:usertwo) OR (userOne =:usertwo AND userTwo =:userone) AND status = :friendship" 
					
			)
})


public class FriendrelationEntity implements Serializable{

	private static final long serialVersionUID = 89096439103242259L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id", nullable=false)
	private Long id;
	
	@Column(name="userOne", nullable=false)
	private String userOne;
	
	@Column(name="userTwo", nullable=false)
	private String userTwo;
	
	private int status;

	public FriendrelationEntity(String userOne, String userTwo, int status) {
		super();
		this.userOne = userOne;
		this.userTwo = userTwo;
		this.status = status;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getUserOne() {
		return userOne;
	}
	public void setUserOne(String userOne) {
		this.userOne = userOne;
	}
	public String getUseTwo() {
		return userTwo;
	}
	public void setUseTwo(String useTwo) {
		this.userTwo = useTwo;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

}
