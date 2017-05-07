package com.hujian.mvc.dao;

import com.hujian.mvc.model.ChunkEntry;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Repository;

/**
 * Created by hujian on 2017/5/6.
 */
@Repository(value = "kvDao")
public class ChunkKVDaoImpl extends RedisGeneratorDao<String,ChunkEntry> implements KVDao {

    /**
     * put an object into redis
     * @param entry k,v
     * @return
     */
    @Override
    public Boolean putKv(ChunkEntry entry) {
        if( entry == null || this.redisTemplate == null){
            return false;
        }
        Boolean result = this.redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection redisConnection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                byte[] key = serializer.serialize(entry.getKey());
                byte[] value = serializer.serialize(entry.getValue());
                return redisConnection.setNX(key,value);
            }
        });
        return result;
    }

    /**
     * set k-v
     * @param entry
     * @return return the old object
     */
    @Override
    public ChunkEntry setKv(ChunkEntry entry) {
        if( entry == null ){
            return new ChunkEntry("empty","nil");
        }
        final String[] oldK = {null};
        final String[] oldV = {null};
        Boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection redisConnection) throws DataAccessException {
                RedisSerializer<String> redisSerializer = redisTemplate.getStringSerializer();
                final String key = entry.getKey();
                final String value = entry.getValue();
                byte[] k = redisSerializer.serialize( key );
                byte[] v = redisSerializer.serialize( value );
                //if exists
                Boolean test = redisConnection.exists( k );
                if( test == true ){
                    oldK[0] = entry.getKey();
                    oldV[0] = redisSerializer.deserialize(redisConnection.get( k ));
                }
                //set into redis
                redisConnection.set(k,v);
                return true;
            }
        });
        if( oldK[0] != null && oldV[0] != null){
            return new ChunkEntry(oldK[0],oldV[0]);
        }else{
            //this is the first entry of the key
            return entry;
        }
    }

    /**
     * get an key-value object from redis
     * @param key
     * @return
     */
    @Override
    public ChunkEntry getKv(final String key) {
        ChunkEntry result = redisTemplate.execute(new RedisCallback<ChunkEntry>() {
            @Override
            public ChunkEntry doInRedis(RedisConnection redisConnection) throws DataAccessException {
                RedisSerializer<String> redisSerializer = redisTemplate.getStringSerializer();
                byte[] k = redisSerializer.serialize(key);
                Boolean test = redisConnection.exists(k);
                if( test == null ){
                    return new ChunkEntry("empty","nil");
                }
                byte[] v = redisConnection.get(k);
                if( v == null || v.length == 0 ){
                    return new ChunkEntry("empty","nil");
                }
                String value = redisSerializer.deserialize(v);
                return new ChunkEntry(key,value);
            }
        });
        return result;
    }

    /**
     * delete a key-value
     * @param key
     */
    @Override
    public void remKv(String key) {
        redisTemplate.delete(key);
    }
}
