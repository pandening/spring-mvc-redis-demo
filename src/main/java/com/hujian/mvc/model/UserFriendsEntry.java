package com.hujian.mvc.model;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

/**
 * Created by hujian on 2017/5/6.
 */
public class UserFriendsEntry implements Serializable {

    /**
     * this is the user id
     */
    @Autowired
    private Integer user_id = null;

    /**
     * this is my friends
     */
    @Autowired
    private List<UserInfo> friends = null;

    @Override
    public String toString(){
        String s = "[" + this.user_id+"]=>";
        if( friends == null || friends.size() == 0 ){
            s += "no friends]";
        }else{
            for( UserInfo userInfo:friends ){
                s += userInfo.toString() + " ";
            }
            s += "  @" + this.friends.size();
        }
        return s;
    }

}
