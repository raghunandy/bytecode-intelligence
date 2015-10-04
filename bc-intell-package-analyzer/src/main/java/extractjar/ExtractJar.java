/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extractjar;

/**
 *
 * @author Piya
 */
public class ExtractJar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws java.io.IOException  { 
         // TODO code application logic here
        
    java.util.jar.JarFile jarfile = new java.util.jar.JarFile(new java.io.File("/Users/Piya/desktop/BEProjectLibraries_Latest.jar"));
    System.out.print("I am here\n");
    java.util.Enumeration<java.util.jar.JarEntry> enu= jarfile.entries();
    while(enu.hasMoreElements())
    {
        String destdir = "/Users/Piya/desktop";     //Desktop is my destination directory
        java.util.jar.JarEntry file = (java.util.jar.JarEntry) enu.nextElement();
        System.out.print("I am here\n");
    java.io.File f = new java.io.File(destdir + java.io.File.separator + file.getName());
    if (file.isDirectory()) { // if its a directory, create it
        f.mkdir();
        System.out.print("I am here");
        continue;
    }
    java.io.InputStream is = jarfile.getInputStream(file); // get the input stream
    java.io.FileOutputStream fos = new java.io.FileOutputStream(f);
    while (is.available() > 0) {  // write contents of 'is' to 'fos'
        fos.write(is.read());
    }
    fos.close();
    is.close();
}
        /*java.util.jar.JarEntry je = enu.nextElement();

        System.out.println(je.getName());

        java.io.File fl = new java.io.File(destdir, je.getName());
        if(!fl.exists())
        {
            fl.getParentFile().mkdirs();
            fl = new java.io.File(destdir, je.getName());
        }
        if(je.isDirectory())
        {
            continue;
        }
        java.io.InputStream is = jarfile.getInputStream(je);
        java.io.FileOutputStream fo = new java.io.FileOutputStream(fl);
        while(is.available()>0)
        {
            fo.write(is.read());
        }
        fo.close();
        is.close();
    }*/

  }

}
    

