package com.shirodemo.demo0808;

import org.springframework.cache.annotation.EnableCaching;
import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableCaching // 开启缓存问题
@MapperScan("com.shirodemo.demo0808.entity")
@EnableTransactionManagement //启动注解事务管理，等同于xml配置方式<tx:annotation-driven/>
public class Demo0808Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo0808Application.class, args);
    }

}
