/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modele.metier.Reservation;

/**
 *
 * @author Willy
 */
public class DaoReservation {
    
    
    public static List<Reservation> selectOne() throws SQLException {
        List<Reservation> laReservation = new ArrayList<Reservation>();
        Reservation uneReservation;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT R.id_rep AS id, date_rep, Lieu.nom AS Lieu, Groupe.nom AS Groupe, heure_deb,heure_fin, Lieu.capacite AS places_dispo "
                + "FROM Representation R "
                + "INNER JOIN Groupe ON R.id_groupe=Groupe.id "
                + "INNER JOIN Lieu ON id_lieu= Lieu.id";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String date = rs.getString("date_rep");
            String Lieu = rs.getString("Lieu");
            String Groupe = rs.getString("Groupe");
            String heureDebut = rs.getString("heure_deb");
            String heureFin = rs.getString("heure_fin");
            String placesDispo = rs.getString("places_dispo");
            uneReservation = new Reservation(id, date, Lieu,Groupe,heureDebut,heureFin,placesDispo);
            laReservation.add(uneReservation);
        }
        return laReservation;
    }
}
