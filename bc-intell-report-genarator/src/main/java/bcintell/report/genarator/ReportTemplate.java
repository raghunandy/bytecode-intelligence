/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bcintell.report.genarator;

import bcintell.disct.ReportDictionary;
import com.google.gson.Gson;

/**
 *
 * @author Raghu
 */
public class ReportTemplate {

    public static String getTemplateStringFor(ReportDictionary report) {
        return new Gson().toJsonTree(report).toString();
    }
    
}
