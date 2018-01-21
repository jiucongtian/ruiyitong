package com.example.howard.ruiyipai.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by howard on 2018/1/21.
 * Email 158988127@qq.com
 */

public class StudentsGroupNode extends StudentsNode {

    public boolean open;
    private List<StudentsNode> children;

    public StudentsGroupNode(StudentsGroupNode parent, String name) {
        super(parent, name);
        open = false;
        children = new ArrayList<>();
    }

    public void addMember(StudentsNode node) {
        children.add(node);
    }

    public List<StudentsNode> getMember() {
        return children;
    }

    public void updateMark() {
        boolean allMarked = true;
        for (StudentsNode child : children) {
            if (!child.isMark()) {
                allMarked = false;
                break;
            }
        }
        mark = allMarked;
    }

    @Override
    public void setMark(boolean mark) {
        super.setMark(mark);
        for (StudentsNode child : children) {
            child.setMarkNotCheckParent(mark);
        }
    }
}
