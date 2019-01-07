package org.socialnetwork.apis.friendsmanagement.dto;

import java.util.List;

/**
 * FriendsListDTO Data Transfer Object
 *
 * @author Poornima.BS
 * @version 1.0
 * @since 1.0
 */

public class FriendsListDTO extends ResponseDTO {

    private List<String> friends;

    private int count;

    public FriendsListDTO(List<String> friends) {
        super(true);
        this.friends = friends;
        this.count = friends.size();
    }

    public List<String> getFriends() {
        return friends;
    }

    public void setFriends(List<String> friends) {
        this.friends = friends;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
