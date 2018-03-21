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
import javax.swing.JOptionPane;
import vue.vuePrincipale;
import vue.vueVoirRepresentation;

/**
 *
 * @author Willy
 */
public class CtrlPrincipal implements WindowListener, ActionListener{
    private vuePrincipale vue;
    private vueVoirRepresentation vue2;
    private CtrlLesRepresentations ctrlRepresentation;
    private CtrlLesReservations ctrlReservations;
    public CtrlPrincipal(vuePrincipale vue){
        this.vue = vue;
        this.vue.addWindowListener(this);
        this.vue.getjButton1().addActionListener(this);
        
    }
    public void afficherLesRepresentions(){
        this.ctrlRepresentation.getVue().setVisible(true);
        this.ctrlReservations.getVue().setVisible(false);
    }
    
    public void afficherLesReservations(){
        this.ctrlRepresentation.getVue().setVisible(false);
        this.ctrlReservations.getVue().setVisible(true);
    }

    public void quitterApplication(){       
        // Confirmer avant de quitter
        int rep = JOptionPane.showConfirmDialog(null, "Quitter l'application\nEtes-vous sûr(e) ?", "Representation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (rep == JOptionPane.YES_OPTION) {
            // mettre fin à l'application
            System.exit(0);
        }
    }

    public CtrlLesRepresentations getCtrlRepresentation() {
        return ctrlRepresentation;
    }

    public void setCtrlRepresentation(CtrlLesRepresentations ctrlRepresentation) {
        this.ctrlRepresentation = ctrlRepresentation;
    }

    public CtrlLesReservations getCtrlReservations() {
        return ctrlReservations;
    }

    public void setCtrlReservations(CtrlLesReservations ctrlReservations) {
        this.ctrlReservations = ctrlReservations;
    }

    @Override
    public void windowOpened(WindowEvent we) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeactivated(WindowEvent we) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(this.vue.getjButton1())){
            vue2.setVisible(true);
        }
    }
    
    
}
