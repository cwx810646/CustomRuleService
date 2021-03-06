package com.chen.engine.drools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DslManager {
	private Logger log = LoggerFactory.getLogger(DslManager.class);
	
    private static DslManager instance = null;
    
    public static DslManager getInstance() {
		 if (instance ==  null) {
			 instance = new DslManager();
		}
		 return instance;
	}
    
    public void generateDsl() {
		
	}
}
