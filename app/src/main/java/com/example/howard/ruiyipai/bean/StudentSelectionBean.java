package com.example.howard.ruiyipai.bean;

/**
 * Created by howard on 2018/1/20.
 * Email 158988127@qq.com
 */

public class StudentSelectionBean {
    public String name;
    public SELECTION_TYPE type;

    public StudentSelectionBean(String name, SELECTION_TYPE type) {
        this.name = name;
        this.type = type;
    }

    public static enum SELECTION_TYPE {
        TYPE_CLASS,
        TYPE_TEAM,
        TYPE_STUDENT
    }
}
