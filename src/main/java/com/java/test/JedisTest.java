package com.java.test;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.Set;

public class JedisTest {

    @Test
    public void testRedis(){
        // 1.获取连接
        Jedis jedis = new Jedis("127.0.0.1", 6379);

        // 2.执行具体的操作
        jedis.set("userName","Glenn");

        String value = jedis.get("userName");
        String value2 = jedis.get("Glenn");
        System.out.println(value);
        System.out.println(value2);

        jedis.hset("myhash","addr","beijing");
        String hValue = jedis.hget("myhash", "addr");
        System.out.println(hValue);

        Set<String> keys = jedis.keys("*");
        for (String key : keys) {
            System.out.println(key);
        }
        jedis.close();
    }




}
