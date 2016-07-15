package cn.ilovejava.service;

import cn.ilovejava.baseBean.BaseRepository;
import cn.ilovejava.baseBean.BaseService;
import cn.ilovejava.dao.UserDiligenceRepository;
import cn.ilovejava.entity.UserDiligence;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;

/**
* Created by yeqy on 2016-07-15 16:59:25.
*/
@Service
@Transactional
public class UserDiligenceService<T extends UserDiligence> extends BaseService<UserDiligence>{

    @Resource
    private UserDiligenceRepository<UserDiligence> userDiligenceRepository;

    @Override
    public BaseRepository<UserDiligence> getBaseRepository() {return userDiligenceRepository;}
}