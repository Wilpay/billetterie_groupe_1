/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import javax.swing.JOptionPane;

/**
 *
 * @author Willy
 */
public class CtrlPrincipal {
    
    private CtrlLesRepresentations ctrlRepresentation;
    private CtrlLesReservations ctrlReservations;
    
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
    
    
}
