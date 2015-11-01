/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bcintell.disct;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Deepti B
 */

public class RuleDictionary {
public static enum RuleTypes {

    PERFORMANCE, SECURITY, MISC
}
public static enum Parser {
    CLASS, CODE
}

public static class Rule {

    RuleTypes ruleType;
    String[] ruleTags;
    Parser parserType;
    String[] ruleDefs;

    public RuleTypes getRuleType() {
        return ruleType;
    }

    public void setRuleType(RuleTypes ruleType) {
        this.ruleType = ruleType;
    }

    public String[] getRuleTags() {
        return ruleTags;
    }

    public void setRuleTags(String[] ruleTags) {
        this.ruleTags = ruleTags;
    }

    public String[] getRuleDefs() {
        return ruleDefs;
    }

    public void setRuleDefs(String[] ruleDefs) {
        this.ruleDefs = ruleDefs;
    }

    public Parser getParserType() {
        return parserType;
    }

    public void setParserType(Parser parserType) {
        this.parserType = parserType;
    }

    
}

    private static RuleDictionary ruleDictionary;

    private RuleDictionary() {
        
    }
    private static RuleDictionary loadFromFile(String filePath) throws IOException{
        Gson gson = new Gson();
        

		BufferedReader br = new BufferedReader(
			new FileReader(filePath));

		//convert the json string back to object
		RuleDictionary obj = gson.fromJson(br, RuleDictionary.class);

		System.out.println(obj);
                return obj;
               
        
    }
    
    public static RuleDictionary instace() throws IOException{
        if(ruleDictionary==null){
           String current = new java.io.File( "." ).getCanonicalPath();
        System.out.println("Current dir:"+current);
            ruleDictionary=loadFromFile("../bc-rule-definitions-schema/dictionary.json");
        }
        return ruleDictionary;
    }
    
    public Map<RuleTypes, List<Rule>> ruleMap;

    public void createRuleDef(RuleTypes ruleType,  String[] ruleTag, Parser parserType, String ... ruleDef) {
        Rule newRule = new Rule();
        List ruleList = new ArrayList();
        newRule.setRuleType(ruleType);
        newRule.setRuleTags(ruleTag);
        newRule.setParserType(parserType);
        newRule.setRuleDefs(ruleDef);
        if (ruleMap.containsKey(ruleType)) {
            ruleList = ruleMap.get(ruleType);
            ruleList.add(newRule);
        }
        else
        {
            ruleList.add(newRule);
        }
        ruleMap.put(ruleType, ruleList);
    }

    public List getRuleDefs(RuleTypes type) {
        return ruleMap.get(type);
    }
}
