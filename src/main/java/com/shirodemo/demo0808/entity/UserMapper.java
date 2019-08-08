package com.shirodemo.demo0808.entity;

import com.shirodemo.demo0808.config.mybaits.MyMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author: YeFei
 * @Date: Created in 11:41 2019/8/8
 * @Description:
 */
@Repository
public interface UserMapper extends MyMapper<User> {

    User selectUser(@Param("username") String username, @Param("password")String password);
}
