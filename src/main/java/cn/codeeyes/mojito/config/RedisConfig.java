package cn.codeeyes.mojito.config;

import com.alibaba.fastjson.support.spring.FastJsonRedisSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author codeeyes.cn
 * @date 2020/7/12 18:13
 */
@Configuration
public class RedisConfig {

  @Autowired
  private RedisTemplate redisTemplate;

  @Bean
  public RedisTemplate<String, Object> stringSerializerRedisTemplate() {
    RedisSerializer<String> stringSerializer = new StringRedisSerializer();
    redisTemplate.setKeySerializer(stringSerializer);
    redisTemplate.setValueSerializer(stringSerializer);
    redisTemplate.setHashKeySerializer(stringSerializer);
    redisTemplate.setHashValueSerializer(stringSerializer);
    return redisTemplate;
  }
}
