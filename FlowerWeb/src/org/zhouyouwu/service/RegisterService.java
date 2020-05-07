package org.zhouyouwu.service;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.zhouyouwu.beans.UserBean;
import org.zhouyouwu.mapper.UserMapper;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class RegisterService {
    /**添加用户
     *
     * @param user
     */
    public static void addUser(UserBean user){
        try {
            String resource = "/mybatis-config.xml";
            Reader reader = Resources.getResourceAsReader(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession sqlSession = sqlSessionFactory.openSession();
/**这种方法直接使用mapper，而不用接口，每一次写statement不太适合工程
 * 于是采用接口类，与mapper对应，直接调用接口函数
 */
//            String statement = "org.zhouyouwu.mapper.UserMapper.addUser";
//            sqlSession.insert(statement, user);
//            sqlSession.commit();

            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            int rusultInt = userMapper.addUser(user);
            sqlSession.commit();
            System.out.println(rusultInt);

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**查询所有的用户
     *
     * @return list<user>
     */
    public static List<UserBean> selectUserList(){
        try {
            String resource = "/mybatis-config.xml";
            Reader reader = Resources.getResourceAsReader(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession sqlSession = sqlSessionFactory.openSession();

//            String statement = "org.zhouyouwu.mapper.UserMapper.selectUser";
//            List<UserBean> userList = sqlSession.selectList(statement);

            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<UserBean> userList = userMapper.selectUserList();
            return userList;
        }catch (IOException e){
            e.printStackTrace();
        }

        return null;
    }

    /**用id查询用户
     * @return user
     */
    public static UserBean selectUser(String userId){
        try {
            String resource = "/mybatis-config.xml";
            Reader reader = Resources.getResourceAsReader(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession sqlSession = sqlSessionFactory.openSession();

            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            UserBean userList = userMapper.selectUser(userId);
            return userList;

        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
