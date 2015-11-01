package bcintell.bc.intell.core;

import bcintell.disct.RuleDictionary;
import java.io.IOException;
import java.util.Arrays;

import org.apache.bcel.classfile.ClassParser;
import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.classfile.Method;

public class BCELInspector{

    private static BCELInspector bcelInspector;

    private BCELInspector() {
    }
    public static BCELInspector instace(){
        if(bcelInspector==null){
            bcelInspector=new BCELInspector();
        }
        return bcelInspector;
    }
    
    
    public  void inspect(String absPathOfClass) throws IOException{
        ClassParser p=new ClassParser(absPathOfClass);
        JavaClass jc=p.parse();
        String s= p.parse().toString();
        Method[] al=jc.getMethods();
        
        RuleDictionary ruleDictionary= RuleDictionary.instace();
        
        ruleDictionary.ruleMap.forEach((ruleType,ruleList)->{
                ruleList.forEach( (rule)->{
                        System.out.println("Rule:"+rule.toString());
                });
        });
        
        System.out.println(Arrays.asList(al));
        System.out.println(s);
        
      
        
        //Adding comment just to check
    }
   /* public static void main(String[] args) throws IOException {
        inspectMethods("E:\\MS SE\\Fall 2015\\Software Verification & Validation\\bytecode-intelligence\\bc-intell-package-analyzer\\ExtractedJars\\BEProjectLibraries_Latest\\Classifiers\\NaiveBayesian.class");
    }*/
    
}
    