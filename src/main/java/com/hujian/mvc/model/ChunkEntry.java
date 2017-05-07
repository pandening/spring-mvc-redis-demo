package com.hujian.mvc.model;

import java.io.Serializable;

/**
 * Created by hujian on 2017/5/6.
 */
public class ChunkEntry implements Serializable {

    /**
     * key and value
     */
    private String key = null;
    private String value = null;

    public ChunkEntry(){}

    /**
     * the constructor
     * @param k
     * @param v
     */
    public ChunkEntry(String k,String v){
        this.key = k;
        this.value = v;
    }

    @Override
    public String toString(){
        return "{" + key + "," + value + "}";
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
