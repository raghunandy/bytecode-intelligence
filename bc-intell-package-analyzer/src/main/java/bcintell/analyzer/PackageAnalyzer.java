/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bcintell.analyzer;
 
import bcintell.bc.intell.core.BCELInspector;
import java.io.File;

import java.io.IOException;
import bcintell.extractjar.ExtractJar;

 
/**
 *
 * @author Piya
 */
public class PackageAnalyzer {
     
    public static void digFolderToFindClassFiles(File dir) {
        try {
                File[] files = dir.listFiles();
                for (File file : files) {
                        if (file.isDirectory()) {
//                                System.out.println("directory:" + file.getCanonicalPath());
                                digFolderToFindClassFiles(file);
                        } else {    
                            if (file.getName().endsWith(".class") == true) {   //check if extracted file is a class file
                                //System.out.println("file:" + file.getCanonicalPath());
                                BCELInspector.instace().inspect(file.getAbsolutePath());   //if it is a class file, submit to BCELInspector for inspection
                            }
                        }
                }
        } catch (IOException e) {
                e.printStackTrace();
        }
    }
    
    //Todo : packageAnalyzer = should be doPackageAnalsys
     
    public static String packageAnalyzer(String jarFile) throws IOException 
    {   
        //String jarFile = "../project-inception/target/project-inception-0.1.jar"; 
        String path = ExtractJar.extractJar(jarFile);
        File currentDir = new File(path); // current directory
        digFolderToFindClassFiles(currentDir);
        //System.out.println(path);
       //JarFile jarfile = new JarFile(new File(jarFile1));
       //File tempFolder= extractJar(jarFile);
        return path;
     
    }
}