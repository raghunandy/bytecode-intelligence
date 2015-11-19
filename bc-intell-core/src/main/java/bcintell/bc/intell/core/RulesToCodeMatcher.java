/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bcintell.bc.intell.core;

import bcintell.disct.ReportDictionary;
import bcintell.disct.ReportDictionary.FootPrint;
import bcintell.disct.RuleDictionary;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Raghu
 */
public class RulesToCodeMatcher {

     public static RulesToCodeMatcher instance;
    public static RulesToCodeMatcher instance(){
        if(instance==null){
            instance=new RulesToCodeMatcher();
        }
        return instance;
    }

    private  RulesToCodeMatcher() {
    }
    
    
    
    public ReportDictionary matchWithAllRules(String absClassPath, List<String> byteCodeLines) throws IOException {

        RuleDictionary ruleDictionary = RuleDictionary.instace();

        ruleDictionary.ruleMap.forEach((ruleType, ruleList) -> {
            ruleList.forEach((rule) -> {
                final FootPrint footPrint = new ReportDictionary.FootPrint();
                footPrint.setFileNameAndLocation(new File(absClassPath).getName());
                byteCodeLines.forEach((line) -> {
                    boolean check = isRuleMatchExists(rule, line);
                    if (check) {
                        footPrint.increment();
                    }
                });

//                bcelLines.forEach((line) -> {
//                    boolean check = isRuleMatchExists(rule, line);
//                    if (check) {
//                        footPrint.increment();
//                    }
//                });
                submitFootPrint(rule,footPrint);
            });

        });
        return ReportDictionary.instance();
    }

    private boolean isRuleMatchExists(RuleDictionary.Rule rule, String line) {
        boolean matchFound = false;
        if(rule.getParserType()==RuleDictionary.Parser.CLASS){
            for (String col : rule.getRuleDefs()) {
                matchFound=line.contains(col);
                if(matchFound){
                    break;
                }
            }
        }
        return matchFound;
    }
    private void submitFootPrint(RuleDictionary.Rule rule,FootPrint footPrint){
        if(footPrint.getNumberOfOccurences()!=0){
            ReportDictionary.instance().attachNewFootPrint(rule, footPrint);
        }
    }
}
