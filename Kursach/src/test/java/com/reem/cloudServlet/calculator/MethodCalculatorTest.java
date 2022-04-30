package com.reem.cloudServlet.calculator;

import com.reem.cloudServlet.entities.Account;
import com.reem.cloudServlet.entities.MapKey;
import com.reem.cloudServlet.entities.MethodContent;
import com.reem.cloudServlet.entities.Task;
import com.reem.cloudServlet.service.ValueComparator;
import org.checkerframework.checker.units.qual.A;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class MethodCalculatorTest {

    @Test
    public void getDataTableResult() {
        List<MethodContent> expected = new ArrayList<>();
        expected.add(new MethodContent("task-1",0.24));
        expected.add(new MethodContent("task-2",0.173));
        expected.add(new MethodContent("task-3",0.254));
        expected.add(new MethodContent("task-4",0.094));
        expected.add(new MethodContent("task-5",0.08));
        expected.add(new MethodContent("task-6",0.16));
        List<Task> taskData = new ArrayList<>();
        Task task1 = new Task(1,"task-1",0);
        Task task2 = new Task(1,"task-2",0);
        Task task3 = new Task(1,"task-3",0);
        Task task4 = new Task(1,"task-4",0);
        Task task5 = new Task(1,"task-5",0);
        Task task6 = new Task(1,"task-6",0);


        Account expert = new Account();
        expert.setLogin("login");
        Account expert1 = new Account();
        expert1.setLogin("login1");
        List<Integer> marks = Arrays.asList(10,7,9,3,4,5);
        List<Integer> marks1 = Arrays.asList(8,6,10,4,2,7);
        taskData.add(task1);
        taskData.add(task2);
        taskData.add(task3);
        taskData.add(task4);
        taskData.add(task5);
        taskData.add(task6);
        Map<MapKey, List<Integer>> data = new HashMap<>();
        data.put(new MapKey(task1,expert),marks);
        data.put(new MapKey(task2,expert1),marks1);

        MethodCalculator calculator = new MethodCalculator();
        List<MethodContent> actually = calculator.getDataTableResult(data,taskData);
        assertEquals(expected.get(0), actually.get(0));
        assertEquals(expected.get(1), actually.get(1));
        assertEquals(expected.get(2), actually.get(2));
        assertEquals(expected.get(3), actually.get(3));
        assertEquals(expected.get(4), actually.get(4));
        assertEquals(expected.get(5), actually.get(5));

    }

    @Test
    public void getBestResultResult() {
        List<MethodContent> data = new ArrayList<>();
        data.add(new MethodContent("task-1",0.3889));
        MethodContent expected = new MethodContent("task-2", 0.6111);
        data.add(expected);

        MethodCalculator calculator = new MethodCalculator();
        MethodContent actually = calculator.getBestTask(data);
        assertEquals(expected, actually);
    }
}