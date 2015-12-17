package com.lvsong.models;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by lvsong on 7/16/15.
 */
public class Course {
    List<Chapter> chapterList = new LinkedList<Chapter>();
    private String name;
    private int id;

    public Course() {
    }

    public Course(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Chapter> getChapterList() {
        return chapterList;
    }
}
