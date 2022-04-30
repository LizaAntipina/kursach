package com.reem.cloudServlet.service;

import com.reem.cloudServlet.entities.MapKey;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class ValueComparator implements Comparator<Map.Entry<MapKey, List<Integer>>> {

    public int compare(Map.Entry<MapKey, List<Integer>> a, Map.Entry<MapKey, List<Integer>> b) {
       return a.getKey().getTask().getName().compareTo(b.getKey().getTask().getName());
    }
}