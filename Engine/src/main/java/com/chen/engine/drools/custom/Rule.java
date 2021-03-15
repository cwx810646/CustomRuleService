package com.chen.engine.drools.custom;

import java.util.List;

import lombok.Data;

@Data
public class Rule {
    private String name; 
    private Node condtion;
    private List<Executor> executors;
}
