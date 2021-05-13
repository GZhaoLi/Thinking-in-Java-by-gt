package com.gui.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @ClassName RedisConfig
 * @Description:Redis配置类
 * @author gt136
 * @Date 2021年2月18日20:49:27
 * @version 1.0
 */
@Configuration //当前类为配置类
public class RedisConfig {
    @Bean  //redisTemplate注入到spring容器
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory){
        RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
        RedisSerializer<String> redisSerializer = new StringRedisSerializer();
        redisTemplate.setConnectionFactory(factory);
        //key序列化
        redisTemplate.setKeySerializer(redisSerializer);
        //value序列化
        redisTemplate.setValueSerializer(redisSerializer);
        //key hashmap序列化
        redisTemplate.setHashKeySerializer(redisSerializer);
        //value hashmap序列化
        redisTemplate.setHashValueSerializer(redisSerializer);
        return redisTemplate;
    }
}
