/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.discotienda.beans.logica;

import edu.unicundi.discotienda.model.Artista;
import edu.unicundi.discotienda.model.ConexionBD;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Luz
 */
@Named(value = "datos")
@ViewScoped
public class Datos implements Serializable {

    Connection conexion;
    private List<Artista> listaArtista;

    /**
     * Creates a new instance of datos
     */
    public Datos() {
        listaArtista = new ArrayList<>();
        try {
            ConexionBD conectar = new ConexionBD();
            conectar.conectarBaseDatos();
            this.conexion = conectar.getConexion();
        } catch (SQLException ex) {
            Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @PostConstruct
    public void init() {

    }
    
   
    public void listar() throws SQLException {
        listaArtista.clear();
        java.sql.Statement st = conexion.createStatement();
        try {
            String sql = "SELECT id_artista , nombre_artista, pais_artista , fecha_nacimiento FROM artista";
            ResultSet result = st.executeQuery(sql);
            while (result.next()) {
                System.out.println("Entro a lista");
                int id = Integer.parseInt(result.getString("id_artista"));
                listaArtista.add(new Artista(id, result.getString("nombre_artista"), result.getString("pais_artista"), result.getString("fecha_nacimiento")));
            }
        } catch (Exception e) {

        }
    }

    public void modifacionBaseDatos(String cadenaSqlBean,FacesMessage messageBean){
        PreparedStatement prepararSentencia = null;
        try {
            String cadenaSql = cadenaSqlBean;
            prepararSentencia = this.conexion.prepareStatement(cadenaSql);
            prepararSentencia.executeUpdate();
            FacesContext.getCurrentInstance().addMessage(null,messageBean);
        } catch (Exception e) {

        }
    }

    public List<Artista> getListaArtista() {
        return listaArtista;
    }

    public void setListaArtista(List<Artista> listaArtista) {
        this.listaArtista = listaArtista;
    }

}
