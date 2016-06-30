package cn.ilovejava.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 *  控制主页
 */
@Controller
@Log4j
public class IndexController {
    /*@Resource PetService<Pet> petService;
    @Resource UserService<User> userService;
    @Resource JavaService<Java> javaService;*/



    @RequestMapping(value = {"","/"})
    public String index(ModelMap map){
        //log.info("index.html");
        return "index1";
    }

    @RequestMapping(value = {"/hah"})
    public String data(HttpSession session,ModelMap map){
        session.getAttribute("sat");
        return "dataStatistics";
    }

    @RequestMapping("/blogPage")
    public String blog(String id){
        //log.info("blog.html");
        return "blog";
    }

    @RequestMapping("/12")
    public String to12(){
        //javaService.sa();
        return "blog";
    }

    /*@RequestMapping("/upd")
    public String upd(ModelMap map){
        *//*Pet pet = new Pet();
        pet.setName("kankan");
        pet.setBirth(new Date());
        pet.setSex("m");
        petService.insert(pet);*//*
        List<Long> list = new ArrayList();
        list.add(1l);
        list.add(2l);
        map.put("host", petService.findByIds(list));
        return "index";
    }

    @RequestMapping("/get")
    public String get(ModelMap map){
        petService.findAndinsert(5l);
        return "index";
    }

    @RequestMapping("/post")
    public String post(ModelMap map){
        User user = userService.findById(1l);
        map.put("host",user);
        return "index";
    }

    *//**
     *
     * 分页
     * @param pageable
     * @return
     *//*

    @RequestMapping(value = "/page")
    @ResponseBody
    public Page<Pet> getEntryByPageable(@PageableDefault(value = 15, sort = { "id" }, direction = Sort.Direction.DESC)
                                             Pageable pageable) {
        return petService.findPage(pageable);
    }

    @RequestMapping(value = "/params", method=RequestMethod.GET)
    @ResponseBody
    public Page<Pet> getEntryByParams(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                       @RequestParam(value = "size", defaultValue = "15") Integer size) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(page, size, sort);
        return petService.findPage(pageable);
    }*/
}
