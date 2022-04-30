package com.reem.cloudServlet.command;

import com.reem.cloudServlet.exception.ServiceException;
import com.reem.cloudServlet.service.TaskService;
import com.reem.cloudServlet.entities.Task;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class TaskCommandUpdate implements Command {
    TaskService service = new TaskService();

    @Override
    public Page execute(HttpServletRequest req) throws ServiceException {
        int id = Integer.parseInt(req.getParameter("id"));
        List<Task> tasks = service.readAllTasks();
        Task task = tasks.stream().filter(t -> t.getId() == id).findFirst().orElse(new Task());
        task.setName(req.getParameter("name"));
        task.setCost(Integer.parseInt(req.getParameter("cost")));
        task = service.update(task);
        System.out.println(task);
        return new Page("/home.jsp", true, "success !");
    }
}
