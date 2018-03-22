/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import vue.vuePrincipale;
import vue.vueVoirRepresentation;

/**
 *
 * @author Willy
 */
public class CtrlMenuPrincipal implements WindowListener, ActionListener{
     private vuePrincipale vue;
     private vueVoirRepresentation vue2;
     
     
     public CtrlMenuPrincipal(vuePrincipale vue) {
        
        this.vue = vue;
        // le contrôleur écoute la vue
        this.vue.addWindowListener(this);
        this.vue.getjButton1().addActionListener(this);
       
    }

    public vuePrincipale getVue() {
        return vue;
    }

    public void setVue(vuePrincipale vue) {
        this.vue = vue;
    }
     
     

    @Override
    public void windowOpened(WindowEvent we) {
       
    }

    @Override
    public void windowClosing(WindowEvent we) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosed(WindowEvent we) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowIconified(WindowEvent we) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeiconified(WindowEvent we) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowActivated(WindowEvent we) {
   
    }

    @Override
    public void windowDeactivated(WindowEvent we) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(this.vue.getjButton1())){
            new vueVoirRepresentation().setVisible(true);
            new CtrlLesRepresentations(vue2).getVue();
        }
        
    
    
    }
}
