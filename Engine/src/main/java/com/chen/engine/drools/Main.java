package com.chen.engine.drools;

import com.alibaba.fastjson.JSON;
import com.chen.engine.drools.custom.CustomFile;

public class Main {
	
	
	public static void main(String[] args) {
		String in = replaceAlRegex(getRule(), "\n|\r|\\s", "");
		CustomFile customFile = JSON.parseObject(in, CustomFile.class); 
		DslManager dslManager = DslManager.getInstance();
	 	String dsl = dslManager.generateDsl(customFile);
	    System.out.println(dsl);
	}

	public static String replaceAlRegex(String in, String regex, String replaceent) {
		return in.replaceAll(regex, replaceent);
	}

	public static String getRule() {
     return "{"
     		+ "	\"datas\": [\r\n"
     		+ "		[\r\n"
     		+ "			\"10000\",\r\n"
     		+ "			55,\r\n"
     		+ "			66,\r\n"
     		+ "			77\r\n"
     		+ "		],\r\n"
     		+ "		[\r\n"
     		+ "			\"10001\",\r\n"
     		+ "			66,\r\n"
     		+ "			77,\r\n"
     		+ "			88\r\n"
     		+ "		],\r\n"
     		+ "		[\r\n"
     		+ "			\"10002\",\r\n"
     		+ "			53,\r\n"
     		+ "			33,\r\n"
     		+ "			99\r\n"
     		+ "		]\r\n"
     		+ "	],\r\n"
     		+ "	\"columns\": [\r\n"
     		+ "		{\r\n"
     		+ "			\"name\": \"id\",\r\n"
     		+ "			\"type\": \"String\"\r\n"
     		+ "		},\r\n"
     		+ "		{\r\n"
     		+ "			\"name\": \"yuwen\",\r\n"
     		+ "			\"type\": \"Integer\"\r\n"
     		+ "		},\r\n"
     		+ "		{\r\n"
     		+ "			\"name\": \"shuxue\",\r\n"
     		+ "			\"type\": \"Integer\"\r\n"
     		+ "		},\r\n"
     		+ "		{\r\n"
     		+ "			\"name\": \"yingyu\",\r\n"
     		+ "			\"type\": \"Integer\"\r\n"
     		+ "		}\r\n"
     		+ "	],\r\n"
     		+ "	\"rules\": [\r\n"
     		+ "		{\r\n"
     		+ "			\"name\": \"PassAdmit\",\r\n"
     		+ "			\"condtions\": [\r\n"
     		+ "				{\r\n"
     		+ "					\"left\": \"yuwen\",\r\n"
     		+ "					\"operator\": \">=\",\r\n"
     		+ "					\"right\": \"60\"\r\n"
     		+ "				},\r\n"
     		+ "				{\r\n"
     		+ "					\"left\": \"\",\r\n"
     		+ "					\"operator\": \"and\",\r\n"
     		+ "					\"right\": \"\"\r\n"
     		+ "				},\r\n"
     		+ "				{\r\n"
     		+ "					\"left\": \"shuexue\",\r\n"
     		+ "					\"operator\": \">=\",\r\n"
     		+ "					\"right\": \"60\"\r\n"
     		+ "				},\r\n"
     		+ "				{\r\n"
     		+ "					\"left\": \"\",\r\n"
     		+ "					\"operator\": \"and\",\r\n"
     		+ "					\"right\": \"\"\r\n"
     		+ "				},\r\n"
     		+ "				{\r\n"
     		+ "					\"left\": \"yingyu\",\r\n"
     		+ "					\"operator\": \">=\",\r\n"
     		+ "					\"right\": \"60\"\r\n"
     		+ "				}\r\n"
     		+ "			],\r\n"
     		+ "			\"executors\": [\r\n"
     		+ "				{\r\n"
     		+ "					\"name\": \"pass\",\r\n"
     		+ "					\"method\": \"add\",\r\n"
     		+ "					\"expression\": [\r\n"
     		+ "						{\r\n"
     		+ "							\"type\": \"input\",\r\n"
     		+ "							\"value\": \"通过\"\r\n"
     		+ "						}\r\n"
     		+ "					]\r\n"
     		+ "				}\r\n"
     		+ "			]\r\n"
     		+ "		}\r\n"
     		+ "	]\r\n"
     		+ "}"; 
	}

}
