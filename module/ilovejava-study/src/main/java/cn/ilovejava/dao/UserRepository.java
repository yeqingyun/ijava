package cn.ilovejava.dao;

import cn.ilovejava.baseBean.BaseRepository;
import cn.ilovejava.entity.User;

/**
* Created by yeqy on 2016-07-15 16:59:24.
*/
public interface UserRepository<T extends User> extends BaseRepository<User> {

}