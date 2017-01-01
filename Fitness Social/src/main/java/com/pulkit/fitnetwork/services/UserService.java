package com.pulkit.fitnetwork.services;

import com.pulkit.fitnetwork.config.JWTConfiguration;
import com.pulkit.fitnetwork.model.User;
import com.pulkit.fitnetwork.repositories.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Key;

/**
 * Created by shikh on 27-Nov-16.
 */

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


    public String signUp(User user) {
        user.setUserToken(generateUserToken(user.getEmail()));
        String userToken = userRepository.signUp(user);
        return userToken;
    }

    public String login(String email, String password) {
        String userToken = userRepository.login(email, password, generateUserToken(email));
        return userToken;
    }

    /**
     * Logs out a current user by making userToken as null
     */
    public void logout(String userToken) {
        userRepository.logout(userToken);
    }

    public String generateUserToken(String email) {

        Key key = JWTConfiguration.getJWTKey();

        if (key == null) {
            throw new RuntimeException("JWT Key not set before being used");
        }

        String compactJws = Jwts.builder()
                .setSubject(email)
                .signWith(SignatureAlgorithm.HS512, key)
                .compact();

        return compactJws;
    }

    public String getCurrentUserEmail(String userToken) {
        return userRepository.getUserEmailByUserToken(userToken);
    }

    public Long getCurrentUserId(String userToken) {
        System.out.println("datfb "+userToken);

        return userRepository.getUserIdByUserToken(userToken);
    }

    public Long getCurrentUserIdByEmail(String email) {
        return userRepository.getCurrentUserIdByEmail(email);
    }

    public Boolean checkIfEmailExists(String email) {
        return userRepository.checkIfEmailExists(email);
    }

    public String getPasswordForEmail(String email) {
        return userRepository.getPasswordForEmail(email);
    }

    public String updateToken(String email) {
        String token = generateUserToken(email);
        //update in database
        userRepository.updateToken(token, email);
        return token;
    }

    public String getFitbitTokenByUserToken(String userToken) {

        return userRepository.getFitbitTokenByUserToken(userToken);
    }

    public String getFitbitUserIDByUserToken(String userToken) {

        return userRepository.getFitbitUserIDByUserToken(userToken);
    }

    public String getFitbitTokenByUserEmail(String userEmail) {
        return userRepository.getFitbitTokenByUserEmail(userEmail);
    }

    public String getFitbitUserIDByUserEmail(String userEmail) {
        return userRepository.getFitbitUserIDByUserEmail(userEmail);
    }
    public int updateProfile(double Height , int Age, String ImageURL,String Email) {
        return userRepository.updateProfile(Height,Age,ImageURL,Email);
    }
    public String getCurrentUserName(String email) {
        return userRepository.getCurrentUserName(email);
    }
}
