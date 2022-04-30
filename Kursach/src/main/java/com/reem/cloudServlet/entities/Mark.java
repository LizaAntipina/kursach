package com.reem.cloudServlet.entities;

public class Mark {

    private long id;
    private int mark;
    private Account expert;
    private Task task;

    public Mark(long id,int mark, Account expert, Task task) {
        this.id = id;
        this.mark = mark;
        this.expert = expert;
        this.task = task;
    }

    public Mark(int mark, Account expert, Task task) {
        this.mark = mark;
        this.expert = expert;
        this.task = task;
    }

    public Mark() {
    }

    public Mark(long id) {
        this.id = id;
    }

    public int getMark() {
        return mark;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public Account getExpert() {
        return expert;
    }

    public void setExpert(Account expert) {
        this.expert = expert;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
