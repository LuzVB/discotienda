/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.discotienda.beans.logica;

import edu.unicundi.discotienda.model.Artista;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Luz
 */
@Named(value = "datosArtista")
@ViewScoped
public class DatosArtista extends Datos implements Serializable {

    private List<Artista> listaArtista;
    
    public DatosArtista() {
    }
    
    public void listar() throws SQLException {
        listaArtista = new ArrayList<>();
        listaArtista.clear();
        java.sql.Statement st = conexion.createStatement();
        try {
            String sql = "SELECT id_artista , nombre_artista, pais_artista , fecha_nacimiento FROM artista";
            ResultSet result = st.executeQuery(sql);
            while (result.next()) {
                int id = Integer.parseInt(result.getString("id_artista"));
                listaArtista.add(new Artista(id, result.getString("nombre_artista"), result.getString("pais_artista"), result.getString("fecha_nacimiento")));
            }
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
