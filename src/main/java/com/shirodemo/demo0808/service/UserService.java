package com.shirodemo.demo0808.service;

import com.github.pagehelper.PageInfo;
import com.shirodemo.demo0808.entity.AdminAccount;
import com.shirodemo.demo0808.entity.User;

/**
 * @Author: YeFei
 * @Date: Created in 11:43 2019/8/8
 * @Description:
 */
public interface UserService {

    User login(String username, String password);

    PageInfo<AdminAccount> selectByUserId(String id, int page, int size);

    void addUser(String username, String password);

}
