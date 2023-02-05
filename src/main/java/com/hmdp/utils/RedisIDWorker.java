package com.hmdp.utils;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * @ClassName
 * @Descriptino
 * @Author
 * @Date
 **/

@Component
public class RedisIDWorker {
    //开始时间戳
    private static final long BEGIN_TIMESTAMP = 1672531200L;
    //生成序列号
    private static final int COUNT_BITS = 32;

    private StringRedisTemplate stringRedisTemplate;

    public RedisIDWorker(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    public long nextId(String keyPrefix){
        //1. 生成时间戳
        LocalDateTime now = LocalDateTime.now();
        long nowSecond = now.toEpochSecond(ZoneOffset.UTC);
        long timeStamp = nowSecond - BEGIN_TIMESTAMP;

        //2. 生成序列号
        //获取当前日期,
        String date = now.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        Long count = stringRedisTemplate.opsForValue().increment("icr:" + keyPrefix + ":" + date);

        //3. 拼接并返回
        return timeStamp << COUNT_BITS | count;
    }


    public static void main(String[] args) {
        LocalDateTime time = LocalDateTime.of(2023, 1, 1, 0, 0, 0);
        long second = time.toEpochSecond(ZoneOffset.UTC);
        System.out.println(second);
    }
}
