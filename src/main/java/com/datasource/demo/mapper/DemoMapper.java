package com.datasource.demo.mapper;

import com.datasource.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Wu Zicong
 * @create 2022-03-09 9:32
 */

public interface DemoMapper {
    User getUserInfo(@Param("id") String id);

    User selectUserInfo(String id);

    boolean removeUser(String id);

    Integer updateUser(@Param("user")User user);

    Integer insertUser(@Param("user") User user);
}
