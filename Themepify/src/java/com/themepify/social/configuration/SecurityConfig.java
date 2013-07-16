/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.themepify.social.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.filter.DelegatingFilterProxy;

/**
 *
 * @author faisalhadi
 */
@Configuration
@ImportResource({"classpath:spring-security.xml"})
public class SecurityConfig {

    @Bean
    public DelegatingFilterProxy springSecurityFilterChain() {
        DelegatingFilterProxy filterProxy = new DelegatingFilterProxy();
        return filterProxy;
    }
}
