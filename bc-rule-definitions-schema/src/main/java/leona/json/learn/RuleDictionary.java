/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leona.json.learn;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Deepti B
 */
enum RuleTypes {

    PERFORMANCE, SECURITY, MISC
}
enum Parser {
    CLASS, CODE
}

class Rule {

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

public class RuleDictionary {

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
