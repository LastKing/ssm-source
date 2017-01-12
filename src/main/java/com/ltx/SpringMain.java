package com.ltx;

import com.ltx.dao.IUserOperation;
import com.ltx.entry.Article;
import com.ltx.entry.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Rain on 2017/1/12.
 */
public class SpringMain {
    private static ApplicationContext ctx;

    static {
        ctx = new ClassPathXmlApplicationContext("classpath:spring-core.xml");
    }

    public static void main(String[] args) {
        IUserOperation mapper = (IUserOperation) ctx.getBean("userMapper");
        System.out.println("得到用户id=1的用户信息");
        User user = mapper.selectUserByID(1);
        System.out.println(user.getUserAddress());

        //得到文章列表测试
        System.out.println("得到用户id为1的所有文章列表");
        List<Article> articles = mapper.getUserArticles(1);

        for(Article article:articles){
            System.out.println(article.getContent()+"--"+article.getTitle());
        }

    }
}
