package org.socialnetwork.apis.friendsmanagement.entity;

import java.io.Serializable;

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
			query = "SELECT user_two AS friend FROM friendrelation WHERE user_one =:user AND status=1"  + " UNION "
					+ "SELECT user_one AS friend FROM friendrelation WHERE user_two =:user AND status=1"
			),
	@NamedNativeQuery(
			name = "FriendrelationEntity.getCommonFriends",
			query = "SELECT UserOneFriends.id FROM"
					+ "( SELECT user_two id FROM friendrelation WHERE user_one = :userone AND status=1" + " UNION "
					+ "SELECT user_one id FROM friendrelation WHERE user_two = :userone AND status=1)" + " AS UserOneFriends"  
					+ " JOIN "
					+ "( SELECT user_two id FROM friendrelation WHERE user_one = :usertwo AND status=1" + " UNION "
					+ "SELECT user_one id FROM friendrelation WHERE user_two = :usertwo AND status=1)" + " AS UserTwoFriends"  
					+ " ON UserOneFriends.id = UserTwoFriends.id"
			),
	@NamedNativeQuery(
			name = "FriendrelationEntity.getFriendConnection",
			query = "SELECT id FROM friendrelation WHERE "
					+ "(user_one =:userone AND user_two =:usertwo) OR (user_one =:usertwo AND user_two =:userone) AND status = :friendship" 
					
			),
	@NamedNativeQuery(
			name = "FriendrelationEntity.updateFrienshipStatus",
			query = "UPDATE friendrelation SET "
					+ "status =:blockedstatus WHERE (user_one = :requestor AND user_two = :target) AND status = 1" 
					
			)
})


public class FriendrelationEntity implements Serializable{

	private static final long serialVersionUID = 89096439103242259L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String user_one;
	private String user_two;
	private int status;

	public FriendrelationEntity(String userOne, String userTwo, int status) {
		super();
		this.user_one = userOne;
		this.user_two = userTwo;
		this.status = status;
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

}
