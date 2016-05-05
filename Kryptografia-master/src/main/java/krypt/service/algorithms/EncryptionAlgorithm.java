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
public interface EncryptionAlgorithm {
    
    public List encrypt(List allLines);
    public List decrypt(List allLines);
    
}
