/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bcintell.analyzer;

import bcintell.bc.intell.core.BCELCodeInspector;
import bcintell.bc.intell.core.ByteCodeInspector;
import bcintell.bc.intell.core.RulesToCodeMatcher;
import bcintell.disct.ReportDictionary;
import java.io.File;

import java.io.IOException;
import bcintell.extractjar.ExtractJar;
import bcintell.unziputility.UnzipUtility;
import com.google.gson.Gson;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jd.core.Decompiler;
import jd.core.DecompilerException;
import jd.ide.intellij.JavaDecompiler;

/**
 * check if extracted file is a class file if it is a class file, submit to
 * BCELInspector for inspection
 *
 * @author Piya
 */
public class PackageAnalyzer {

    public static void analysisOfJavaFiles(File dir) {
        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                analysisOfJavaFiles(file);
            } else {
                if (file.getName().endsWith(".java") == true) {
                    try {
                        //List<String> l1 = BCELCodeInspector.instace().getLines(file.getAbsolutePath());
                        List<String> l2 = ByteCodeInspector.instace().getLines(file.getAbsolutePath());
                        
                        
                        ReportDictionary report = RulesToCodeMatcher.instance().matchWithAllRules(file.getAbsolutePath(), l2);

                    } catch (IOException ex) {
                        Logger.getLogger(PackageAnalyzer.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }
        }

    }

    public static String packageAnalyzer(String jarFile) throws IOException, DecompilerException {
        String zipFile=jarFile.replace(".jar", "");
        Decompiler jd=new Decompiler();
        jd.decompile(jarFile,zipFile);
        
//        String path = UnzipUtility.unzip(zipFile);
        File currentDir = new File(zipFile); // current directory
        System.out.print(currentDir);
        analysisOfJavaFiles(currentDir);
        System.out.println("Report:");

        System.out.println("Report:" + new Gson().toJsonTree(ReportDictionary.instance()));
        return zipFile;

    }
}
