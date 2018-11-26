package com.damu.dao;

import com.damu.entity.Users;
import com.damu.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UsersDAO {
    private SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
    private List<Users> list;
    private Users user;

    /*
    * 查询全部用户
    * */
    public List<Users> findAll(){
        try {
            list = sqlSession.selectList("findAll");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return list;
    }

    /*
     * 查询单个用户根据id
     * */
    public Users findById(Integer id){
        try {
            user = sqlSession.selectOne("findById", id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return user;
    }
}
