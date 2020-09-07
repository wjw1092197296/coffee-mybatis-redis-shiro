package com.my.coffee.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public  class  RedisUtil {
    @Autowired
    private RedisTemplate redisTemplate;

    /**添加String类型
     * @param key
     * @param value
     * @return
     */
    public Boolean set(String key,String value){
        Boolean result =false;
        try{
            redisTemplate.opsForValue().set(key,value);
            result = true;
        }catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }

    /**根据key取出值
     * @param key
     * @return
     */
    public  Object get( String key){
        return redisTemplate.opsForValue().get(key);
    }

    /**更新value
     * @param key
     * @param value
     * @return
     */
    public Boolean getAndSet(String key,String value){

        Boolean result =false;
        try{
            redisTemplate.opsForValue().getAndSet(key,value);
            result = true;
        }catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }

    /**删除
     * @param key
     * @return
     */
    public Boolean delete(String key){
        Boolean result =false;
        try{
            redisTemplate.delete(key);
            result = true;
        }catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }

}
