package com.chen.engine.drools.custom;

import java.util.List;

import lombok.Data;

@Data
public class Node {
   private String type;
   private String value;
   private List<Node> elementss; 
}
