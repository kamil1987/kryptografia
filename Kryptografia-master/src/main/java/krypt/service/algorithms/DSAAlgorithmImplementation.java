/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package krypt.service.algorithms;

import java.util.List;

/**
 *
 * @author glabg
 */
public class DSAAlgorithmImplementation implements EncryptionAlgorithm{

    public DSAAlgorithmImplementation(){
    
    }
    
    @Override
    public List encrypt(List allLines) {
        return allLines;
    }

    @Override
    public List decrypt(List allLines) {
        return allLines;
    }
    
}
