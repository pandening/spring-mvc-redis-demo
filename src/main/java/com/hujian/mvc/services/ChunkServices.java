package com.hujian.mvc.services;

import com.hujian.mvc.dao.KVDao;
import com.hujian.mvc.model.ChunkEntry;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * Created by hujian on 2017/5/6.
 */
@Service
public class ChunkServices implements Serializable {

    /**
     * the kv dao
     */
    @Resource(name = "kvDao")
    private KVDao kvDao;

    /**
     * put an chunk contains k,v into redis
     * @param entry
     */
    public void put(ChunkEntry entry){
        if( entry == null ){
            return;
        }
        this.kvDao.putKv(entry);
    }

    /**
     * remove the key-value
     * @param key
     */
    public void remove(String key){
        this.kvDao.remKv(key);
    }

    /**
     * get the chunk by the key
     * @param key
     */
    public ChunkEntry get(String key){
        return this.kvDao.getKv( key );
    }

    /**
     * use set (no setNx), set will override old value,but setNx will not do this
     * @param entry the new (or source) object
     * @return the old object
     */
    public ChunkEntry set(ChunkEntry entry){
        return this.kvDao.setKv( entry );
    }

    public KVDao getKvDao() {
        return kvDao;
    }

    public void setKvDao(KVDao kvDao) {
        this.kvDao = kvDao;
    }
}
