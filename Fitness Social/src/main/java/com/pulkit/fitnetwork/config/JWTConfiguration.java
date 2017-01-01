package com.pulkit.fitnetwork.config;

import io.jsonwebtoken.impl.crypto.MacProvider;

import javax.annotation.PostConstruct;
import java.security.Key;

/**
 * Created by shikh on 27-Nov-16.
 */
public class JWTConfiguration {

    private static Key JWTKey = null;

    @PostConstruct
    private void generateKey() {
        JWTKey = MacProvider.generateKey();
        System.out.println("JWT key generated");
    }

    public static Key getJWTKey() {
        return JWTKey;
    }


}
