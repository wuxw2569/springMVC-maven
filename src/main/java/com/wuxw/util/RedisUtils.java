package com.wuxw.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Map;

import redis.clients.jedis.Jedis;

public class RedisUtils {

public static final int HOUR = 60 * 60;		//一小时
	public static final int DAY = 24 * 60 * 60;	//一天，24小时 * 60分钟 * 60秒
	public static final int WEEK = DAY * 7;		//一周，7天
	public static final int MONTH = DAY * 30;	//一月，30天
	
	/**
	 * 缓存单个值
	 * @param key
	 * @param value
	 */
	public static void setVal(String key,String value,int expireTime){
		Jedis redis = RedisPool.getJedis();
		redis.set(key, value);
		redis.expire(key, expireTime);	//设置过期时间，单位秒
		RedisPool.returnResource(redis);
	}
	/**
	 * <p class="detail">
	 * 功能：缓存单个值(Vo对象类型),默认一个星期
	 *  redis存的是序列化字符串
	 * </p>
	 * @throws
	 */
	public static void setVal(byte [] key,Object value){
		Jedis redis = RedisPool.getJedis();
		redis.set(key, serialize(value));
		redis.expire(key, WEEK);	//设置过期时间，单位秒
		RedisPool.returnResource(redis);
	}
	
	/**
	 * 获取单个值 (vo对象类型)
	 * redis取的是序列化字符串
	 * @param key
	 * @return
	 */
	public static Object  getVal(byte [] key){
		Jedis redis = RedisPool.getJedis();
		byte [] tempValue = redis.get(key);
		 Object  value  = unserizlize(tempValue);
		RedisPool.returnResource(redis);
		return value;
	}
	/**
	 * 获取单个值
	 * @param key
	 * @return
	 */
	public static String getVal(String key){
		Jedis redis = RedisPool.getJedis();
		String value = redis.get(key);
		RedisPool.returnResource(redis);
		return value;
	}

	/**
	 * 缓存map
	 * @param key
	 * @param map
	 */
	public static void setMap(String key,Map<String,String> map,int expireTime){
		if( map!=null && map.size()>0 ){
			Jedis redis = RedisPool.getJedis();
			redis.hmset(key, map);
			redis.expire(key, expireTime);	//设置过期时间，单位秒
			RedisPool.returnResource(redis);
		}
	}
	
	/**
	 * 获取整个map
	 * @param key
	 * @return
	 */
	public static Map<String,String> getMap(String key){
		Jedis redis = RedisPool.getJedis();
		Map<String,String> map = redis.hgetAll(key);
		RedisPool.returnResource(redis);
		return map;
	}
	
	/**
	 * 获取map 指定key列表的值
	 * @param key
	 * @param valKey
	 * @return
	 */
	public static List<String> getMap(String key,String...valKey){
		Jedis redis = RedisPool.getJedis();
		List<String> value = null;
		if( redis.exists(key) ){
			value = redis.hmget(key, valKey);
		}
		RedisPool.returnResource(redis);
		return value;
	}
	
	/**
	 * 获取map指定key的值
	 * @param key
	 * @param valKey
	 * @return
	 */
	public static String getMapVal(String key,String valKey){
		Jedis redis = RedisPool.getJedis();
		String value = null;
		if( redis.exists(key) ){
			List<String> list = redis.hmget(key, valKey);
			if( list!=null && list.size()>0 ){
				value = list.get(0);
			}
		}
		RedisPool.returnResource(redis);
		return value;
	}

	/**
	 * 缓存List
	 * @param key
	 * @param list
	 */
	public static void setList(String key,List<String> list,int expireTime){
		if( list!=null && list.size()>0 ){
			String[] listgroup = new String[list.size()];
			Jedis redis = RedisPool.getJedis();
			redis.lpush(key, list.toArray(listgroup));
			redis.expire(key, expireTime);	//设置过期时间，单位秒
			RedisPool.returnResource(redis);
		}
	}
	
	/**
	 * 获取List
	 * @param key
	 * @return
	 */
	public static List<String> getList(String key){
		Jedis redis = RedisPool.getJedis();
		List<String> value = null;
		if( redis.exists(key) ){
			value = redis.lrange(key, 0, -1);
		}
		RedisPool.returnResource(redis);
		return value;
	}
	
	/**
	 * 升序排序后输出List
	 * @param key
	 * @return
	 */
	public static List<String> sortList(String key){
		Jedis redis = RedisPool.getJedis();
		List<String> value = null;
		if( redis.exists(key) ){
			value = redis.sort(key);
		}
		RedisPool.returnResource(redis);
		return value;
	}

	/**
	 * 删除指定缓存对象
	 * @param key
	 */
	public static void del(String...key){
		Jedis redis = RedisPool.getJedis();
		redis.del(key);
		RedisPool.returnResource(redis);
	}
	

    /**
     * 序列化 <p class="detail">
     * 功能：存储对象
     * </p>
     * @return 
     * @throws
     */
    public static byte [] serialize(Object obj){
        ObjectOutputStream obi=null;
        ByteArrayOutputStream bai=null;
        try {
            bai=new ByteArrayOutputStream();
            obi=new ObjectOutputStream(bai);
            obi.writeObject(obj);
            byte[] byt=bai.toByteArray();
            return byt;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * 反序列化<p class="detail">
     * 功能：反序列化存储对象
     * </p> 
     * @return 
     * @throws
     */
    public static Object unserizlize(byte[] byt){
        ObjectInputStream oii=null;
        ByteArrayInputStream bis=null;
        bis=new ByteArrayInputStream(byt);
        try {
            oii=new ObjectInputStream(bis);
            Object obj=oii.readObject();
            return obj;
        } catch (Exception e) {
            
            e.printStackTrace();
        }
        
        return null;
    }
	
}