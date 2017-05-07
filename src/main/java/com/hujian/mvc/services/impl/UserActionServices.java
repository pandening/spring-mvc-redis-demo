package com.hujian.mvc.services.impl;

import com.hujian.mvc.mapper.UserMapper;
import com.hujian.mvc.model.*;
import com.hujian.mvc.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by hujian on 2017/5/5.
 */
@Service
public class UserActionServices implements UserServices, Serializable {
    /**
     * this is the user mapper,do the dao operators about user
     */
    @Autowired
    private UserMapper userMapper;

    /**
     * you want to get the user info by the user id
     * @param user_id you should offer the user id
     * @return the result user info
     */
    @Override
    public UserInfo getUserInfoByUserId(Integer user_id){
        return this.userMapper.getUserById(user_id);
    }

    /**
     * you want to get the user id list by the user nick name
     * @param nick_name the nick name
     * @return  the user id list
     */
    @Override
    public List<Integer> getUsersIdListByNickName(String nick_name) {
        return this.userMapper.getUsersByNickName(nick_name);
    }

    /**
     * service implement
     * @param idList the user id list
     * @return
     */
    @Override
    public List<UserInfo> getUserListByIdList(List<Integer> idList) {
        if( idList == null || idList.size() == 0 ){
            return null;
        }
        return this.userMapper.getUserListByIdLists(idList);
    }

    /**
     * service implement
     * @param map keys = {'nickname','sex'}
     * @return
     */
    @Override
    public List<UserInfo> getUserByNickNameAndSex(Map<String, String> map) {
        if( map.isEmpty() ){
            return null;
        }
        if( map.get("nickname") == null || map.get("sex") == null ){
            return null;
        }
        return this.userMapper.getUserByNickNameAndSex(map);
    }

    @Override
    public List<UserInfo> getFriendsOfMine(Integer user_id) {
        if( user_id == null ){
            return null;
        }
        return this.userMapper.getFriendsOfMine(user_id);
    }

    /**
     * get the user friends
     * @param user_id the user id
     * @return
     */
    @Override
    public UserFriendsEntry getUserFriendsList(Integer user_id) {
        if( user_id == null ){
            return null;
        }
        return this.userMapper.getUserFriendsList(user_id);
    }

    /**
     * get the user's friends' friends
     * @param user_id the user id
     * @return
     */
    @Override
    public UserFriendsFriendsEntry getFriendsFriends(Integer user_id) {
        if( user_id == null ){
            return null;
        }
        return this.userMapper.getFriendsFriends(user_id);
    }

    /**
     * insert an user
     * @param userEntry the user info(insert)
     * @return
     */
    @Override
    public Integer insertUser(InsertUserEntry userEntry) {
        if( userEntry == null ){
            return -1;//-1 means error param
        }
        return this.userMapper.insertUser( userEntry );
    }

    /**
     * remove an user info from the database
     * @param user_id the user id need to be deleted
     * @return
     */
    @Override
    public Integer removeUserByUserId(Integer user_id) {
        if( user_id == null ){
            return -1;
        }
        return this.userMapper.removeUserByUserId( user_id );
    }

    /**
     * udpate the user info
     * @param updateEntry the new user info
     * @return
     */
    @Override
    public Integer updateUserInfo(UpdateEntry updateEntry) {
        if( updateEntry == null ){
            return -1;
        }
        return this.userMapper.updateUserInfo( updateEntry );
    }

}
