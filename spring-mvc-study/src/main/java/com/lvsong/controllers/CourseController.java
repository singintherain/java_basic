package com.lvsong.controllers;

import com.lvsong.models.Course;
import com.lvsong.services.CourseServiceInterf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.Map;

/**
 * Created by lvsong on 7/16/15.
 */
@Controller
@RequestMapping("/courses")
// /courses/**
public class CourseController {
//
//    private CourseServiceInterf courseService;
//
//    private static Logger log = LoggerFactory.getLogger(CourseController.class);
//
//    @Autowired
//    public void setCourseService(CourseServiceInterf courseService) {
//        this.courseService = courseService;
//    }
//
//    //本方法将处理/courses/view?courseId=123
//    @RequestMapping(value="/view", method = RequestMethod.GET)
//    public String viewCourse(@RequestParam("courseId") Integer courseId, Model model) {
//        Course course = courseService.searchCourse(courseId);
//        model .addAttribute(course);
//
//        return "courses/course_overview";
//    }
//
//    // /courses/view2/(courseId)
//    @RequestMapping(value="/view2/{courseId}", method = RequestMethod.GET)
//    public String restfulViewCourse(@PathVariable("courseId") Integer courseId, Map<String, Object> model) {
//        Course course = courseService.searchCourse(courseId);
//        model.put("course", course);
//
//        return "courses/course_overview2";
//    }

}
