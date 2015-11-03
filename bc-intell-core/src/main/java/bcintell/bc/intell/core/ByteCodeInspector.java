/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bcintell.bc.intell.core;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Raghu
 */
public class ByteCodeInspector extends AbstractCodeInspector{
    
    private static ByteCodeInspector bcelInspector;

    private ByteCodeInspector() {
    }
    public static ByteCodeInspector instace(){
        if(bcelInspector==null){
            bcelInspector=new ByteCodeInspector();
        }
        return bcelInspector;
    }
    
    
    public  List<String> getLines(String absPathOfClass) throws IOException{
     
        List<String> lines=new ArrayList<>();
        Scanner s=new Scanner(new File(absPathOfClass));
        while(s.hasNext()){
            lines.add(s.nextLine());
        }
        return lines;
    }
}
