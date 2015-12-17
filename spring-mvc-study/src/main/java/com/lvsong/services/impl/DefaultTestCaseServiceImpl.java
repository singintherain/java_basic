package com.lvsong.services.impl;

import com.lvsong.services.TestCaseService;

/**
 * Created by lvsong on 7/16/15.
 */
public class DefaultTestCaseServiceImpl implements TestCaseService {
    public void run(TestCase testCase) {
        System.out.println("run testCase");
    }
}
