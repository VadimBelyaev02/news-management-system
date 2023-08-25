package com.vadim.userservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class AppConfig {
//
//    @Bean("fuckingRedisTemplate")
//    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory connectionFactory) {
//        RedisTemplate<String, String> template = new RedisTemplate<>();
//        template.setConnectionFactory(connectionFactory);
//        template.setKeySerializer(new StringRedisSerializer());
//        template.setValueSerializer(new StringRedisSerializer());
//        return template;
//    }

//    @Bean
//    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
//        RedisTemplate<String, Object> template = new RedisTemplate<>();
//        template.setConnectionFactory(redisConnectionFactory);
//        template.setDefaultSerializer(new GenericJackson2JsonRedisSerializer());
//        template.setKeySerializer(new StringRedisSerializer());
//        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
//        return template;
//    }


    /*
    spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=sendermail83@gmail.com
spring.mail.password=ecqxfgeuetrlcsxi
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
     */
//    @Bean
//    public JavaMailSender javaMailSender() {
//        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//        Properties properties = new Properties();
//        properties.setProperty("spring.mail.properties.mail.smtp.auth", "true");
//        properties.setProperty("spring.mail.properties.mail.smtp.starttls.enable", "true");
//
//        // Установите настройки для JavaMailSender
//        mailSender.setHost("smtp.gmail.com");
//        mailSender.setPort(587);
//        mailSender.setUsername("sendermail720@gmail.com");
//        mailSender.setPassword("ejuhwdplhgsvgeqz");
//;
//        mailSender.setJavaMailProperties(properties);
//        mailSender.getJavaMailProperties().put("mail.debug", "true");
//        return mailSender;
//    }
}
