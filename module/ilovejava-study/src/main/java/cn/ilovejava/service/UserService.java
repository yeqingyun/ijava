package cn.ilovejava.service;

import cn.ilovejava.baseBean.BaseRepository;
import cn.ilovejava.baseBean.BaseService;
import cn.ilovejava.dao.UserRepository;
import cn.ilovejava.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by yqy on 2016/6/24.
 */
@Service
public class UserService<T extends User> extends BaseService<User> {
    @Resource
    private UserRepository<User> userRepository;
    @Override
    public BaseRepository<User> getBaseRepository() {
        return userRepository;
    }
}
