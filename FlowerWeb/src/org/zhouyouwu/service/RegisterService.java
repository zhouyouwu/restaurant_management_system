package org.zhouyouwu.service;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.zhouyouwu.beans.UserBean;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class RegisterService {
    public static void addUser(UserBean user){
        try {
            String resource = "/resource/mybatis-config.xml";
            Reader reader = Resources.getResourceAsReader(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession sqlSession = sqlSessionFactory.openSession();

            String statement = "org.zhouyouwu.mapper.UserMapper.addUser";
            sqlSession.insert(statement, user);
            sqlSession.commit();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void selectUser(){
        try {
            String resource = "/resource/mybatis-config.xml";
            Reader reader = Resources.getResourceAsReader(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession sqlSession = sqlSessionFactory.openSession();

            String statement = "org.zhouyouwu.mapper.UserMapper.selectUser";
            List<UserBean> userList = sqlSession.selectList(statement);
            for(UserBean user : userList){
                System.out.println(user.getUsername());
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
