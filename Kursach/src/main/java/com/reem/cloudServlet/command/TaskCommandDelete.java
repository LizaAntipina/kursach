package com.reem.cloudServlet.command;

import com.reem.cloudServlet.exception.ServiceException;
import com.reem.cloudServlet.service.TaskService;

import javax.servlet.http.HttpServletRequest;

public class TaskCommandDelete implements Command{
    private TaskService service= new TaskService();
    @Override
    public Page execute(HttpServletRequest req) throws ServiceException {
        int id= Integer.parseInt(req.getParameter("id"));
        service.delete(id);
        return new Page("/home.jsp",true,"success !");
    }

}
