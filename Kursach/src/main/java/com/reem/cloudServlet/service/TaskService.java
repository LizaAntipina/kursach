package com.reem.cloudServlet.service;

import com.reem.cloudServlet.dao.DaoTask;
import com.reem.cloudServlet.entities.Account;
import com.reem.cloudServlet.entities.Mark;
import com.reem.cloudServlet.entities.Task;
import com.reem.cloudServlet.exception.DaoException;
import com.reem.cloudServlet.exception.ServiceException;

import java.util.List;

public class TaskService {
    private final DaoTask dao = new DaoTask();

    public Task add(Task task) throws ServiceException {
        try {
            dao.addTask(task);
        } catch (DaoException e) {
            throw new ServiceException("No Task has added", e);
        }
        return task;
    }

    public Task read(int id) throws ServiceException {
        try {
            return dao.readTask(id);
        } catch (DaoException e) {
            throw new ServiceException("No task exist", e);
        }
    }

    public void addMark(Mark mark) throws ServiceException {
        try {
            Mark mrk = dao.markExist(mark.getTask().getId(),mark.getExpert().getId());
            if (mrk != null){
                mrk.setMark(mark.getMark());
                dao.updateMark(mrk);
                return;
            }
            dao.addMark(mark);
        } catch (DaoException e) {
            throw new ServiceException("No task exist", e);
        }
    }


    public void delete(int id) throws ServiceException {
        try {
            dao.deleteTaskById(id);
        } catch (DaoException e) {
            throw new ServiceException("No task exist", e);
        }
        }

    public Task update(Task task) throws ServiceException {
        try {
            return dao.updateTask(task);
        } catch (DaoException e) {
            throw new ServiceException("No task exist", e);
        }
    }


    public List<Task> readAllTasks() throws ServiceException {
        try {
            return dao.readAllTask();
        } catch (DaoException e) {
            throw new ServiceException("No task exist", e);
        }
    }

    public List<Task> readAllTasksFor() throws ServiceException {
        try {
            return dao.readAllTask();
        } catch (DaoException e) {
            throw new ServiceException("No task exist", e);
        }
    }

}
