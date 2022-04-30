package com.reem.cloudServlet.command;

import com.reem.cloudServlet.exception.ServiceException;
import com.reem.cloudServlet.service.TaskService;
import com.reem.cloudServlet.entities.Task;
import javax.servlet.http.HttpServletRequest;

public class TaskCommandAdd implements Command{
 private TaskService service= new TaskService();
    @Override
    public Page execute(HttpServletRequest req) throws ServiceException {
        Task task= new Task();
        //task.setId(Integer.parseInt("id"));
        task.setName(req.getParameter("name"));
        task.setCost(Integer.parseInt(req.getParameter("cost")));
        task = service.add(task);
        System.out.print(task);
        return new Page("/home.jsp",true,"success !");
    }
}
