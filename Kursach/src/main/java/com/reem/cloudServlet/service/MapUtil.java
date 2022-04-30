package com.reem.cloudServlet.service;

import com.reem.cloudServlet.entities.MapKey;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MapUtil {

    public static Map<MapKey, List<Integer>> sortByValue(Map<MapKey, List<Integer>> map) {
        List<Map.Entry<MapKey, List<Integer>>> list = new ArrayList<>(map.entrySet());
        list.sort(new ValueComparator());

        Map<MapKey, List<Integer>> result = new LinkedHashMap<>();
        for (Map.Entry<MapKey, List<Integer>> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }
}
