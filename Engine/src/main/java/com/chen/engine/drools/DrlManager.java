package com.chen.engine.drools;

import java.io.StringReader;

import org.drools.compiler.compiler.DrlParser;
import org.drools.compiler.compiler.DroolsParserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chen.engine.drools.custom.CustomFile;

public class DrlManager {
	private Logger log = LoggerFactory.getLogger(DrlManager.class);
	
	private static String DSL_RULE = "";
	
    private static DrlManager instance = null;
    
    public static DrlManager getInstance() {
		 if (instance ==  null) {
			 instance = new DrlManager();
		}
		 return instance;
	}
    
    public String generateDrl(CustomFile file) throws DroolsParserException {
    	DslManager  dslManager = DslManager.getInstance();
    	String dsl = dslManager.generateDsl(file);
    	DrlParser drlParser = new DrlParser();
    	return drlParser.getExpandedDRL(dsl, new StringReader(DSL_RULE)); 
    }
}
