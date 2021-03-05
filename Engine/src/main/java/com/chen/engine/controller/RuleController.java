package com.chen.engine.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RestController;

import com.chen.engine.entity.Parambean;
import com.chen.engine.service.RuleService;
import com.huawei.common.entity.Result;

@RestController
public class RuleController {
	@Autowired
	private RuleService ruleService;
	
	public Result<List<Map<String, Object>>> execute(Parambean param){
		List<Map<String, Object>> maps = ruleService.execute(param);
		if (CollectionUtils.isEmpty(maps)) {
			return Result.empty();
		} 
		return Result.ok(maps);
	}	
}
