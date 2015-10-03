package bcintell.analyzer;

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
        Method[] al=jc.getMethods();
        System.out.println(Arrays.asList(al));
        
    }
    public static void main(String[] args) throws IOException {
        inspectMethods("D:\\TTU\\bytecode-intelligence\\bc-intell-package-analyzer\\inputs\\EmailSenderFacade.class");
    }
}
