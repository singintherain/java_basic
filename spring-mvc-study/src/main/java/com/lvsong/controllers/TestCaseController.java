package com.lvsong.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lvsong on 7/16/15.
 */
@Controller
@RequestMapping("/testcases")
public class TestCaseController {

//    @Autowired
//    private TestCaseService testCaseService;
//
//    private static Logger log = LoggerFactory.getLogger(TestCaseController.class);
//
//    public void setTestCaseService(TestCaseService testCaseService) {
//        this.testCaseService = testCaseService;
//    }
//
//    @RequestMapping(value = "/index", method = RequestMethod.GET)
//    public String index() {
//        log.debug("debugger index: execute testCase");
////        System.out.println("debugger index: execute testCase");
//        log.info("info index: execute testCase");
//        return "/testcases/index";
//    }
//
//    @RequestMapping(value="/execute", method = RequestMethod.POST)
//    public String execute(@RequestParam("testcase")String testCaseContent) {
//        log.debug("execute testCase");
//        log.info("info: execute testCase");
//        System.out.println("---" + testCaseContent + "---");
//
//        TestCase testCase = new TestCase(testCaseContent);
//
//        testCaseService.run(testCase);
//
//        return "testcases/index";
//    }
}
