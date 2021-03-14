package com.chen.engine.drools;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import com.chen.engine.drools.custom.CustomCondtion;
import com.chen.engine.drools.custom.CustomExecutor;
import com.chen.engine.drools.custom.CustomFile;
import com.chen.engine.drools.custom.CustomRule;

public class DslManager {
	private Logger log = LoggerFactory.getLogger(DslManager.class);

	private static String DSL_TEAMPLATE = 
			  "rule %s                 \r\n" 
	        + "when                    \r\n"
			+ "- %s                    \r\n" 
	        + "then                    \r\n" 
			+ "%s                      \r\n";

	private static DslManager instance = null;

	public static DslManager getInstance() {
		if (instance == null) {
			instance = new DslManager();
		}
		return instance;
	}

	public String generateDsl(CustomFile file) {
		if (file == null || CollectionUtils.isEmpty(file.getRules())) {
			return null;
		}

		StringBuffer sb = new StringBuffer();
		List<CustomRule> rules = file.getRules();
		rules.forEach(rule -> {
			sb.append(String.format(DSL_TEAMPLATE, rule.getName(), getConditions(rule.getCondtions()),
					getExecutors(rule.getExecutors())));
		});
		return sb.toString();
	}

	public String getConditions(List<CustomCondtion> condtions) {
		if (CollectionUtils.isEmpty(condtions)) {
			return "";
		}

		StringBuffer sb = new StringBuffer();
		condtions.forEach(condtion -> { 
			sb.append(String.format("%s %s %s", condtion.getLeft(), condtion.getOperator(), condtion.getRight()));
		});
		return sb.toString();
	}

	public String getExecutors(List<CustomExecutor> executors) {
		if (CollectionUtils.isEmpty(executors)) {
			return "";
		}

		StringBuffer sb = new StringBuffer();
		executors.forEach(executor -> {
			 
		});
		return sb.toString();
	}

}
