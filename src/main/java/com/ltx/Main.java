package com.ltx;

import java.io.IOException;

/**
 * Created by Rain on 2017/1/12.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Test testUser = new Test();
        testUser.getUserById(1);
        testUser.getUserList("%");
//        testUser.addUser();
//        testUser.updateUser();
//        testUser.deleteUser(2);
        testUser.getUserArticles(1);
        testUser.getUserArticles2(1);
    }

}
