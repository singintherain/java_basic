package com.lvsong.aop;

/**
 * Created by lvsong on 9/9/15.
 */
public class ForumServiceImpl implements ForumService {
    public void removeTopic(int topicId) {
        PerformanceMonitor.begin("removeTopic");
        System.out.println("模拟删除Topic记录:" + topicId);

        try {
            Thread.currentThread().sleep(20);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        PerformanceMonitor.end();
    }

    public void removeForum(int forumId) {
        PerformanceMonitor.begin("removeForum");
        System.out.println("模拟删除Forum记录:" + forumId);

        try {
            Thread.currentThread().sleep(20);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        PerformanceMonitor.end();
    }
}
