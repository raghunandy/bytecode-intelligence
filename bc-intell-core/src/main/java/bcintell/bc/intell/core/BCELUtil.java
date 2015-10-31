package bcintell.bc.intell.core;

import java.io.IOException;
import java.util.Arrays;

import org.apache.bcel.classfile.ClassParser;
import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.classfile.Method;

public class BCELUtil {

    /**
     * [public static bcintell.report.publishers.EmailSenderFacade getInstance(), public void <init>(), 
     * public transient boolean sendEmail(String subject, String message, String[] toAddresses)]
     * @param absPathOfClass
     * @throws IOException 
     */
    public static void inspectMethods(String absPathOfClass) throws IOException{
        ClassParser p=new ClassParser(absPathOfClass);
        JavaClass jc=p.parse();
        String s= p.parse().toString();
        Method[] al=jc.getMethods();
        //System.out.println(Arrays.asList(al));
        System.out.println(s);
        
    }
   /* public static void main(String[] args) throws IOException {
        inspectMethods("E:\\MS SE\\Fall 2015\\Software Verification & Validation\\bytecode-intelligence\\bc-intell-package-analyzer\\ExtractedJars\\BEProjectLibraries_Latest\\Classifiers\\NaiveBayesian.class");
    }*/
    
}
