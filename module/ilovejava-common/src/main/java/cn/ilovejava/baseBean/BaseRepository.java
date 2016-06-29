package cn.ilovejava.baseBean;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by yqy on 2016/6/21.
 */
public interface BaseRepository<T extends BaseEntity> extends JpaRepository<T, Long> {
}
