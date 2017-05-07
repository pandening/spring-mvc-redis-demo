package com.hujian.mvc.controller;

import com.hujian.mvc.model.ChunkEntry;
import com.hujian.mvc.services.ChunkServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.Serializable;

/**
 * Created by hujian on 2017/5/6.
 */
@Controller
@RequestMapping(value = "kv/",method = RequestMethod.GET)
public class ChunkKvController implements Serializable {

    /**
     * this is the kv service
     */
    @Autowired
    private ChunkServices chunkServices;

    /**
     * put an k-v into redis
     * @param key
     * @param value
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/put/{key}/{value}",method = RequestMethod.GET)
    public String put(@PathVariable String key,@PathVariable String value){
        if( key == null || value == null ){
            return new String("empty key,value");
        }else{
            ChunkEntry entry = new ChunkEntry(key,value);
            if( entry == null ){
                return new String("enpty object");
            }
            this.chunkServices.put(entry);
            return new String("put done");
        }
    }

    /**
     * set key-value
     * @param key
     * @param value
     * @return return the old entry
     */
    @ResponseBody
    @RequestMapping(value = "/set/{key}/{value}",method = RequestMethod.GET)
    public String set(@PathVariable String key,@PathVariable String value){
        if( key == null || value == null ){
            return new String("null key-value");
        }else{
            ChunkEntry chunkEntry = new ChunkEntry(key,value);
            return (this.chunkServices.set( chunkEntry ).toString());
        }
    }

    /**
     * get an chunk from redis
     * @param key
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/get/{key}",method = RequestMethod.GET)
    public String get(@PathVariable String key){
        if( key == null ){
            return new String("empty key");
        }else{
            ChunkEntry entry = this.chunkServices.get( key);
            return entry.toString();
        }
    }

    /**
     * remove an key-value from redis server
     * @param key
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/rem/{key}",method = RequestMethod.GET)
    public String remove(@PathVariable String key){
        if( key == null ){
            return new String("empty key");
        }else{
            this.chunkServices.remove( key );
            return new String("remove done");
        }
    }


    public ChunkServices getChunkServices() {
        return chunkServices;
    }

    public void setChunkServices(ChunkServices chunkServices) {
        this.chunkServices = chunkServices;
    }
}
