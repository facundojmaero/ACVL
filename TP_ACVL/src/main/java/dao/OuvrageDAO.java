package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import modele.Ouvrage;

public class OuvrageDAO extends AbstractDataBaseDAO {

    public OuvrageDAO(DataSource ds) {
        super(ds);
    }

    /**
     * Renvoie la liste des ouvrages de la table bibliographie
     */
    public List<Ouvrage> getListeOuvrages() {
        List<Ouvrage> result = new ArrayList<Ouvrage>();
        try (
	     Connection conn = getConn();
	     Statement st = conn.createStatement();
	     ) {
            ResultSet rs = st.executeQuery("SELECT * FROM bibliographie");
            while (rs.next()) {
                Ouvrage ouvrage =
                    new Ouvrage(rs.getInt("id"), rs.getString("auteur"), rs.getString("titre"));
                result.add(ouvrage);
            }
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
	}
	return result;
    }

    /**
     * Ajoute l'ouvrage d'auteur et de titre spécifié dans la table
     * bibliographie.
     */
    public void ajouterOuvrage(String auteur, String titre) {
        try (
	     Connection conn = getConn();
	     PreparedStatement st = conn.prepareStatement
	       ("INSERT INTO bibliographie (auteur, titre) VALUES (?, ?)");
	     ) {
            st.setString(1, auteur);
            st.setString(2, titre);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        }
    }
    
    /**
     * Récupère l'ouvrage d'identifiant id dans la table bibliographie.
     */
    public Ouvrage getOuvrage(int id) throws DAOException {
       
        String auteur, titre;
        try (
             Connection conn = getConn();
             PreparedStatement st = conn.prepareStatement(
                "SELECT auteur, titre FROM bibliographie WHERE id = ?");
             ) {
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            rs.next();
            auteur = rs.getString("auteur");
            titre = rs.getString("titre");
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        }

        return new Ouvrage(id, auteur, titre);
    }

    /**
     * Modifie l'ouvrage d'identifiant id avec le nouvel auteur et le nouveau
     * titre spécifiés dans la table bibliographie
     */
    public void modifierOuvrage(int id, String auteur, String titre) throws DAOException {
        try (
             Connection conn = getConn();
             PreparedStatement st = conn.prepareStatement(
                "UPDATE bibliographie SET auteur = ?, titre = ? WHERE id = ?");
             ) {
            st.setString(1, auteur);
            st.setString(2, titre);
            st.setInt(3, id);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        }
    }

    /**
     * Supprime l'ouvrage d'identifiant id dans la table bibliographie.
     */
    public void supprimerOuvrage(int id) throws DAOException {
        try (
             Connection conn = getConn();
             PreparedStatement st = conn.prepareStatement(
                "DELETE FROM bibliographie WHERE id = ?");
             ) {
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        }
    }
}
