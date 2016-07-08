package cn.ilovejava.listener;

import lombok.extern.log4j.Log4j;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * session监听
 * Created by yqy on 2016/6/28.
 */
@Log4j
@WebListener
public class MySessionListener implements HttpSessionListener {
   /* @Autowired
    private SimpMessagingTemplate messagingTemplate;*/
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        log.info("会话创建");
        System.out.println("会话创建");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        log.info("会话销毁");
    }
}
