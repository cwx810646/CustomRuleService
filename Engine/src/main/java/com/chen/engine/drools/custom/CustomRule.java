package com.chen.engine.drools.custom;

import java.util.List;

import lombok.Data;

@Data
public class CustomRule {
    private String name; 
    private List<CustomCondtion> condtions;
    private List<CustomExecutor> executors;
}
