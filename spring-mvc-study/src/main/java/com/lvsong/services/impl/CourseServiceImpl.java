package com.lvsong.services.impl;

import com.lvsong.models.Chapter;
import com.lvsong.models.Course;
import com.lvsong.services.CourseServiceInterf;
import org.springframework.stereotype.Service;

/**
 * Created by lvsong on 7/16/15.
 */
@Service
public class CourseServiceImpl implements CourseServiceInterf{

    public Course searchCourse(int courseId) {
        Course course = new Course(1, "Bibe");

        Chapter chapter1 = new Chapter("chapter1");
        Chapter chapter2 = new Chapter("chapter2");
        Chapter chapter3 = new Chapter("chapter3");

        course.getChapterList().add(chapter1);
        course.getChapterList().add(chapter2);
        course.getChapterList().add(chapter3);

        return course;
    }
}
