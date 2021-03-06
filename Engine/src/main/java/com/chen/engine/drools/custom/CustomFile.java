package com.chen.engine.drools.custom;

import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class CustomFile {
    private List<List<Object>> datas;
    private List<Map<String, Object>> columns;
    private List<CustomRule> rules;
}
