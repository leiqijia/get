package com.jd.Massage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication//spring框架
@EnableAutoConfiguration//开启自动配置
public class App 
{
    public static void main( String[] args )
    {
      SpringApplication.run(App.class, args);
    }
}
