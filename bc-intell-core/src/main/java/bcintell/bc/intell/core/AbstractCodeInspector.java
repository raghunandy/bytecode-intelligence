/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bcintell.bc.intell.core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.bcel.classfile.ClassParser;
import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.classfile.Method;

/**
 *
 * @author Raghu
 */
public abstract class AbstractCodeInspector {
    
    public abstract List<String> getLines(String absPathOfClass)throws IOException;
}
