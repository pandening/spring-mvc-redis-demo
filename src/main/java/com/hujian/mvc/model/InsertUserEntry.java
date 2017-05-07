package com.hujian.mvc.model;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

/**
 * Created by hujian on 2017/5/6.
 */
public class InsertUserEntry implements Serializable {

    private String nick_name = null;
    private String sex = null;
    private String age = null;
    private String words = null;

    @Override
    public String toString(){
        return "[" + this.nick_name  + " , " + this.sex + " , "
                + this.age + " : " + this.words + "]";
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getWords() {
        return words;
    }

    public void setWords(String words) {
        this.words = words;
    }
}
