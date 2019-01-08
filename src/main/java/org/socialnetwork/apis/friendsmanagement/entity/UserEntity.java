package org.socialnetwork.apis.friendsmanagement.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Entity class for Users
 *
 * @author Poornima.BS
 * @version 1.0
 * @since 1.0
 */

@Entity(name = "UserEntity")
@Table(name = "user",
    uniqueConstraints = @UniqueConstraint(columnNames = "EMAIL"))

@NamedNativeQueries({
    @NamedNativeQuery(
        name = "UserEntity.getMultipleUser",
        query = "SELECT COUNT(email) FROM user WHERE email =:userOneEmail OR email =:userTwoEmail"),
    @NamedNativeQuery(
        name = "UserEntity.getSingleUser",
        query = "SELECT email FROM user WHERE email =:userOneEmail")
})
public class UserEntity implements Serializable {

    private static final long serialVersionUID = 4611252234581144064L;

    @Id
    private String email;
    private String username;
    private String password;

    public UserEntity() {

    }

    public UserEntity(String email, String username, String password) {
        super();
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
