/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package krypt.service;

import java.io.File;
import java.lang.reflect.Method;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import krypt.data.FileContainer;
import krypt.gui.MainWindow;
import krypt.service.algorithms.EncryptionAlgorithm;

/**
 *
 * @author glabg
 */
public class GUIHelper {

    private static final Class helperClass = GUIHelper.class;

    public static void actionLocator(String action, File file) {
        try {
            Method actionMethod = helperClass.getMethod(action, File.class);
            actionMethod.invoke(null, file);
        } catch (Exception ex) {
            Logger.getLogger(GUIHelper.class.getName()).log(Level.SEVERE, null, ex);
            MainWindow.showError(ex);
        }
    }

    public static void readAndEncrypt(File file) {
        List allLinesDecrypted = FileReader.readFileToStringList(file);
        FileContainer.getInstance().setAllLinesDecrypted(allLinesDecrypted);
        EncryptionAlgorithm implementation = getAlgorythmImplementationInstance();
        List allLinesEncrypted = implementation.encrypt(allLinesDecrypted);
        FileContainer.getInstance().setAllLinesEncrypted(allLinesEncrypted);
        MainWindow.getInstance().printFiles();
    }

    public static EncryptionAlgorithm getAlgorythmImplementationInstance() {
        EncryptionAlgorithm implementation = null;
        String pck = EncryptionAlgorithm.class.getPackage().getName();
        String algorithmName = MainWindow.getInstance().getSelectedRadio();
        System.out.println("TEST: " + algorithmName);
        try {
            Class<?> algorithm = Class.forName(pck + "." + algorithmName);
            System.out.println("TEST: " + algorithm.getName());
            implementation = (EncryptionAlgorithm) algorithm.newInstance();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GUIHelper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(GUIHelper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(GUIHelper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(GUIHelper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(GUIHelper.class.getName()).log(Level.SEVERE, null, ex);
        }

        return implementation;
    }

}
