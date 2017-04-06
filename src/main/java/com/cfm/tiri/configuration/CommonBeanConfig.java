package com.cfm.tiri.configuration;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cfm.tiri.services.RoleServiceImpl;
import com.cfm.tiri.services.UserServiceImpl;
 
@Configuration
public class CommonBeanConfig {

    @Bean
    public StrongPasswordEncryptor strongEncryptor(){
        StrongPasswordEncryptor encryptor = new StrongPasswordEncryptor();
        return encryptor;
    }
    
    @Bean
    public RoleServiceImpl roleServiceImpl(){
    	RoleServiceImpl roleServiceImpl = new RoleServiceImpl();
        return roleServiceImpl;
    }
    
    @Bean
    public UserServiceImpl userServiceImpl(){
    	UserServiceImpl userServiceImpl = new UserServiceImpl();
        return userServiceImpl;
    }
}