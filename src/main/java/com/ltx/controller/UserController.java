package com.ltx.controller;

import com.ltx.dao.IUserOperation;
import com.ltx.entry.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by toonew on 2017/1/12.
 */
@Controller
@RequestMapping("/article")
public class UserController {
    @Autowired
    private IUserOperation userMapper;

    @RequestMapping("/list")
    public ModelAndView listall(HttpServletRequest request, HttpServletResponse response) {
        List<Article> articles=userMapper.getUserArticles(1);
        ModelAndView mav=new ModelAndView("list");
        mav.addObject("articles",articles);
        return mav;
    }
}
