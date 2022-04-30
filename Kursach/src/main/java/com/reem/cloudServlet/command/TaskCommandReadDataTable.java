package com.reem.cloudServlet.command;

import com.reem.cloudServlet.entities.Account;
import com.reem.cloudServlet.entities.MapKey;
import com.reem.cloudServlet.entities.Mark;
import com.reem.cloudServlet.entities.Task;
import com.reem.cloudServlet.exception.ServiceException;
import com.reem.cloudServlet.service.AccountService;
import com.reem.cloudServlet.service.TaskService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskCommandReadDataTable implements Command {
    private TaskService service = new TaskService();
    private AccountService accountService = new AccountService();

    @Override
    public Page execute(HttpServletRequest req) throws ServiceException {
        Account account = (Account) req.getSession().getAttribute("account");
        if (account.getRole().equals("ADMIN")) {
            List<Task> tasks = service.readAllTasksFor();
            req.getSession().setAttribute("tasks", tasks);
            List<Account> exprts = accountService.readAllExpert();
            Map<MapKey, List<Integer>> marks = new HashMap<>();
            tasks.forEach(t -> {
                List<Mark> mrks = t.getMarks();
                for (Account ex : exprts) {
                    Mark mark = mrks
                            .stream()
                            .filter(m -> m.getExpert().getId() == ex.getId())
                            .findFirst()
                            .orElse(new Mark());
                    List<Integer> exMark = new ArrayList<>();
                    MapKey key = new MapKey(t,ex);
                    if (marks.containsKey(key)) {
                        exMark = marks.get(key);
                    }
                    exMark.add(mark.getMark());
                    marks.put(key, exMark);
                }
            });
            for (Map.Entry<MapKey, List<Integer>> entry : marks.entrySet()) {
                String tas = entry.getKey().getTask().getName();
                String exp = entry.getKey().getExpert().getLogin();
                List<Integer> value = entry.getValue();
                System.out.println("\ntask name => " + tas + "\ntask Expert => " + exp +"\n marks => " + value);
            }
            req.getSession().setAttribute("marks", marks);
        }
        return new Page("/method.jsp", true, "Success!");
    }
}
