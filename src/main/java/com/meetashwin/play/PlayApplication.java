package com.meetashwin.play;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class PlayApplication {

	private static ApplicationContext applicationContext;

	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
	    return new JedisConnectionFactory();
	}
	 
	@Bean
	public RedisTemplate<String, Object> redisTemplate() {
	    RedisTemplate<String, Object> template = new RedisTemplate<>();
	    template.setConnectionFactory(jedisConnectionFactory());
	    return template;
	}	

	public static void main(String[] args) {
		applicationContext = SpringApplication.run(PlayApplication.class, args);
		for (String beanName : applicationContext.getBeanDefinitionNames()) {
            System.out.println(beanName);
        }
	}

}
