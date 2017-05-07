package com.hujian.mvc.model;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by hujian on 2017/5/5.
 */
public class Relationship implements Serializable {

    private Integer ownerId = null;
    private Set<Integer> followers = null;

    public Relationship(){}

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public Set<Integer> getFollowers() {
        return followers;
    }

    public void setFollowers(Set<Integer> followers) {
        this.followers = followers;
    }
}
