package com.gui.demo.thingInJava.annotation;

import com.gui.demo.thingInJava.annotation.anno.UseCase;

import java.util.List;

/**
 * 注解的使用
 * @Date 2021/11/22 15:59
 * @Created by gt136
 */
public class PasswordUtils {
    @UseCase(id = 47,description = "Password must contain at least one numeric")
    public boolean validatePassword(String passwd) {
        return (passwd.matches("\\w*\\d\\w"));
    }

    @UseCase(id = 48)
    public String encryptPassword(String passwd) {
        return new StringBuilder(passwd).reverse().toString();
    }

    @UseCase(id = 49, description = "New password can't equal previously used ones")
    public boolean checkForNewPassword(List<String> prePasswords,String passwd) {
        return !prePasswords.contains(passwd);
    }
}
