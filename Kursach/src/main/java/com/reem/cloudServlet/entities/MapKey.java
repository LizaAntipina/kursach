package com.reem.cloudServlet.entities;

import java.util.Objects;

public class MapKey {
    private Task task;
    private Account expert;

    public MapKey(Task task, Account expert) {
        this.task = task;
        this.expert = expert;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Account getExpert() {
        return expert;
    }

    public void setExpert(Account expert) {
        this.expert = expert;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MapKey mapKey = (MapKey) o;
        return Objects.equals(expert.getLogin(), mapKey.expert.getLogin());
    }

    @Override
    public int hashCode() {
        return Objects.hash(expert.getLogin());
    }
}
