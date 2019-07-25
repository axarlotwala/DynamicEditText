package com.snapcode.studentapp.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Subjects  implements Serializable {
    @Expose
    @SerializedName("subject")
    private String subject;
    @Expose
    @SerializedName("marks")
    private int marks;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
}
