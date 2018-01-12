package com.rest.service;

import com.github.pagehelper.PageInfo;
import com.rest.model.User;
import com.rest.model.UserRole;

/**
 * Created by yangqj on 2017/4/21.
 */
public interface UserService extends IService<User>{
    PageInfo<User> selectByPage(User user, int start, int length);

    User selectByUsername(String username);

    void delUser(Integer userid);

}
