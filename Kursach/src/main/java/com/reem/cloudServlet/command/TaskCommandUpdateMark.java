package com.reem.cloudServlet.command;

import com.reem.cloudServlet.entities.Account;
import com.reem.cloudServlet.entities.Mark;
import com.reem.cloudServlet.exception.ServiceException;
import com.reem.cloudServlet.service.TaskService;
import com.reem.cloudServlet.entities.Task;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class TaskCommandUpdateMark implements Command{
    TaskService service = new TaskService();
    @Override
    public Page execute(HttpServletRequest req) throws ServiceException {
        Account expert = (Account) req.getSession().getAttribute("account");
        int taskId = Integer.parseInt(req.getParameter("taskId"));
        List<Task> tasks = (List<Task>) req.getSession().getAttribute("tasks");
        Task task = tasks.stream().filter(t-> t.getId() == taskId).findFirst().orElse(null);
        int mark = Integer.parseInt(req.getParameter("mark"));
        task.setMark(mark);
        Mark newMark = new Mark(mark,expert,task);
        task.addMark(new Mark());
        service.addMark(newMark);
        return new Page("/tasksExpert.jsp",true,"success !");
    }
}
