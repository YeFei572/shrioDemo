package com.shirodemo.demo0808.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shirodemo.demo0808.config.redis.RedisHelper;
import com.shirodemo.demo0808.config.redis.RedisHelperImpl;
import com.shirodemo.demo0808.entity.AdminAccount;
import com.shirodemo.demo0808.entity.AdminAccountMapper;
import com.shirodemo.demo0808.entity.User;
import com.shirodemo.demo0808.entity.UserMapper;
import com.shirodemo.demo0808.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @Author: YeFei
 * @Date: Created in 11:44 2019/8/8
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AdminAccountMapper adminAccountMapper;

    @Autowired
    private RedisHelperImpl redisHelper;

    @Override
    public User login(String username, String password) {
        User user = userMapper.selectUser(username, password);
        return user;
    }

    @Override
    public PageInfo<AdminAccount> selectByUserId(String id, int page, int size) {
        PageHelper.startPage(page, size);
        List<AdminAccount> adminAccounts = adminAccountMapper.selectAll();
        PageInfo<AdminAccount> info = new PageInfo<>(adminAccounts);
        System.out.println(info);
        return info;
    }

    @Override
    public void addUser(String username, String password) {
        User user = new User();
        String id = UUID.randomUUID().toString().replaceAll("-", "");
        user.setId(id);
        user.setPassword(password);
        user.setUsername(username);
        redisHelper.valuePut("id", user);
        userMapper.insert(user);
    }


}
