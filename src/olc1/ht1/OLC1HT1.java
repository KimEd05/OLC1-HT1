/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olc1.ht1;

import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import olc1.vista.Principal;

/**
 *
 * @author Kimberly Elias
 */
public class OLC1HT1 {

    /**
     * @param args the command line arguments
     */
    public static String error = "";
    
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
            setFuenteUI(new javax.swing.plaf.FontUIResource("Museo Sans For Dell", Font.PLAIN, 12));
            Principal ventana = new Principal();
            ventana.show();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
            System.out.println("Error en la librería de diseño");
            System.out.println(e);
        }
        
    }

    public static void setFuenteUI(javax.swing.plaf.FontUIResource f) {
        java.util.Enumeration llaves = UIManager.getDefaults().keys();
        while (llaves.hasMoreElements()) {
            Object llave = llaves.nextElement();
            Object valor = UIManager.get(llave);
            if (valor instanceof javax.swing.plaf.FontUIResource) {
                UIManager.put(llave, f);
            }
        }
    }
    
}
