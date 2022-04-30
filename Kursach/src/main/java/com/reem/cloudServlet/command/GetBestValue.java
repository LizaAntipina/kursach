package com.reem.cloudServlet.command;

import com.reem.cloudServlet.calculator.MethodCalculator;
import com.reem.cloudServlet.entities.MapKey;
import com.reem.cloudServlet.entities.MethodContent;
import com.reem.cloudServlet.entities.Task;
import com.reem.cloudServlet.exception.ServiceException;
import com.reem.cloudServlet.service.MapUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetBestValue implements Command{

    @Override
    public Page execute(HttpServletRequest req) throws ServiceException {
        HashMap<MapKey, List<Integer>> data = (HashMap<MapKey, List<Integer>>)req.getSession().getAttribute("marks");
        Map<MapKey, List<Integer>> sorted = MapUtil.sortByValue(data);
        List<Task> tasks =  (List<Task>)req.getSession().getAttribute("tasks");
        MethodCalculator calculator = new MethodCalculator();
        List<MethodContent> contents = calculator.getDataTableResult(sorted,tasks);
        System.out.println(contents);
        MethodContent bestTask = calculator.getBestTask(contents);
        req.getSession().setAttribute("dataTasks",contents);
        req.getSession().setAttribute("bestP",bestTask);
        return new Page("/result.jsp",true,"success !");
    }
}
