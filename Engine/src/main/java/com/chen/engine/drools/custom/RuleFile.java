package com.chen.engine.drools.custom;

import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class RuleFile { 
    private List<Map<String, Object>> columnMap;
    private List<Rule> rules;
}
