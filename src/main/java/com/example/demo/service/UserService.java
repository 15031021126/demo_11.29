package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author:wjup
 * @Date: 2018/9/26 0026
 * @Time: 15:23
 */
@Service
@Transactional
public class UserService {
    @Autowired
    UserMapper userMapper;

    public User Sel(int id) {
        return userMapper.Sel(id);
    }

    /**
     * 查询全部
     *
     * @return
     */
    public List<User> getUserList() {
        return userMapper.getUserList();
    }

    /**
     * 根据姓名查询
     *
     * @param name
     * @return
     */
    public List<User> getUserByName(String name) {
        return userMapper.selectByName(name);
    }

    /**
     * 添加数据
     *
     * @param
     * @return
     */
    public int insertUser(User user) {
        return  userMapper.addUser(user);
    }

    /**
     * 根据ID删除
     * @param id
     * @return
     */
    public  int deleteById(int id){
        return userMapper.deleteById(id);
    }

    /**
     * 修改
     * @param
     * @return
     */
    public int updateByID(User user ){
        return userMapper.updateUserById(user);
    }

    /**
     * 登录
     * @param user
     * @return
     */
    public List<User> login(User user){
        return userMapper.login(user);
    }

    /**
     * 分页查询只有数据
     * @param pageNum
     * @param pageSize
     * @return
     */
    public List<User> findAllUserByPageF(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> lists = userMapper.getUserList();
        return lists;
    }

    /**
     * 分页查询全部
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageInfo<User> findAllUserByPageS(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> lists = userMapper.getUserList();
        PageInfo<User> pageInfo = new PageInfo<User>(lists);
        return pageInfo;

    }


}
