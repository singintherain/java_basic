package com.lvsong.aop;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * Created by lvsong on 9/9/15.
 */
public class ForumServiceTest {
    private ForumServiceImpl forumService;

    @Before
    public void setUp() {
        forumService = new ForumServiceImpl();
    }

    @After
    public void clearDown() {

    }

    @Test
    public void removeForumTest(){
        forumService.removeForum(1);
    }

    @Test
    public void removeTopicTest() {
        forumService.removeTopic(1);
    }

    @Test
    public void proxyTest() {
        ForumService forumService = new ForumServiceNoMonitorImpl();
        PerformaceHandler handler = new PerformaceHandler(forumService);
        ForumService proxy = (ForumService) Proxy.newProxyInstance(
                forumService.getClass().getClassLoader(),
                forumService.getClass().getInterfaces(),
                handler
        );

        proxy.removeForum(1);
        proxy.removeTopic(2);
    }
}
