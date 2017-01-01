package com.pulkit.fitnetwork.repositories;

import com.pulkit.fitnetwork.model.Count;
import com.pulkit.fitnetwork.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcOperations;


/**
 * Created by shikh on 27-Nov-16.
 */

@Repository
public class UserRepository {

    private JdbcOperations jdbcOperations;

    String emailTestQuery = "select count(*) as count from user where email = ?";


    String signUpQuery = "insert into user(usertype,userToken,latitude,longitude,gender,email,firstName,lastName,userpassword,fitbitUserID,fitbitToken,fitbitTokenDuration) " +
            "values(?,?,?,?,?,?,?,?,?,?,?,?)";

    String loginQueryPart1 = "select count(*) from user where email = ? and userpassword = ?";

    String loginQueryPart2 = "update user set userToken = ? where email = ?";

    String logoutQuery = "update user set userToken = null where userToken = ?";

    String updateTokenQuery = "update user set userToken = ? where email = ?";

    String getUserByEmail = "select * from user where email = ?";

    String getUserEmailByUserToken = "select email from user where userToken = ?";

    String getUserIdByUserTokenQuery = "select userId from user where userToken = ?";

    String getUserIdByUserEmail = "select userId from user where email = ?";

    String getPasswordByEmailToken = "select userpassword from user where email = ?";

    String getFitbitUserTokenByUserTokenQuery = "select fitbitToken from user where userToken = ?";

    String getFitbitUserIDByUserTokenQuery = "select fitbitUserID from user where userToken = ?";


    String getFitbitTokenByUserTokenQuery = "select fitbitToken from user where email = ?";

    String getFitbitUserIdByUserEmailQuery = "select fitbitUserID from user where email = ?";

    String updateUserProfile = "update user set height = ? , age = ? , profileImageURL = ?  where email = ?";

    String getUserNameByEmail = "select concat(firstName,\" \",lastName) from user where email = ?";
    @Autowired
    public UserRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }


    public String signUp(User user) {
        jdbcOperations.update(signUpQuery,
                user.getUsertype(),
                user.getUserToken(),
                user.getLatitude(),
                user.getLongitude(),
                user.getGender(),
                user.getEmail(),
                user.getFirstName(),
                user.getLastName(),
                user.getUserpassword(),
                user.getFitbitUserID(),
                user.getFitbitToken(),
                user.getFitbitTokenDuration()
        );

        return user.getUserToken();
    }

    public String login(String email, String password, String newToken) {

        List<Count> list = jdbcOperations.query(loginQueryPart1, new Object[]{email, password}, new BeanPropertyRowMapper<Count>(Count.class));

        if (list.get(0).getCount() == 0) {
            System.out.println("Exception - wrong login credentials, email : " + email + " password : " + password + "list.get(0).getCount() :" + list.get(0).getCount());

            return "wrongcredentials";
        } else if (list.get(0).getCount() == 1) {
            jdbcOperations.update(loginQueryPart2, newToken, email);
            return newToken;
        }

        return "wrongcredentials";
    }


    public void logout(String userToken) {
        int result = jdbcOperations.update(logoutQuery, userToken);
    }

//    public FitbitUser getUserByEmail(String email) {
//        FitbitUser user = jdbcOperations.queryForObject(getUserByEmail, new BeanPropertyRowMapper<>(FitbitUser.class), email);
//        return user;
//    }

    public String getUserEmailByUserToken(String userToken) {
        String email = jdbcOperations.queryForObject(getUserEmailByUserToken, String.class, userToken);
        return email;
    }

    //getUserIdByUserToken
    //getUserIdByUserToken
    public Long getUserIdByUserToken(String userToken) {
        System.out.println("In repository " + getUserIdByUserTokenQuery + " " + userToken);
        Long userId = jdbcOperations.queryForObject(getUserIdByUserTokenQuery, Long.class, userToken);
        System.out.println("Ithis dposvsvs");

        return userId;
    }

    public Long getCurrentUserIdByEmail(String email) {
        Long userId = jdbcOperations.queryForObject(getUserIdByUserEmail, Long.class, email);
        return userId;
    }

    public Boolean checkIfEmailExists(String email) {

        List<Count> list = jdbcOperations.query(emailTestQuery, new Object[]{email}, new BeanPropertyRowMapper<Count>(Count.class));
        if (list.get(0).getCount() > 0) {
            System.out.println("LIST SIZE : " + list.size());
            return true;
        }

        return false;
    }

    public String getPasswordForEmail(String email) {

        String storedPassword = "none";

        try {
            storedPassword = jdbcOperations.queryForObject(getPasswordByEmailToken, String.class, email);
        } catch (Exception e) {
            System.out.println("Exception - user with email does not exist");
            return "none";
        }
        return storedPassword;
    }

    /**
     * Updates the token when logging in again
     *
     * @param email
     */
    public void updateToken(String newToken, String email) {
        jdbcOperations.update(updateTokenQuery, newToken, email);
    }


    public String getFitbitTokenByUserToken(String userToken) {
         return jdbcOperations.queryForObject(getFitbitUserTokenByUserTokenQuery,String.class,userToken);
    }

    public String getFitbitUserIDByUserToken(String userToken) {
        return jdbcOperations.queryForObject(getFitbitUserIDByUserTokenQuery,String.class,userToken);
    }

    public String getFitbitTokenByUserEmail(String userEmail) {

        return jdbcOperations.queryForObject(getFitbitTokenByUserTokenQuery,String.class,userEmail);
    }

    public String getFitbitUserIDByUserEmail(String userEmail) {
        System.out.print(userEmail);
        System.out.println(jdbcOperations.queryForObject(getFitbitUserIdByUserEmailQuery,String.class,userEmail));
        return jdbcOperations.queryForObject(getFitbitUserIdByUserEmailQuery,String.class,userEmail);
    }
    public int updateProfile(double Height , int Age, String ImageURL,String Email) {
        return jdbcOperations.update(updateUserProfile,Height,Age,ImageURL,Email);
    }
    public String getCurrentUserName(String email) {
        return jdbcOperations.queryForObject(getUserNameByEmail,String.class,email);
    }

}
