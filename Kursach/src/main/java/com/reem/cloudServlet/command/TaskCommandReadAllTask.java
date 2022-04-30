package com.reem.cloudServlet.command;
import com.reem.cloudServlet.entities.Task;
import com.reem.cloudServlet.exception.ServiceException;
import com.reem.cloudServlet.service.TaskService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class TaskCommandReadAllTask implements Command{
    private TaskService service = new TaskService();

    @Override
    public Page execute(HttpServletRequest req) throws ServiceException {

        List<Task> tasks = service.readAllTasksFor();
        req.getSession().setAttribute("tasks", tasks);

        return new Page("/tasks.jsp", true, "Success!");
    }
}
