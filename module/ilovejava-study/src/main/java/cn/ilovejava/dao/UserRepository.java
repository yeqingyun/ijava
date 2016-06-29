package cn.ilovejava.dao;

import cn.ilovejava.baseBean.BaseRepository;
import cn.ilovejava.entity.User;

/**
* Created by yeqy on 2016-06-26 19:54:49.
*/
public interface UserRepository<T extends User> extends BaseRepository<User> {

}