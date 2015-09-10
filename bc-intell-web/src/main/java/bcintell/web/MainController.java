/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bcintell.web;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Raghu
 */
@Named(value = "mainController")
@SessionScoped
public class MainController implements Serializable{
    
    private String subPageName="home";
    public String switchPage(String subPageName){
        this.subPageName=subPageName;
        return "";
    }

    public String getSubPageName() {
        return subPageName;
    }

    public void setSubPageName(String subPageName) {
        this.subPageName = subPageName;
    }
    
}
