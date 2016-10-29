package com.team7.security;

import com.team7.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * Created by sd95 on 10/28/16.
 */
@Component
@Scope(value="request", proxyMode= ScopedProxyMode.TARGET_CLASS)
public class WebContext {

    private final User user;

    public WebContext(){
        user = (User) SecurityContextHolder.getContext().
                getAuthentication().getPrincipal();
    }

    public String getUsername(){
        return user.getUsername();
    }

}