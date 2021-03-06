package com.chen.engine.drools.custom;

import java.util.List;

import lombok.Data;

@Data
public class CustomExecutor {
	private String name;
	private String method;
	private List<CustomNode> expression;
}
