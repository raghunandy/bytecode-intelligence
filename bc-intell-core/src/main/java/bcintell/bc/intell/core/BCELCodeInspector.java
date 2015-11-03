package bcintell.bc.intell.core;

import bcintell.disct.RuleDictionary;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.bcel.classfile.ClassParser;
import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.classfile.Method;

public class BCELCodeInspector extends AbstractCodeInspector{

    private static BCELCodeInspector bcelInspector;

    private BCELCodeInspector() {
    }
    public static BCELCodeInspector instace(){
        if(bcelInspector==null){
            bcelInspector=new BCELCodeInspector();
        }
        return bcelInspector;
    }
    
    
    public  List<String> getLines(String absPathOfClass) throws IOException{
        
         List<String> lines=new ArrayList<>();
        ClassParser p=new ClassParser(absPathOfClass);
        JavaClass jc=p.parse();
        String s= p.parse().toString();
        Method[] al=jc.getMethods();
        for (Method m : al) {
            lines.add(m.toString());
        }
        
        return lines;
    }

    
}
    