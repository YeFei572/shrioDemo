package com.shirodemo.demo0808.config;

import com.shirodemo.demo0808.entity.User;
import com.shirodemo.demo0808.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: YeFei
 * @Date: Created in 10:27 2019/8/8
 * @Description:
 */
@Slf4j
public class CustomRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String principal = (String) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Set<String> stringSet = new HashSet<>();
        stringSet.add("user:show");
        stringSet.add("user:admin");
        info.setStringPermissions(stringSet);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        log.info("-------------{}----------", "身份认证方法");
        String userName = (String) authenticationToken.getPrincipal();
        String userPwd = new String((char[]) authenticationToken.getCredentials());

        User user = userService.login(userName, userPwd);
        // 根据用户名冲数据库获取密码
        String password = "123";
        if (null == userName) {
            throw new AccountException("用户名不存在！");
        } else if (!userPwd.equals(password)) {
            throw new AccountException("密码错误！");
        }
        return new SimpleAuthenticationInfo(userName, password, getName());
    }
}
