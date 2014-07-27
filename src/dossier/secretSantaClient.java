/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dossier;

/**
 *
  * @author Shawn Deol
 * Date: Saturday, March 30
 * School: Robert Bateman High School
 * Computer used: Windows 7 pc, 84GB RAM, 1 TB HDD,  Intel I7~Q70
 * IDE used: netbeans 7.0.1
 * Created on Mar 28, 2012, 12:28:17 AM
 */
public class secretSantaClient {

    /**
     * @param args the command line arguments
     */
    //Runs Main Menu and starts program
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            //Run Main Menu
            public void run() {
                new MainMenu().setVisible(false);
            }
        });
    }
}
