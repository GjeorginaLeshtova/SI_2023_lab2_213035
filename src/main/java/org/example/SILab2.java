package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class User {
    String username;
    String password;
    String email;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username){
        this.username=username;
    }
    public String getPassword() {
        return password;
    }
    public String getEmail() {
        return email;
    }
}

public class SILab2 {
    public static boolean function (User user, List<User> allUsers) { // 1
        if (user==null || user.getPassword()==null || user.getEmail()==null){ // 2
            throw new RuntimeException("Mandatory information missing!");  //3
        }

        if (user.getUsername()==null){   // 4
            user.setUsername(user.getEmail());   // 5
        }

        int same = 1; // 6
        if (user.getEmail().contains("@") && user.getEmail().contains(".")) {  //7
            same = 0; //8
            for (int i=0;i<allUsers.size();i++) {  //9.1 9.2 9.3
                User existingUser = allUsers.get(i); // 10
                if (existingUser.getEmail() == user.getEmail()) { // 11
                    same += 1;// 12
                }
                if (existingUser.getUsername() == user.getUsername()) { // 13
                    same += 1; // 14
                }
            }
        }

        String specialCharacters="!#$%&'()*+,-./:;<=>?@[]^_`{|}";
        String password = user.getPassword();
        String passwordLower = password.toLowerCase();

        if (passwordLower.contains(user.getUsername().toLowerCase()) || password.length()<8) { // 15
            return false; // 16
        }
        else { // 17
            if (!passwordLower.contains(" ")) { // 18
                for (int i = 0; i < specialCharacters.length(); i++) { // 19.1 19.2 19.3
                    if (password.contains(String.valueOf(specialCharacters.charAt(i)))) { // 20
                        return same == 0; // 21
                    }
                }
            }
        }
        return false; // 22
    } // 23

}