package cn.ilovejava.service;

import cn.ilovejava.baseBean.BaseRepository;
import cn.ilovejava.baseBean.BaseService;
import cn.ilovejava.dao.UserRepository;
import cn.ilovejava.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;

/**
* Created by yeqy on 2016-07-15 16:59:24.
*/
@Service
@Transactional
public class UserService<T extends User> extends BaseService<User>{

    @Resource
    private UserRepository<User> userRepository;

    @Override
    public BaseRepository<User> getBaseRepository() {return userRepository;}
}