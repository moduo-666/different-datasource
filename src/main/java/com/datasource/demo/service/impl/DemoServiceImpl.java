package com.datasource.demo.service.impl;

import com.datasource.demo.entity.User;
import com.datasource.demo.mapper.DemoMapper;
import com.datasource.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Wu Zicong
 * @create 2022-03-09 9:28
 */
@Service
public class DemoServiceImpl implements DemoService {
    @Autowired
    private DemoMapper demoMapper;
    @Override
    public User getUserInfo(String id) {
        return demoMapper.getUserInfo(id);
    }

    @Override
    public User selectUserInfo(String id) {
        return null;
    }

    @Override
    public boolean removeUser(String id) {
        return false;
    }

    @Override
    public Integer updateUser(User user) {
       return demoMapper.updateUser(user);

    }

    @Override
    public Integer insertUser(User user) {
        return demoMapper.insertUser(user);
    }
}
