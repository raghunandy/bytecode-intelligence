/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bcintell.disct;

import bcintell.disct.RuleDictionary.Rule;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *
 * @author Raghu
 */
public class ReportDictionary {

    public class FootPrint {

        private String fileNameAndLocation;

        private int numberOfOccurences;

        public String getFileNameAndLocation() {
            return fileNameAndLocation;
        }

        public void setFileNameAndLocation(String fileNameAndLocation) {
            this.fileNameAndLocation = fileNameAndLocation;
        }

        public int getNumberOfOccurences() {
            return numberOfOccurences;
        }

        public void setNumberOfOccurences(int numberOfOccurences) {
            this.numberOfOccurences = numberOfOccurences;
        }

    }
    public Map<Rule, List<FootPrint>> reportMap = new HashMap<>();

    public Map<Rule, List<FootPrint>> getReportMap() {
        return reportMap;
    }

    public void setReportMap(Map<Rule, List<FootPrint>> reportMap) {
        this.reportMap = reportMap;
    }

    public void attachNewFootPrint(Rule rule, FootPrint fp) {
        List<FootPrint> footPrintList = reportMap.get(rule);
        if (footPrintList == null) {
            footPrintList = new ArrayList<>();
            reportMap.put(rule, footPrintList);
        }
        footPrintList.add(fp);
    }

}
