package com.ltx.mapper;

import com.ltx.entry.User;

import java.util.List;

/**
 * Created by Rain on 2017/1/12.
 */
public interface StudentMapper {

    public User getStudent(String studentID);

    public User getStudentAndClass(String studentID);

    public List<User> getStudentAll();

    public void insertStudent(User entity);

    public void deleteStudent(User entity);

    public void updateStudent(User entity);
}
