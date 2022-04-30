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

public class GraphData implements Command{


    @Override
    public Page execute(HttpServletRequest req) throws ServiceException {
        new TaskCommandReadDataTable().execute(req);
        HashMap<MapKey, List<Integer>> data = (HashMap<MapKey, List<Integer>>)req.getSession().getAttribute("marks");
        Map<MapKey, List<Integer>> sorted = MapUtil.sortByValue(data);
        List<Task> tasks =  (List<Task>)req.getSession().getAttribute("tasks");
        MethodCalculator calculator = new MethodCalculator();
        List<MethodContent> contents = calculator.getDataTableResult(sorted,tasks);
        for (MethodContent mc : contents) {
            Task task = tasks.stream().filter(t -> t.getName().equals(mc.getName())).findFirst().orElse(new Task());
            mc.setCost(task.getCost());
        }
        req.getSession().setAttribute("dataTasks",contents);
        System.out.println(contents);
        return new Page("/graf.jsp",true,"success !");
    }
}
