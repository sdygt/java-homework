package net.sdygt.java.ex11;

import java.util.Arrays;

class Course {
    private final String CID;
    private final String title;
    private final Teacher[] teachers;

    Course(String CID, String title, Teacher... teachers) {
        this.CID = CID;
        this.title = title;
        this.teachers = teachers;
    }

    String getTitle() {
        return this.title;
    }

    @Override
    public String toString() {
        return CID + ' ' + title + ' ' + Arrays.toString(teachers);
    }
}
