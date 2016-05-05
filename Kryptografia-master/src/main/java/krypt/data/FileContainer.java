/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package krypt.data;

import java.util.List;

/**
 *
 * @author glabg
 */
public class FileContainer {

    public List getAllLinesEncrypted() {
        return allLinesEncrypted;
    }

    public void setAllLinesEncrypted(List allLinesEncrypted) {
        this.allLinesEncrypted = allLinesEncrypted;
    }

    public List getAllLinesDecrypted() {
        return allLinesDecrypted;
    }

    public void setAllLinesDecrypted(List allLinesDecrypted) {
        this.allLinesDecrypted = allLinesDecrypted;
    }
    
    private List allLinesEncrypted;
    private List allLinesDecrypted;
    
    private static FileContainer instance;
    
    private FileContainer(){
        
    }
    
    public static FileContainer getInstance(){
        if(instance == null){
            instance = new FileContainer();
        }
        return instance;
    }

    
}
