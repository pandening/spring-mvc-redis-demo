package com.hujian.mvc.model;

import java.io.Serializable;

/**
 * Created by hujian on 2017/5/5.
 */
public class UserInfo implements Serializable{

    private Integer user_id = null;
    private String user_nick_name = null;
    private String user_sex = null;
    private Integer user_age = null;
    private String user_words = null;
    private Integer user_level = null;
    private Integer user_online_dates = null;
    private Boolean user_status = null;

    /**
     * the constructor
     * @param user_id the user id
     * @param user_nick_name the nick name
     * @param user_sex user sex '男' || '女'
     * @param user_age the age
     * @param user_words some words
     * @param user_level the level
     * @param user_online_dates the online dates
     */
    public UserInfo(int user_id,String user_nick_name,String user_sex,int user_age,
                    String user_words,int user_level,int user_online_dates,boolean user_status){
        this.user_id = user_id;
        this.user_nick_name = user_nick_name;
        this.user_sex = user_sex;
        this.user_age = user_age;
        this.user_words = user_words;
        this.user_level = user_level;
        this.user_online_dates = user_online_dates;
        this.user_status = user_status;
    }

    public UserInfo(){}

    @Override
    public String toString(){
        String info = "[";
        info += this.user_id + "," + this.user_nick_name + "," +
                this.user_sex + "," + this.user_age + "," +
                this.user_words + "," + this.user_level + "," +
                this.user_online_dates + " d," + this.user_status + "]";
        return info;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_nick_name() {
        return user_nick_name;
    }

    public void setUser_nick_name(String user_nick_name) {
        this.user_nick_name = user_nick_name;
    }

    public String getUser_sex() {
        return user_sex;
    }

    public void setUser_sex(String user_sex) {
        this.user_sex = user_sex;
    }

    public Integer getUser_age() {
        return user_age;
    }

    public void setUser_age(Integer user_age) {
        this.user_age = user_age;
    }

    public String getUser_words() {
        return user_words;
    }

    public void setUser_words(String user_words) {
        this.user_words = user_words;
    }

    public Integer getUser_level() {
        return user_level;
    }

    public void setUser_level(Integer user_level) {
        this.user_level = user_level;
    }

    public Integer getUser_online_dates() {
        return user_online_dates;
    }

    public void setUser_online_dates(Integer user_online_dates) {
        this.user_online_dates = user_online_dates;
    }

    public Boolean getUser_status() {
        return user_status;
    }

    public void setUser_status(Boolean user_status) {
        this.user_status = user_status;
    }
}
