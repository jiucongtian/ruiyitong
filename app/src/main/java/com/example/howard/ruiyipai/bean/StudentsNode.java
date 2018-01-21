package com.example.howard.ruiyipai.bean;

/**
 * Created by howard on 2018/1/21.
 * Email 158988127@qq.com
 */

public class StudentsNode {

//    public enum TYPE {
//        NODE_CLASS,
//        NODE_TEAM,
//        NODE_STUDENT
//    }
    static int static_id = 0;

    public int id;
    public String name;
    protected boolean mark;
    public StudentsGroupNode parent;

    public StudentsNode(StudentsGroupNode parent, String name) {
        this.parent = parent;
        this.id = static_id++;
        this.name = name;
        this.mark = false;
    }

    public void setMark(boolean mark) {
        this.mark = mark;
        if (null != parent) {
            parent.updateMark();
        }
    }

    public void setMarkNotCheckParent(boolean mark) {
        this.mark = mark;
    }




    public boolean isMark() {
        return mark;
    }
}
