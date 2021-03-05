package com.chen.engine.service; 

import java.util.List;
import java.util.Map; 

import com.chen.engine.entity.Parambean;

public interface RuleService {
     public List<Map<String, Object>> execute(Parambean param);
}
