package com.chen.engine.drools; 

import org.slf4j.Logger;
import org.slf4j.LoggerFactory; 
import com.chen.engine.drools.custom.CustomFile;

public class DslManager {
	private Logger log = LoggerFactory.getLogger(DslManager.class);
	
    private static DslManager instance = null;
    
    public static DslManager getInstance() {
		 if (instance ==  null) {
			 instance = new DslManager();
		}
		 return instance;
	}
    
    public String generateDsl(CustomFile file) { 
	    return null;
    } 
}
