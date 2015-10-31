/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bcintell.extractjar;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author Piya
 */
public class ExtractJar {

    public static final String DEST_DIR = "extractedJars";

    public static String extractJar(String jarFile) throws IOException {
        // TODO code application logic here

        JarFile jarfile = new JarFile(new File(jarFile));
        Enumeration<JarEntry> enu = jarfile.entries();
        String name = "";
        String name1 = jarfile.getName();
        String jarname = FilenameUtils.getBaseName(name1);
        File destdir = new File(DEST_DIR + "/" + jarname);
        if (destdir.exists()) {
            FileUtils.deleteDirectory(destdir);
        }
        destdir.mkdirs();

        while (enu.hasMoreElements()) {

            JarEntry file = (JarEntry) enu.nextElement();
            File f = new File(destdir + "/" + file.getName());
            name = file.getName();

            if (file.isDirectory()) { // if its a directory, create it
                f.mkdir();
                continue;
            }
            
            InputStream is = jarfile.getInputStream(file); // get the input stream
            FileOutputStream fos = new FileOutputStream(f);
            while (is.available() > 0) {  // write contents of 'is' to 'fos'
                fos.write(is.read());
            }
            fos.close();
            is.close();
            //System.out.println(f.getAbsolutePath());
//            if (f.getName().endsWith(".class") == true) {   //check if extracted file is a class file
//               BCELUtil.inspectMethods(f.getAbsolutePath());   //if it is a class file, submit to BCELUtil for inspection
//            }
        }
        jarfile.close();
        return destdir.getAbsolutePath();
    }

}
