package com.example.demo.controller;

import com.example.demo.entity.ResponseCode;
import com.example.demo.entity.ServerResponse;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.github.pagehelper.PageInfo;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author:wjup
 * @Date: 2018/9/26 0026
 * @Time: 14:42
 */
@RestController
@RequestMapping("/testBoot")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 根据Id查询单个
     *
     * @param id
     * @return
     */
    @RequestMapping("/getUser")
    @ResponseBody
    public User GetUser(int id) {
        return userService.Sel(id);
    }

    /**
     * 查询全部数据
     *
     * @return
     */
    @RequestMapping("/getUserList")
    @ResponseBody
    @CrossOrigin
    public ServerResponse getUserList() {
        return ServerResponse.createBySuccess("查询成功", userService.getUserList());
    }

    /**
     * 根据姓名模糊查询
     *
     * @param name
     * @return
     */
    @RequestMapping("/getUserByName")
    @ResponseBody
    public List<User> getUserByName(String name) {
        return userService.getUserByName('%' + name + '%');
    }

    /**
     * 插入数据
     *
     * @param
     * @return
     */
    //对数据库进行增加字段操作
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public ServerResponse insert(@RequestBody User user) {
        return userService.insertUser(user) > 0 ?
                ServerResponse.createBySuccess("注册成功",user)
                :ServerResponse.createByErrorCodeMessage(1001,"注册失败");
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteById", method = RequestMethod.POST)
    public String deleteById(int id) {
        return userService.deleteById(id) > 0 ? "删除成功!" : "删除失败!";
    }

    /**
     * 修改
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/updateById", method = RequestMethod.POST)
    public String updateById(User user) {
        return userService.updateByID(user) > 0 ? "修改成功!" : "修改失败!";
    }

    /**
     * 登录
     *
     * @param
     * @return
     */

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @CrossOrigin
    @ResponseBody
    public ServerResponse login(@RequestBody String str) {
        User user = null;
        try {
            JSONObject jsonObject = new JSONObject(str);
            String name = jsonObject.getString("name");
            String password = jsonObject.getString("password");
            System.out.print(name + password);
            user = new User(null, name, password);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return (userService.login(user) != null && userService.login(user).size() > 0) ?
                ServerResponse.createBySuccess("登录成功", "用户:" + user)
                : ServerResponse.createByErrorCodeMessage
                (403, "登录失败,请检查账号或密码");
    }

    /**
     * 分页查询只显示数据
     * @param page
     * @param count
     * @return
     */
    @GetMapping("/findUserPage")
    @ResponseBody
    public List<User> testPageHelper1(int page, int count) {
        List<User> allUserByPageS = userService.findAllUserByPageF(page, count);
        return allUserByPageS;
    }

    /**
     * 分页查询显示总页数总数量
     * @param page
     * @param count
     * @return
     */
    @GetMapping("/findUserPageAll")
    public PageInfo<User> testPageHelper2(int page,int count) {
        PageInfo<User> queryResult = userService.findAllUserByPageS(page, count);
        return queryResult;
    }
}
