package com.chen.engine.drools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DrlManager {
	private Logger log = LoggerFactory.getLogger(DrlManager.class);
	
    private static DrlManager instance = null;
    
    public static DrlManager getInstance() {
		 if (instance ==  null) {
			 instance = new DrlManager();
		}
		 return instance;
	}
    
    public void generateDsl() {
		
	}
}
