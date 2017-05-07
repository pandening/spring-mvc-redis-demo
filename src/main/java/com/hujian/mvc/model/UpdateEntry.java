package com.hujian.mvc.model;

import java.io.Serializable;

/**
 * Created by hujian on 2017/5/6.
 */
public class UpdateEntry implements Serializable {

    /**
     * the user id
     */
    private Integer user_id = null;
    /**
     * new nick name
     */
    private String nick_name = null;
    /**
     * new age
     */
    private String age = null;

    /**
     * new sex
     */
    private String sex = null;

    /**
     * new words of this user
     */
    private String words = null;

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getWords() {
        return words;
    }

    public void setWords(String words) {
        this.words = words;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
}
