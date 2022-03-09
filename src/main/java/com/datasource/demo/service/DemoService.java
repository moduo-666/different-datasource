package com.datasource.demo.service;

import com.datasource.demo.entity.User;

/**
 * @author Wu Zicong
 * @create 2022-03-09 9:27
 */
public interface DemoService {
    User getUserInfo(String id);

    User selectUserInfo(String id);

    boolean removeUser(String id);

    Integer updateUser(User id);

    Integer insertUser(User id);
}
