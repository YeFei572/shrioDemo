package com.shirodemo.demo0808.config.redis;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Author: YeFei
 * @Date: Created in 11:46 2019/8/9
 * @Description:
 */
public interface RedisHelper<HK, T> {
    // Hash结构 添加元素
    void hashPut(String key, HK hashKey, T domain);

    Map<HK, T> hashFindAll(String key);

    T hashGet(String key, HK hashKey);

    void hashRemove(String key, HK hashKey);

    Long listPush(String key, T domain);

    Long listUnshift(String key, T domain);

    List<T> listFindAll(String key);

    T listLPop(String key);

    void valuePut(String key, T domain);

    T getValue(String key);

    void remove(String key);

    boolean expirse(String key, long timeout, TimeUnit timeUnit);
}
