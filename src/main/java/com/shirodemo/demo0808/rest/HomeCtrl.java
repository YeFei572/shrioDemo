package com.shirodemo.demo0808.rest;

import com.github.pagehelper.PageInfo;
import com.shirodemo.demo0808.dto.request.LoginReq;
import com.shirodemo.demo0808.entity.AdminAccount;
import com.shirodemo.demo0808.entity.User;
import com.shirodemo.demo0808.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: YeFei
 * @Date: Created in 10:49 2019/8/8
 * @Description:
 */
@RestController
public class HomeCtrl {
    @Autowired
    private UserService userService;

    @GetMapping(
            value = "/login"
    )
    public PageInfo<AdminAccount> defaultLogin(@RequestParam("p") int page, @RequestParam("s") int size) {
        return userService.selectByUserId("1", page, size);
    }

    @PostMapping(
            value = "/login",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public String login(
            @RequestBody LoginReq req
    ) {
        // 使用Shiro进行认证
        Subject subject = SecurityUtils.getSubject();
        // 在认证提交钱准备token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken(req.getUsername(), req.getPassword());
        // 执行认证登录
        try {
            subject.login(token);
        } catch (UnknownAccountException uae) {
            return "未知账户";
        } catch (IncorrectCredentialsException ice) {
            return "密码错误";
        } catch (LockedAccountException lae) {
            return "账户已锁定，无法登陆！";
        } catch (ExcessiveAttemptsException eae) {
            return "用户名或密码错误次数太多！";
        } catch (AuthenticationException ae) {
            return "用户名密码错误！";
        }
        if (subject.isAuthenticated()) {
            return "登录成功！";
        } else {
            token.clear();
            return "登录失败！";
        }
    }
}
