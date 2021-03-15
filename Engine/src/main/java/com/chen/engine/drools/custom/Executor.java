package com.chen.engine.drools.custom; 

import lombok.Data;

@Data
public class Executor {
	private String name;
	private String method;
	private Node content;
}
