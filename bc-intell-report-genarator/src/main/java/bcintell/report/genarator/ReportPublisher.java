/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bcintell.report.genarator;

import bcintell.disct.ReportDictionary;
import bcintell.report.publishers.EmailSenderFacade;
import com.google.gson.Gson;


/**
 *
 * @author Raghu
 */
public class ReportPublisher {
    private static ReportPublisher instance;
    
    public static ReportPublisher instance(){
        if(instance==null){
            instance=new ReportPublisher();
        }
        return instance;
    }
    private ReportPublisher(){
        
    }

    public void submitForReport(ReportDictionary report, String ... deliveryEmails) {
         EmailSenderFacade.getInstance().sendEmail("Bytecode Intelligence Report",
                    ReportTemplate.getTemplateStringFor(report), deliveryEmails);   
    }
   
    
}
