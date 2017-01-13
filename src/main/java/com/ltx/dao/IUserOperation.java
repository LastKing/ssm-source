package com.ltx.dao;

import com.ltx.entity.Article;
import com.ltx.entity.User;
import com.ltx.plugin.PageInfo;
import org.apache.ibatis.annotations.Param;

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

    public List<Article> selectArticleListPage(@Param("page") PageInfo page, @Param("userid") int userid);
}
