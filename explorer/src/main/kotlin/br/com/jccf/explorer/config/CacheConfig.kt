package br.com.jccf.explorer.config

import org.springframework.cache.annotation.EnableCaching
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisStandaloneConfiguration
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory


@Configuration
@EnableCaching
class CacheConfig {

    @Bean
    fun redisConnectionFactory(): JedisConnectionFactory {
        val configuration = RedisStandaloneConfiguration("localhost", 6379)
        return JedisConnectionFactory(configuration)
    }
}
