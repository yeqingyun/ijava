package cn.ilovejava.service;

import cn.ilovejava.baseBean.BaseRepository;
import cn.ilovejava.baseBean.BaseService;
import cn.ilovejava.dao.JavaRepository;
import cn.ilovejava.entity.Java;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by NF on 2016/6/26.
 */
@Service
@Transactional
public class JavaService<T extends Java> extends BaseService<Java> {
    @Resource
    private JavaRepository<Java> javaRepository;

    @Override
    public BaseRepository<Java> getBaseRepository() {
        return javaRepository;
    }

    public void sa(){
        Java java = new Java();
        java.setName("叶青云");
        javaRepository.save(java);
        throw new RuntimeException("事务回滚了吗？");
    }
}
