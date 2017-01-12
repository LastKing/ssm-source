package com.ltx;

import com.ltx.dao.IUserOperation;
import com.ltx.entry.Article;
import com.ltx.entry.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * Created by Rain on 2017/1/12.
 */
public class Test {
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public SqlSessionFactory getSession() {
        return sqlSessionFactory;
    }

    /**
     * 这个需要mapper 的namespace 为 entry
     *
     * @param id
     */
    public void getUserByIdByEntry(int id) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            User user = (User) session.selectOne("com.ltx.entry.User.selectUserByID", id);
            System.out.println(user.getUserAddress());
            System.out.println(user.getUserName());
        } finally {
            session.close();
        }
    }

    public void getUserById(int id) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            IUserOperation userOperation = session.getMapper(IUserOperation.class);

            User user = userOperation.selectUserByID(id);
            System.out.println(user.getId() + ":" + user.getUserName() + ":" + user.getUserAddress());
        } finally {
            session.close();
        }
    }

    public void getUserList(String userName) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            IUserOperation userOperation = session.getMapper(IUserOperation.class);

            List<User> users = userOperation.selectUsers(userName);
            for (User user : users) {
                System.out.println(user.getId() + ":" + user.getUserName() + ":" + user.getUserAddress());
            }
        } finally {
            session.close();
        }
    }

    public void addUser() {
        User user = new User();
        user.setUserAddress("人民广场");
        user.setUserName("飞鸟");
        user.setUserAge(80);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        IUserOperation userOperation = sqlSession.getMapper(IUserOperation.class);
        userOperation.addUser(user);
        sqlSession.commit();
        System.out.println("当前增加的用户 id 为 " + user.getId());
    }

    public void updateUser() {
        SqlSession session = sqlSessionFactory.openSession();
        IUserOperation userOperation = session.getMapper(IUserOperation.class);
        User user = userOperation.selectUserByID(4);
        user.setUserAddress("原来在魔都的普通创新园区");
        userOperation.updateUser(user);
        session.commit();
        session.close();
    }

    public void deleteUser(int id) {
        SqlSession session = sqlSessionFactory.openSession();
        IUserOperation userOperation = session.getMapper(IUserOperation.class);
        userOperation.deleteUser(id);
        System.out.println("删除成功");
        session.commit();
        session.close();
    }

    public void getUserArticles(int userid) {
        SqlSession session = sqlSessionFactory.openSession();
        IUserOperation userOperation = session.getMapper(IUserOperation.class);
        List<Article> articles = userOperation.getUserArticles(userid);
        for (Article article : articles) {
            System.out.println(article.getTitle() + ":" + article.getContent() +
                    ":作者是:" + article.getUser().getUserName() + ":地址:" +
                    article.getUser().getUserAddress());
        }
        session.close();
    }

    public void getUserArticles2(int userid) {
        SqlSession session = sqlSessionFactory.openSession();
        IUserOperation userOperation = session.getMapper(IUserOperation.class);
        List<Article> articles = userOperation.getUserArticles2(userid);
        for (Article article : articles) {
            System.out.println(article.getTitle() + ":" + article.getContent() +
                    ":作者是:" + article.getUser().getUserName() + ":地址:" +
                    article.getUser().getUserAddress());
        }
        session.close();
    }
}
