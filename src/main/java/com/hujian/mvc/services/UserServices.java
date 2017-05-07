package com.hujian.mvc.services;

import com.hujian.mvc.model.*;

import java.util.List;
import java.util.Map;

/**
 * Created by hujian on 2017/5/5.
 */
public interface UserServices {

    /**
     * get the user info by the user id
     * @param user_id
     * @return
     */
    UserInfo getUserInfoByUserId(Integer user_id);

    /**
     * get the user id list by the nick name
     * @param nick_name the nick name
     * @return the id list
     */
    List<Integer> getUsersIdListByNickName(String nick_name);

    /**
     * get the user info list by the user id list
     * @param idList the user id list
     * @return the user info list
     */
    List<UserInfo> getUserListByIdList(List<Integer> idList);

    /**
     * you want to get the user info by the user nickname and the sex
     * @param map keys = {'nickname','sex'}
     * @return the result list
     */
    List<UserInfo> getUserByNickNameAndSex(Map<String,String> map);

    /**
     * you want to get your friends by your user id
     * @param user_id the user id
     * @return a list contains the friends of you
     */
    List<UserInfo> getFriendsOfMine(Integer user_id);

    /**
     * get the user's friends details
     * @param user_id the user id
     * @return the friends list
     */
    UserFriendsEntry getUserFriendsList(Integer user_id);

    /**
     * get the friends' friends
     * @param user_id the user id
     * @return the object of com.hujian.mvc.model.UserFriendsFriends
     */
    UserFriendsFriendsEntry getFriendsFriends(Integer user_id);

    /**
     * insert an user
     * @param userEntry
     * @return
     */
    Integer insertUser(InsertUserEntry userEntry);

    /**
     * remove an user from database
     * @param user_id
     * @return
     */
    Integer removeUserByUserId(Integer user_id);

    /**
     * update the user info
     * @param updateEntry the new user info
     * @return -1 means update error
     */
    Integer updateUserInfo(UpdateEntry updateEntry);

}
