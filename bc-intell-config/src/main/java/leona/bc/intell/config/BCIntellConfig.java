/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leona.bc.intell.config;

/**
 *
 * @author Raghu
 */
public class BCIntellConfig {

    private static BCIntellConfig i;
    public static BCIntellConfig getInstance() {
        if(i==null){
            i=new BCIntellConfig();
        }
        return i;
    }
    
}
