package com.reem.cloudServlet.command;

import javax.servlet.http.HttpServletRequest;

public class CommandFactory {
    public static Command getCommand(HttpServletRequest req){
        String command = req.getParameter("command");
        switch(command){
            case "register":
                return new AccountCommandRegister();
            case "login":
                return new AccountCommandLogin();
            case "addTask":
                return new TaskCommandAdd();
            case "readTask":
                return new TaskCommandRead();
            case "readAllTask":
                return new TaskCommandReadAllTask();
            case "updateTask":
                return new TaskCommandUpdate();
            case "deleteTask":
                return new TaskCommandDelete();
            case "updateMark":
                return new TaskCommandUpdateMark();
            case "showModel":
                return new ShowModel();
            case "updateProfile":
                return new AccountCommandUpdate();
            case "readAccounts":
                return new AccountCommandRead();
            case "updateRole":
                return new AccountCommandUpdateRole();
            case "deleteAccount":
                return new AccountCommandDelete();
            case "readDataTable":
                return new TaskCommandReadDataTable();
            case "getBestValue":
                return new GetBestValue();
            case "getDiagramData":
                return new DiagramData();
            case "getGraphData":
                return new GraphData();
            case "makeReport":
                return new Report();
            default:
                return null;
        }
    }
}