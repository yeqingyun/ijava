package cn.ilovejava.service;

import cn.ilovejava.baseBean.BaseRepository;
import cn.ilovejava.baseBean.BaseService;
import cn.ilovejava.dao.PetRepository;
import cn.ilovejava.entity.Pet;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by yeqy on 2016/6/24.
 */
@Service
@Transactional
public class PetService<T extends Pet> extends BaseService<Pet> {
    @Resource
    private PetRepository<T> petRepository;
    @Override
    public BaseRepository<Pet> getBaseRepository() {
        return petRepository;
    }


    @Transactional
    public void findAndinsert(long id){
        Pet pet = new Pet();
        pet.setName("kankan");
        pet.setBirth(new Date());
        pet.setSex("m");
        petRepository.save(pet);
        Pet pet1 = petRepository.findOne(id);
        petRepository.save(pet1);
    }
}
