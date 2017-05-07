package com.hujian.mvc.controller;

import com.hujian.mvc.model.*;
import com.hujian.mvc.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hujian on 2017/5/5.
 */
@Controller
public class UserActionController {

    @Autowired
    private UserServices userServices;

    /**
     * you want to get the user info accord the user id
     * @param user_id
     * @param modelAndView
     * @return the user info by string type
     */
    @RequestMapping(value = "get/{user_id}",method = RequestMethod.GET)
    @ResponseBody
    String getUserByIdAction(@PathVariable Integer user_id, ModelAndView modelAndView){
        UserInfo userInfo = this.userServices.getUserInfoByUserId(user_id);
        return userInfo.toString();
    }

    /**
     * you want to get the user id list by the user nick name
     * @param nick_name the nick name
     * @return the id list
     */
    @ResponseBody
    @RequestMapping(value = "gets/{nick_name}",method = RequestMethod.GET)
    String getUserIdListByNickName(@PathVariable String nick_name){
        List<Integer> idList = this.userServices.getUsersIdListByNickName(nick_name);
        StringBuilder sb = new StringBuilder();
        if( idList == null || idList.size() == 0 ){
            sb.append("no such user with the nick name:"+nick_name);
            return sb.toString();
        }else{
            for( Integer id: idList ){
                sb.append(id+" ");
            }
            return sb.toString();
        }
    }

    /**
     * you want to get the user info list according to the id list
     * @param idList the id list
     * @return the user info list
     */
    @RequestMapping(value = "list/{idList}",method = RequestMethod.GET)
    @ResponseBody
    String getUserListByIdList(@PathVariable String idList){
        List<Integer> ids = new ArrayList<>();
        if( idList == null || idList.split(",").length == 0 ){
            return new String("No id");
        }else{
            for( String id : idList.split(",") ){
                ids.add( Integer.parseInt( id ) );
            }
        }
        List<UserInfo> userInfoList = this.userServices.getUserListByIdList(ids);
        if( userInfoList == null || userInfoList.size() == 0 ){
            return new String("empty result list");
        }else{
            StringBuilder sb = new StringBuilder();
            for( UserInfo userInfo : userInfoList ){
                sb.append(userInfo.toString());
                sb.append(" \n ");
            }
            return sb.toString();
        }
    }

    /**
     * you want to get the user info by the user nick name and the sex
     * @param nickname nick name
     * @param sex sex
     * @return the result map
     */
    @RequestMapping(value = "get/{nickname}/{sex}",method = RequestMethod.GET)
    @ResponseBody
    String getUserInfoByNickNameAndSex(@PathVariable String nickname,@PathVariable String sex){
        Map<String,String> map = new HashMap<>();
        if( nickname == null || sex == null ){
            return new String("error input");
        }else{
            map.put("nickname",nickname);
            map.put("sex",sex);
        }
        List<UserInfo> userInfoList = this.userServices.getUserByNickNameAndSex(map);
        if( userInfoList == null || userInfoList.size() == 0 ){
            return new String("empty list");
        }else{
            StringBuilder sb = new StringBuilder();
            for( UserInfo userInfo : userInfoList ){
                sb.append(userInfo.toString());
                sb.append(" \n ");
            }
            return sb.toString();
        }
    }

    /**
     * you want to get your friends list by the user id
     * @param user_id your user id
     * @return the friends list of your
     */
    @RequestMapping(value = "f/{user_id}",method = RequestMethod.GET)
    @ResponseBody
    String getFriendsOfMine( @PathVariable Integer user_id ){
        List<UserInfo> userInfoList = new ArrayList<>();
        userInfoList = this.userServices.getFriendsOfMine(user_id);
        if( userInfoList == null || userInfoList.size() == 0 ){
            return new String("no friends of you find");
        }else{
            StringBuilder sb = new StringBuilder();
            for( UserInfo userInfo : userInfoList ){
                sb.append(userInfo.toString());
                sb.append(" \n ");
            }
            return sb.toString();
        }
    }

    /**
     * get the friends list by the user id
     * @param user_id
     * @return return an object of com.hujian.mvc.model.UserFriendsEntry
     */
    @ResponseBody
    @RequestMapping(value = "ff/{user_id}",method = RequestMethod.GET)
    String getFriendsDetailsOfMine(@PathVariable Integer user_id){
        UserFriendsEntry userFriendsEntry = this.userServices.getUserFriendsList(user_id);
        if( userFriendsEntry == null ){
            return new String("the user:" + user_id + " has no friend");
        }else{
            return userFriendsEntry.toString();
        }
    }

    /**
     * get the user's friends' friends
     * @param user_id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "fff/{user_id}",method = RequestMethod.GET)
    String getFriendsFriends(@PathVariable  Integer user_id){
        UserFriendsFriendsEntry userFriendsFriendsEntry =
                this.userServices.getFriendsFriends( user_id );
        if( userFriendsFriendsEntry == null ){
            return new String("empty result");
        }else{
            return userFriendsFriendsEntry.toString();
        }
    }

    /**
     * get the insert page
     * @return return the insert.jsp page
     */
    @RequestMapping("insert")
    String insert(){
        return "insert";
    }

    /**
     * remove the user info
     * @return forward the url to remove.jsp
     */
    @RequestMapping("remove")
    String remove(){
        return "remove";
    }

    /**
     * update the user's info
     * @return forward to url: update.jsp
     */
    @RequestMapping("update")
    String update(){
        return "update";
    }

    /**
     * you want to insert an user into database
     * @param userEntry
     * @return
     */
    @RequestMapping(value = "insert.do",method = RequestMethod.POST)
    @ResponseBody
    String insertUser(InsertUserEntry userEntry){
        Integer ins = this.userServices.insertUser( userEntry );
        if( ins == -1 ){
            return new String("error input(null object)");
        }
        return new String(userEntry.toString());
    }

    /**
     * remove an user from database
     * @param user_id
     * @return
     */
    @RequestMapping(value = "remove.do",method = RequestMethod.POST)
    @ResponseBody
    String removeUserByUserId(Integer user_id){
        Integer ins = this.userServices.removeUserByUserId( user_id );
        if( ins == -1){
            return new String("null user_id:"+user_id);
        }else{
            return new String("remove done");
        }
    }

    /**
     * update the user info
     * @param updateEntry the new user
     * @return return the new user info
     */
    @RequestMapping("update.do")
    @ResponseBody
    String updateUserInfo(UpdateEntry updateEntry){
        Integer ins = this.userServices.updateUserInfo( updateEntry );
        if( ins == -1 ){
            return new String("no change");
        }else{
            return new String("update done");
        }
    }

}
