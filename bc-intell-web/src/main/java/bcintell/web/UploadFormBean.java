/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bcintell.web;

import java.io.IOException;
import java.util.Scanner;
import javax.servlet.http.Part;

/**
 * Learn: 
 * https://jsflive.wordpress.com/2013/04/23/jsf22-file-upload/
 *
 * @author Raghu
 */
public class UploadFormBean {

    private Part file;
    private String fileContent;

    public void upload() {
        try {
            fileContent = new Scanner(file.getInputStream())
                    .useDelimiter("\\A").next();
        } catch (IOException e) {
            // Error handling
        }
    }

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }
}
