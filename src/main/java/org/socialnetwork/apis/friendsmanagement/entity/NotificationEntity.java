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
 * Entity class for notification
 *
 * @author  Poornima.BS
 * @version 1.0
 * @since   1.0 
 */

@Entity(name="NotificationEntity")
@Table (name="notification")

@NamedNativeQueries({
	@NamedNativeQuery(
			name = "NotificationEntity.getNotifiedUsers",
			query = "SELECT user_two friend FROM friendrelation WHERE user_one = :user and status=1" + " UNION "
					+ "SELECT user_one friend FROM friendrelation WHERE user_two = :user and status=1" + " UNION "
					+ "SELECT requestor friend FROM notification WHERE target = :user AND state = 1"
			),
	@NamedNativeQuery(
			name = "NotificationEntity.getBlockedUsersForUpdates",
			query = "SELECT requestor FROM notification WHERE"
					+ " (target = :userone OR target = :usertwo) AND state =:status"
			),
	@NamedNativeQuery(
			name = "NotificationEntity.getExistingSubsscribe",
			query = "SELECT requestor FROM notification WHERE "
					+ "(requestor = :requestor AND target = :target) AND state =:status"
			)
})


public class NotificationEntity implements Serializable{

	private static final long serialVersionUID = -6835878694775887884L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String requestor;
	private String target;
	private int state;

	public NotificationEntity(String requestor, String target, int state) {
		super();
		this.requestor = requestor;
		this.target = target;
		this.state = state;
	}

	public String getRequestor() {
		return requestor;
	}
	public void setRequestor(String requestor) {
		this.requestor = requestor;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}

}
