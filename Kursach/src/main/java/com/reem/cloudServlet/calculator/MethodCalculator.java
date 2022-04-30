package com.reem.cloudServlet.calculator;

import com.reem.cloudServlet.entities.MapKey;
import com.reem.cloudServlet.entities.MethodContent;
import com.reem.cloudServlet.entities.Task;
import com.reem.cloudServlet.service.MapUtil;

import java.text.DecimalFormat;
import java.util.*;

public class MethodCalculator {

    public List<MethodContent> getDataTableResult(Map<MapKey, List<Integer>> dataT, List<Task> tasks) {
        int taskSize = tasks.size();
        Map<MapKey, List<Integer>> data = MapUtil.sortByValue(dataT);
        DecimalFormat df = new DecimalFormat("#.###");
        List<MethodContent> res = new ArrayList<>();
        tasks.forEach(t -> {
            MethodContent methodContent = new MethodContent(t.getName());
            res.add(methodContent);
        });
        int k =0;
        double[][] datas = new double[data.size()][taskSize];
        for (Map.Entry<MapKey, List<Integer>> entry : data.entrySet()) {
            List<Integer> marks = entry.getValue();
            double sum = marks.stream().mapToDouble(i -> i).sum();
            for (int i = 0; i < marks.size(); i++) {
                double mark = marks.get(i) / sum;
                datas[k][i] = mark;
            }
            k++;
        }

        for (int i = 0; i < taskSize; i++) {
            double sum = 0;
            for (int j = 0; j < k ; j++) {
                sum += datas[j][i];
            }
            sum /=k;
            String format = df.format(sum);
            double replace = Double.parseDouble(format.replace(",", "."));
            res.get(i).setValue(replace);
        }
        System.out.println(res);
        return res;
    }

    public MethodContent getBestTask(List<MethodContent> list) {

        double min = list.get(0).getValue();
        MethodContent res = list.get(0);
        for (MethodContent mc : list) {
            if (mc.getValue() > min) {
                min = mc.getValue();
                res = mc;
            }
        }
        return res;
    }
}
