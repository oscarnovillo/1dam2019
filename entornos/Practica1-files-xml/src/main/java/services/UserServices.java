/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import config.YamlConfig;

public class UserServices {

    public boolean checkUser(String user, String pass) {
        boolean userOK = false;
        if (YamlConfig.getInstance().getUser().equals(user)
                && YamlConfig.getInstance().getPass().equals(pass)) {
            userOK = true;
        }
        return userOK;
    }

}
