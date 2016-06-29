package cn.ilovejava.dao;

import cn.ilovejava.baseBean.BaseRepository;
import cn.ilovejava.entity.Pet;

/**
* Created by yeqy on 2016-06-26 19:54:48.
*/
public interface PetRepository<T extends Pet> extends BaseRepository<Pet> {
    T findByName(String name);
}