package com.chen.engine.drools;

import java.io.StringReader;
import java.util.Iterator;
import java.util.List;

import org.drools.compiler.compiler.DrlParser;
import org.drools.compiler.compiler.DroolsParserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils; 
import com.chen.engine.drools.custom.Executor;
import com.chen.engine.drools.custom.Node;
import com.chen.engine.drools.custom.Rule;
import com.chen.engine.drools.custom.RuleFile;

public class DrlManager {
	private Logger log = LoggerFactory.getLogger(DrlManager.class);
	
	private static String DRL_TEMPLATE
			= "rule %s                       /r/n"
			+ "when                          /r/n"
		    + "%s                            /r/n"
		    + "then                          /r/n"
		    + "%s                            /r/n"
		    + "end                           /r/n"
			;
	
    private static DrlManager instance = null;
    
    public static DrlManager getInstance() {
		 if (instance ==  null) {
			 instance = new DrlManager();
		}
		 return instance;
	}
    
    public String generateDrl(RuleFile file) { 
        if (file == null || CollectionUtils.isEmpty(file.getRules())) {
			return  null;
		}
        StringBuffer sb = new StringBuffer();
        List<Rule> rules = file.getRules(); 
        rules.forEach(rule -> {
        	 String condition = formatCondition(null, rule.getCondtion());
        	 String executor = formatExecutor(file, rule.getExecutors());
        	 sb.append(String.format(DRL_TEMPLATE, rule.getName(), String.format("$input: Map(%s)", condition), executor));
        });
        String drl = sb.toString();
        if (log.isDebugEnabled()) {
			log.debug("generate drl: \r\n%s", drl);
		} 
    	return drl;
    }
    
    
    public String formatCondition(Node parentNode, Node node){ 
    	if (node == null) {
		   return "";	
		}
    	List<Node> elements = node.getElementss();
    	if (CollectionUtils.isEmpty(elements)) {
			Object value = node.getValue();
			if (value instanceof Double || value instanceof Integer) {
				return value.toString();
			}else {
				return String.format("\"%s\"", value);
			}
		}else {
			StringBuffer sb = new StringBuffer();
			Integer size = elements.size();
			for (int i = 0; i < size; i++) {
				sb.append(formatCondition(node, elements.get(i)));
			    if (i < size - 1) {
			    	sb.append(node.getValue());
				}
			}
			return String.format("(%s)", sb.toString());
		} 
    }
    
    public String formatExecutor(final RuleFile file, List<Executor> executors){ 
    	Integer size = executors.size();
    	StringBuffer sb = new StringBuffer();
    	for (int i = 0; i < size; i++) {
    		 Executor executor = executors.get(i);
    		 if (executor.getMethod().equals("delete")) {
				  sb.append(String.format("$input.remove(%s)", executor.getName()));
			 }else{
				 
			 }
    		 if (i < size - 1) {
				sb.append("\r\n");
			}
		}  
    	return sb.toString();
    }
    
    public String formatContent(final RuleFile file, Node parentNode, Node node) {
    	if (node == null) {
			return "";
		}
    	List<Node> elements = node.getElementss();
    	if (CollectionUtils.isEmpty(elements)) { 
    		return "";
		}else {
			return "";
		}  
    }
}
