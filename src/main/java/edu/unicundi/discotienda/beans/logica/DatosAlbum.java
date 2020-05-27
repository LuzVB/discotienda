/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.discotienda.beans.logica;

import edu.unicundi.discotienda.model.Album;
import edu.unicundi.discotienda.model.Artista;
import edu.unicundi.discotienda.model.Genero;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Valentina
 */
@Named(value = "datosAlbum")
@SessionScoped
public class DatosAlbum  extends Datos implements Serializable{

    private List<Album> listaAlbum;
    private List<Genero> listaGenero;
    private List<Artista> listaArtista;
    public DatosAlbum() {
    }
    
    public void listar() throws SQLException {
        listaAlbum = new ArrayList<>();
        listaAlbum.clear();
        java.sql.Statement st = conexion.createStatement();
        try {
            String sql = "SELECT id_album, nombre_album, nombre_artista, nombre_genero, formato_album, fecha_album, precio_album FROM public.view_mostrar_album";
            ResultSet result = st.executeQuery(sql);
            while (result.next()) {
                System.out.println("Entro a lista");
                int id = Integer.parseInt(result.getString("id_album"));
                int idPrecio= Integer.parseInt(result.getString("precio_album"));
                listaAlbum.add(new Album(id, result.getString("nombre_album"), result.getString("nombre_artista"), result.getString("nombre_genero") ,result.getString("formato_album"), result.getString("fecha_album"), idPrecio));
            }
        } catch (Exception e) {

        }
    }
    
    public void listarGenero() throws SQLException {
        listaGenero = new ArrayList<>();
        java.sql.Statement st = conexion.createStatement();
        try {
            String sql = "SELECT id_genero, nombre_genero FROM genero";
            ResultSet result = st.executeQuery(sql);
            while (result.next()) {
                System.out.println("Entro a genero");
                int id = Integer.parseInt(result.getString("id_genero"));
                listaGenero.add(new Genero(id, result.getString("nombre_genero")));
            }
        } catch (Exception e) {

        }
    }
    
    public void listarArtista() throws SQLException {
        listaArtista = new ArrayList<>();
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
    

    public List<Album> getListaAlbum() {
        return listaAlbum;
    }

    public void setListaAlbum(List<Album> listaAlbum) {
        this.listaAlbum = listaAlbum;
    }

    public List<Genero> getListaGenero() {
        return listaGenero;
    }

    public void setListaGenero(List<Genero> listaGenero) {
        this.listaGenero = listaGenero;
    }

    public List<Artista> getListaArtista() {
        return listaArtista;
    }

    public void setListaArtista(List<Artista> listaArtista) {
        this.listaArtista = listaArtista;
    }
    
    
}
