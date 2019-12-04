package com.example.demo.mapper;


import com.example.demo.annotation.MyBatisDao;
import com.example.demo.entity.User;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author:wjup
 * @Date: 2018/9/26 0026
 * @Time: 15:20
 */
@Repository
@Mapper
@MyBatisDao
public interface UserMapper {
    User Sel(int id);

    List<User> getUserList();

    /**
     * 根据姓名查询
     *
     * @param name
     * @return
     */
    List<User> selectByName(@Param("name") String name);

    /**
     * 插入数据
     *
     * @param
     * @return
     */
    int addUser(User user);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    int deleteById(int id);

    /**
     * 修改
     *
     * @param
     * @return
     */
    int updateUserById(User user);

    /**
     * 登录
     *
     * @param user
     * @return
     */
    List<User> login(User user);


}
