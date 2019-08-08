package com.shirodemo.demo0808.config.mybaits;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @Author: YeFei
 * @Date: Created in 14:32 2019/8/8
 * @Description:
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
