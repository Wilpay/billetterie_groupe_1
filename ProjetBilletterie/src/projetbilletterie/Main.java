/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetbilletterie;

import controleur.CtrlLesRepresentations;
import controleur.CtrlLesReservations;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modele.dao.Jdbc;
import vue.vuePrincipale;
import vue.vueReservation;
import vue.vueVoirRepresentation;

/**
 *
 * @author btssio
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Jdbc.creer("com.mysql.jdbc.Driver", "jdbc:mysql:", "//localhost/", "festival", "root", "joliverie");
        try {
            Jdbc.getInstance().connecter();
            vuePrincipale VueP = new vuePrincipale();
            vueVoirRepresentation uneVue = new vueVoirRepresentation();
            CtrlLesRepresentations unControleur = new CtrlLesRepresentations(uneVue);
            vueReservation uneAutreVue = new vueReservation();
            CtrlLesReservations unAutreControleur = new CtrlLesReservations(uneAutreVue);
            
            // afficher la vue
            uneVue.setVisible(true);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Main - classe JDBC non trouvée");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Main - échec de connexion");
        }
    }
    
}
