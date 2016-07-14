package cn.ilovejava.controller;

import cn.ilovejava.function.SerializeFunction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import java.io.IOException;

/**
 * Created by yqy on 2016/7/14.
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class ArticleControllerTest{
    @Test
    public void test1() throws IOException, ClassNotFoundException {
        //System.out.println(new File(this.getClass().getResource("/likeAndIpAuth").getFile()).exists());
        System.out.println(SerializeFunction.likeAndIpAuth(2,"192.168.1.1",false));
    }
    @Test
    public void test2() throws IOException, ClassNotFoundException {

    }
}