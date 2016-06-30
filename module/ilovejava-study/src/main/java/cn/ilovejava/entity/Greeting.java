package cn.ilovejava.entity;

import cn.ilovejava.baseBean.BaseEntity;

public class Greeting extends BaseEntity {
 
    private String content;
 
    public Greeting(String content) {
        this.content = content;
    }
 
    public String getContent() {
        return content;
    }
 
}