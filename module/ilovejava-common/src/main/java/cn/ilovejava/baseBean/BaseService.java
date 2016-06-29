package cn.ilovejava.baseBean;

import lombok.extern.log4j.Log4j;
import org.apache.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * Created by yeqy on 2016/6/24.
 */
@Log4j
public abstract class BaseService<T extends BaseEntity> {
    protected Logger logger = log;
    public abstract BaseRepository<T> getBaseRepository();
    public T insert(T t){
        return getBaseRepository().save(t);
    }
    public List<T> insertList(List<T> list){
        return getBaseRepository().save(list);
    }
    public T update(T t){
        return getBaseRepository().save(t);
    }
    public List<T> updateList(List<T> list){
        return getBaseRepository().save(list);
    }
    public void deleteById(Long id){
        getBaseRepository().delete(id);
    }
    public void delete(T t){
        getBaseRepository().delete(t);
    }
    public void deleteByList(List<T> t){
        getBaseRepository().save(t);
    }
    public void deleteAll(){
        getBaseRepository().deleteAll();
    }
    public T findById(Long id){
        return getBaseRepository().findOne(id);
    }
    public List<T> findByIds(List<Long> ids){
        return getBaseRepository().findAll(ids);
    }
    public List<T> findAll(){return getBaseRepository().findAll();}
    public boolean exists(Long id){
        return getBaseRepository().exists(id);
    }
    public long count(){
        return getBaseRepository().count();
    }
    public Page<T> findPage(Pageable page){
        return getBaseRepository().findAll(page);
    }
    public void flush(){
        getBaseRepository().flush();
    }
    public List<T> findAll(Sort sort){
        return getBaseRepository().findAll(sort);
    }
}
