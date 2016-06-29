package cn.ilovejava.service;

import cn.ilovejava.baseBean.BaseRepository;
import cn.ilovejava.baseBean.BaseService;
import cn.ilovejava.dao.ModuleRepository;
import cn.ilovejava.entity.Module;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by NF on 2016/6/26.
 */
@Service
public class ModuleService<T extends Module> extends BaseService<Module> {
    @Resource
    private ModuleRepository<Module> moduleRepository;
    @Override
    public BaseRepository<Module> getBaseRepository() {
        return moduleRepository;
    }
}
