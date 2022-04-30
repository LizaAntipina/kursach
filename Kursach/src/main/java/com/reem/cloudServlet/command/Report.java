package com.reem.cloudServlet.command;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.reem.cloudServlet.calculator.MethodCalculator;
import com.reem.cloudServlet.entities.MapKey;
import com.reem.cloudServlet.entities.MethodContent;
import com.reem.cloudServlet.entities.Task;
import com.reem.cloudServlet.exception.ServiceException;
import com.reem.cloudServlet.service.MapUtil;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.*;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Report implements Command {
    @Override
    public Page execute(HttpServletRequest req) throws ServiceException {
        try {
            List<MethodContent> contents = (List<MethodContent>) req.getSession().getAttribute("dataTasks");
            MethodContent bestTask = (MethodContent) req.getSession().getAttribute("bestP");

            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet spreadsheet = workbook.createSheet(" Tasks info ");
            XSSFRow row;

            Map<String, Object[]> empinfo = new TreeMap<String, Object[]>();
            empinfo.put("1", new Object[]{"Наименование", "Веса целей"});

            int i = 2;
            for (MethodContent d : contents) {
                empinfo.put(String.valueOf(i++), new Object[]{d.getName(), String.valueOf(d.getValue())});
            }

            empinfo.put(String.valueOf(i), new Object[]{"Наиболее выгодное предложение для реализации : ", bestTask.getName()});

            Set<String> keyid = empinfo.keySet();
            int rowid = 0;

            for (String key : keyid) {
                row = spreadsheet.createRow(rowid++);
                Object[] objectArr = empinfo.get(key);
                int cellid = 0;

                for (Object obj : objectArr) {
                    Cell cell = row.createCell(cellid++);
                    cell.setCellValue(String.valueOf(obj));
                }
            }
            FileOutputStream out = new FileOutputStream("C:/Users/Енот/Desktop/Kursach/tasks.xlsx");
            workbook.write(out);
            out.close();
            System.out.println("tasks.xlsx written successfully");
        } catch (FileNotFoundException e) {
            throw new ServiceException("error during pasing ");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Page("/home.jsp", true, "create_table.docx written successully !");
    }
}
