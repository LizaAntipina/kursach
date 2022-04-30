package com.reem.cloudServlet.command;

import com.reem.cloudServlet.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ShowModel implements Command {

    @Override
    public Page execute(HttpServletRequest req) throws ServiceException {
        HttpSession session = req.getSession();
        String className = (String) session.getAttribute("classModel");
        System.out.println(className);
        if (className != null){
            className = (className.equals("fade show")) ? "fade" : "fade show";
        }
        session.removeAttribute("classModel");
        session.setAttribute("classModel", className);
        System.out.println(className);
        return new Page("/home.jsp", true, "Success!");
    }

}
