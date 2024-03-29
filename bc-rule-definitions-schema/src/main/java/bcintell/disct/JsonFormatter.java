/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bcintell.disct;

import bcintell.disct.RuleDictionary.Parser;
import bcintell.disct.RuleDictionary.RuleTypes;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author Raghu
 */
public class JsonFormatter {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        /* CarBean cb=new CarBean();
         cb.setColor(111);
         cb.setManDate(new Date());
         cb.setModel("Maruthi");
         cb.setName("Yahoo");
        
         Gson gson=new Gson();
         JsonElement jsonElement=gson.toJsonTree(cb, CarBean.class);
         FileOutputStream fout=new FileOutputStream(new File("car.json"));
         fout.write(jsonElement.toString().getBytes());
        
         fout.close();*/

        RuleDictionary dictionary = RuleDictionary.instace();
        dictionary.ruleMap = new HashMap();
        dictionary.createRuleDef(RuleTypes.SECURITY,new String[] {"network"},Parser.CLASS, "HTTP","SSLSocket", "SaslClient", "SaslServer");
        dictionary.createRuleDef(RuleTypes.PERFORMANCE, new String[]{"time"},Parser.CODE, "System.out.println");

        
        Gson gson = new Gson();
        JsonElement myElement = gson.toJsonTree(dictionary, RuleDictionary.class);

        FileOutputStream fout = new FileOutputStream(new File("dictionary.json"));
        fout.write(myElement.toString().getBytes());

        fout.close();

    }
}
