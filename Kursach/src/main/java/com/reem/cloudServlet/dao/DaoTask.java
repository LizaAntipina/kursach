package com.reem.cloudServlet.dao;
import com.reem.cloudServlet.entities.Account;
import com.reem.cloudServlet.entities.Mark;
import com.reem.cloudServlet.entities.Task;
import com.reem.cloudServlet.exception.DaoException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoTask implements Dao {
    public void addTask(Task task) throws DaoException {
        String sql = "INSERT INTO task (name,cost) VALUES (?,?)";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, task.getName());
            statement.setInt(2,task.getCost());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new Task was added successfully!");
            }
        } catch (SQLException e){
            throw new DaoException("Task Existed before",e);
        }

    }


    public void deleteTaskById(int id) throws DaoException {
        String sql = "UPDATE task SET status = 'DELETED' WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("No task exists", e);
        }
    }


    public Task updateTask(Task task)throws DaoException{
        String sql = "UPDATE task SET name = ? , cost = ? WHERE id = ?";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, task.getName());
            statement.setInt(2,task.getCost());
            statement.setInt(3,task.getId());
            statement.executeUpdate();
        } catch (SQLException e){
            throw new DaoException("No task exists",e);
        }
        return task;

    }

    public List<Task> readAllTaskForAdmin() throws DaoException {
        String sql = "select * from task where status <> 'DELETED'";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            List<Task> tasks = new ArrayList<>();
            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                int cost = result.getInt("cost");
                tasks.add(new Task(id, name, cost));
            }
            return tasks;
        } catch (SQLException e) {
            throw new DaoException("No task exists", e);
        }
    }


    public Task readTask(int id) throws DaoException{
        String sql = "select * from Task where id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            ResultSet result = statement.executeQuery();

            if (result.next()){
                Task task = new Task();
                String name = result.getString("name");
                int cost = result.getInt("cost");
                task.setId(id);
                task.setName(name);
                task.setCost(cost);
                task.setMarks(readAllMarkByTaskId(id));
                return task;
            }
        }catch (SQLException e){
            throw new DaoException("No task exists",e);
        }
        return null;

    }

    public List<Task> readAllTask() throws DaoException {
        String sql = "select * from task where status <> 'DELETED'";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            List<Task> tasks = new ArrayList<>();
            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                int cost = result.getInt("cost");
                List<Mark> marks = readAllMarkByTaskId(id);
                tasks.add(new Task(id, name, cost,marks));
            }
            return tasks;
        } catch (SQLException e) {
            throw new DaoException("No task exists", e);
        }
    }

    public List<Mark> readAllMarkByTaskId(int taskId) throws DaoException {
        String sql = "select * from mark where task_id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1,taskId);
            ResultSet result = statement.executeQuery();
            List<Mark> marks = new ArrayList<>();
            while (result.next()) {
                long id = result.getLong("id");
                Account expert = new Account(result.getInt("account_id"));
                int mark = result.getInt("mark");
                marks.add(new Mark(id,mark,expert,new Task(taskId)));
            }
            return marks;
        } catch (SQLException e) {
            throw new DaoException("task_id existed before", e);
        }
    }

    public void addMark(Mark mark) throws DaoException {
        String sql = "INSERT INTO mark (account_id, task_id, mark)VALUES (?,?,?)";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, mark.getExpert().getId());
            statement.setLong(2,mark.getTask().getId());
            statement.setInt(3,mark.getMark());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new Mark was added successfully!");
            }
        } catch (SQLException e){
            throw new DaoException("Task Existed before",e);
        }
    }

    public void updateMark(Mark mark) throws DaoException {
        String sql = "UPDATE public.mark SET mark = ? WHERE id = ?";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, mark.getMark());
            statement.setLong(2,mark.getId());
            statement.executeUpdate();
        } catch (SQLException e){
            throw new DaoException("Task Existed before",e);
        }
    }

    public Mark markExist(int taskId, int expertId) throws DaoException {
        String sql = "select * from mark where task_id = ? and account_id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1,taskId);
            statement.setLong(2,expertId);
            ResultSet result = statement.executeQuery();
             if (result.next()){
                 long id = result.getLong("id");
                 Account expert = new Account(result.getInt("account_id"));
                 int mark = result.getInt("mark");
                 return new Mark(id,mark,expert,new Task(taskId));
             }
             return null;
        } catch (SQLException e) {
            throw new DaoException("task_id existed before", e);
        }
    }

}
