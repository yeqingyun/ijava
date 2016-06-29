package cn.ilovejava.listener;

import cn.ilovejava.controller.JavaController;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * session监听
 * Created by yqy on 2016/6/28.
 */
@Log4j
public class ListenerSession implements HttpSessionListener {
    @Autowired
    private SimpMessagingTemplate messagingTemplate;
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        log.info("会话创建");
        JavaController.onLineCount++;
        messagingTemplate.convertAndSend("/app/chat.login", JavaController.onLineCount);
        System.out.println("会话创建");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        log.info("会话销毁");
    }
}
