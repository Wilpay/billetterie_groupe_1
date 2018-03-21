/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.UIManager.getString;
import modele.dao.DaoGroupe;
import modele.dao.DaoRepresentation;
import modele.metier.Representation;
import vue.vueReservation;
import vue.vueVoirRepresentation;

/**
 *
 * @author btssio
 */
public class CtrlLesRepresentations implements WindowListener, ActionListener, MouseListener {
     private vueVoirRepresentation vue; // LA VUE
     
     
     public CtrlLesRepresentations(vueVoirRepresentation vue) {
        
        this.vue = vue;
        // le contrôleur écoute la vue
        this.vue.addWindowListener(this);
        // le controleur écoute le bouton jButtonRechercher de sa vue
        this.vue.getjTable1().addMouseListener(this);
        
        
        // préparer l'état iniitial de la vue
        List<Representation> lesRepresentations = null;
        try {
            lesRepresentations = DaoRepresentation.selectAll();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(getVue(), "CtrlLesRepresentations - échec de sélection des Representations");
        }
        afficherLesRepresentations(lesRepresentations);
    }
     
     // contrôle de la vue
    /**
     * Remplir le composant JTable avec les groupes
     *
     * @param desRepresentations liste des adresses à afficher
     */
    private final void afficherLesRepresentations(List<Representation> desRepresentations) {
        getVue().getModeleTableRepresentation().setRowCount(0);
        String[] titresColonnes = {"Lieu", "Groupe", "date","heureDeb","heureFin","NbPlace"};
        getVue().getModeleTableRepresentation().setColumnIdentifiers(titresColonnes);
        

        
        String[] ligneDonnees = new String[6];

        
        for (Representation uneRepresentation : desRepresentations) {
            ligneDonnees[0] = uneRepresentation.getLieu();
            ligneDonnees[1] = uneRepresentation.getGroupe();
            ligneDonnees[2] = uneRepresentation.getDate();
            ligneDonnees[3] = uneRepresentation.getHeureDebut();
            ligneDonnees[4] = uneRepresentation.getHeureFin();
            ligneDonnees[5] = uneRepresentation.getPlacesDispo();
            getVue().getModeleTableRepresentation().addRow(ligneDonnees);            
        }       
    }
    
    /**
     * Quitter l'application, après demande de confirmation
     */
    private void quitter() {
        // Confirmer avant de quitter
        int rep = JOptionPane.showConfirmDialog(getVue(), "Quitter l'application\nEtes-vous sûr(e) ?", "festival", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (rep == JOptionPane.YES_OPTION) {
            // mettre fin à l'application
            System.exit(0);
        }
    }
    
    // ACCESSEURS et MUTATEURS
    public vueVoirRepresentation getVue() {
        return vue;
    }
    
    public void setVue(vueVoirRepresentation vue) {
        this.vue = vue;
    }

    @Override
    public void windowOpened(WindowEvent e) {
       }

    @Override
    public void windowClosing(WindowEvent e) {
        quitter();
        }

    @Override
    public void windowClosed(WindowEvent e) {
        }

    @Override
    public void windowIconified(WindowEvent e) {
        }

    @Override
    public void windowDeiconified(WindowEvent e) {
        }

    @Override
    public void windowActivated(WindowEvent e) {
        }

    @Override
    public void windowDeactivated(WindowEvent e) {
        }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int row = vue.getjTable1().getSelectedRow();
        String groupeChoisis = (String) vue.getjTable1().getValueAt(row, 0);
        String Places = (String) vue.getjTable1().getValueAt(row, 5);
        int rep = JOptionPane.showConfirmDialog(vue, "Representation : " + groupeChoisis + "\n" + "Il reste : " + Places + " places"+"\n"+"Voulez-vous acheter des places ?");
        if(rep == JOptionPane.YES_OPTION){                 
            new vueReservation().setVisible(true);
            
    }
        
             
        

        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    
 



}
