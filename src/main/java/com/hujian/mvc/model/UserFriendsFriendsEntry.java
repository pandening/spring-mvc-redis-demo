package com.hujian.mvc.model;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

/**
 * Created by hujian on 2017/5/6.
 */
public class UserFriendsFriendsEntry implements Serializable {

    /**
     * this is my user id
     */
    @Autowired
    private Integer user_id = null;

    /**
     * my friends friends
     */
    @Autowired
    private List<UserFriendsEntry> friendsFriends;

    @Override
    public String toString(){
        String s = "["+this.user_id+"]=>";
        if( this.friendsFriends == null || friendsFriends.size() == 0 ){
            s += " you have no friends ";
        }else{
            for( UserFriendsEntry userFriendsEntry:friendsFriends ){
                s +=  userFriendsEntry.toString();
            }
        }
        return s;
    }
}
