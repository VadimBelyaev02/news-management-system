package com.vadim.userservice.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import net.devh.boot.grpc.client.channelfactory.GrpcChannelConfigurer;
import net.devh.boot.grpc.client.channelfactory.GrpcChannelFactory;
import net.devh.boot.grpc.client.config.GrpcChannelProperties;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Properties;

@Configuration
public class AppConfig {

    @Bean
    public WebClient webClient() {
        return WebClient.builder().build();
    }

//    @Bean
//    public ObjectMapper objectMapper() {
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
//        return objectMapper;
//    }
//    //
//    @Bean
//    public GrpcChannelFactory grpcChannelFactory(GrpcChannelProperties properties,
//                                                 ObjectProvider<GrpcChannelConfigurer> configurers) {
//        return new GrpcChannelFactory(properties, configurers.orderedStream());
//    }
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
