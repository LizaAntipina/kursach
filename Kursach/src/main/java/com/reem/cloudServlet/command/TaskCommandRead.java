package com.reem.cloudServlet.command;

import com.reem.cloudServlet.entities.Account;
import com.reem.cloudServlet.entities.Mark;
import com.reem.cloudServlet.exception.ServiceException;
import com.reem.cloudServlet.service.TaskService;
import com.reem.cloudServlet.entities.Task;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class TaskCommandRead implements Command{
private TaskService service= new TaskService();
    @Override
    public Page execute(HttpServletRequest req) throws ServiceException {
        Account expert = (Account) req.getSession().getAttribute("account");
        List<Task> tasks = service.readAllTasks();
        tasks.forEach(t->{
            List<Mark> marks = t.getMarks();
            int mark = marks
                    .stream()
                    .filter(m -> m.getExpert().getId() == expert.getId())
                    .findFirst()
                    .orElse(new Mark())
                    .getMark();
            t.setMark(mark);
        });
            req.getSession().setAttribute("tasks",tasks);
            System.out.println(tasks);
            return new Page("/tasksExpert.jsp", true, "Success!");
    }
}
