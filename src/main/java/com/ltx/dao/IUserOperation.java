package com.ltx.dao;

import com.ltx.entry.Article;
import com.ltx.entry.User;

import java.util.List;

/**
 * Created by Rain on 2017/1/12.
 */
public interface IUserOperation {
    public User selectUserByID(int id);

    public List<User> selectUsers(String userName);

    public void addUser(User user);

    public void updateUser(User user);

    public void deleteUser(int id);

    public List<Article> getUserArticles(int id);

    public List<Article> getUserArticles2(int id);
}
