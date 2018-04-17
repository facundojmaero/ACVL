//TODO MODIFICAR ESTO ES DEL MANIP10      
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
     * Renvoie la liste des ouvrages de la table bibliographie.
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
     * Ajoute l'ouvrage d'auteur et de titre spécifiés dans la table
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
    public Ouvrage getOuvrage(int id) {

        Ouvrage ouvrage = null;
        
        try(Connection con = getConn()){
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM MAEROF.bibliographie WHERE id = " + Integer.toString(id));
                while(res.next()){
                    ouvrage = new Ouvrage(id, res.getString("auteur"), res.getString("titre"));
                }
       }
        catch (SQLException e){
            System.out.println("sql exception");
            e.printStackTrace();
        }
        return ouvrage;
    }

    /**
     * Modifie l'ouvrage d'identifiant id avec le nouvel auteur et le nouveau
     * titre spécifiés dans la table bibliographie.
     */
    public void modifierOuvrage(int id, String auteur, String titre) {

        try (
	     Connection conn = getConn();
	     PreparedStatement st = conn.prepareStatement
	       ("UPDATE bibliographie SET Auteur = ?, Titre = ? WHERE ID = ?");
	     ) {
            st.setString(1, auteur);
            st.setString(2, titre);
            st.setString(3, Integer.toString(id));
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        }
    }

    /**
     * Supprime l'ouvrage d'identifiant id dans la table bibliographie.
     */
    public void supprimerOuvrage(int id) {
        
        try (
	     Connection conn = getConn();
	     PreparedStatement st = conn.prepareStatement
	       ("DELETE FROM bibliographie WHERE ID = ?");
	     ) {
            st.setString(1, Integer.toString(id));
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        }
    }
}
