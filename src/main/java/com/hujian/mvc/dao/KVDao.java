package com.hujian.mvc.dao;

import com.hujian.mvc.model.ChunkEntry;

import java.io.Serializable;

/**
 * Created by hujian on 2017/5/6.
 */
public interface KVDao extends Serializable {

    /**
     * add an chunk contains k,v
     * @param entry k,v
     * @return
     */
    Boolean putKv(ChunkEntry entry);

    /**
     * set
     * @param entry
     * @return
     */
    ChunkEntry setKv(ChunkEntry entry);

    /**
     * get the chunk
     * @param key
     * @return the chunk
     */
    ChunkEntry getKv(String key);

    /**
     * remove an chunk from redis
     * @param key
     */
    void remKv(String key);

}
