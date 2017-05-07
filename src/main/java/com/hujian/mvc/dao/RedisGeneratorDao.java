package com.hujian.mvc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

import java.io.Serializable;

/**
 * Created by hujian on 2017/5/6.
 */
public abstract class
RedisGeneratorDao<K extends Serializable,V extends Serializable> {

    @Autowired
    protected RedisTemplate<K,V> redisTemplate;

    /**
     * get the redis string serializer
     * @return
     */
    public RedisSerializer<String> getRedisStringSerializer() {
        return redisTemplate.getStringSerializer();
    }

    /**
     * set the template
     * @param redisTemplate
     */
    public void setRedisTemplate(RedisTemplate<K, V> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
}
