/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.discotienda.beans.logica;

import edu.unicundi.discotienda.model.Album;
import edu.unicundi.discotienda.model.Cancion;
import edu.unicundi.discotienda.model.Usuario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luz
 */
@Named(value = "datosCancion")
@SessionScoped
public class DatosCancion extends Datos implements Serializable {

   private List<Cancion> listaCancion;
    private List<Album> listaAlbum;
    private List<Usuario> listaCancionU;
    public DatosCancion() {
    }
    
    public void listarCancion() throws SQLException {
        listaCancion = new ArrayList<>();
        listaCancion.clear();
        java.sql.Statement st = conexion.createStatement();
        try {
            String sql = "SELECT id_cancion, nombre_album, nombre_cancion, duracion_cancion, precio_cancion FROM public.view_mostrar_cancion;";
            ResultSet result = st.executeQuery(sql);
            while (result.next()) {
                System.out.println("Entro a listaCancion");
                int id = Integer.parseInt(result.getString("id_cancion"));
                int idPrecio= Integer.parseInt(result.getString("precio_cancion"));
                listaCancion.add(new Cancion(id, result.getString("nombre_album"), result.getString("nombre_cancion"), result.getString("duracion_cancion") ,idPrecio));
                System.out.println(id);
            }
        } catch (Exception e) {

        }
    }
    
     public void listarCancionU() throws SQLException {
        listaCancionU = new ArrayList<>();
        listaCancionU.clear();
        java.sql.Statement st = conexion.createStatement();
        System.out.println("Entro a listaCancionUsuario");
        try {
            String sql = "SELECT id_cancion, nombre_artista, nombre_album, nombre_cancion, duracion_cancion, formato_album, precio_cancion  FROM public.view_cancionus";
            ResultSet result = st.executeQuery(sql);
            while (result.next()) {
                System.out.println("Entro a listaCancionUsuario2");
                int id = Integer.parseInt(result.getString("id_cancion"));
                int idPrecio= Integer.parseInt(result.getString("precio_cancion"));
                listaCancionU.add(new Usuario(id, result.getString("nombre_artista"), result.getString("nombre_album"), result.getString("nombre_cancion") , result.getString("duracion_cancion"), result.getString("formato_album"),idPrecio));
                System.out.println(result.getString("duracion_cancion"));
            }
        } catch (Exception e) {

        }  
    }
    public void listarAlbum() throws SQLException {
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

    public List<Cancion> getListaCancion() {
        return listaCancion;
    }

    public void setListaCancion(List<Cancion> listaCancion) {
        this.listaCancion = listaCancion;
    }

    public List<Album> getListaAlbum() {
        return listaAlbum;
    }

    public void setListaAlbum(List<Album> listaAlbum) {
        this.listaAlbum = listaAlbum;
    }

    public List<Usuario> getListaCancionU() {
        return listaCancionU;
    }

    public void setListaCancionU(List<Usuario> listaCancionU) {
        this.listaCancionU = listaCancionU;
    }
    
}
