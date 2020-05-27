/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.discotienda.beans;

import edu.unicundi.discotienda.beans.logica.DatosAlbum;
import edu.unicundi.discotienda.model.Album;
import edu.unicundi.discotienda.model.Artista;
import edu.unicundi.discotienda.model.Genero;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Valentina
 */
@Named(value = "album")
@RequestScoped
public class album implements Serializable{

    int idArtista;
    int idGenero;
    private List<Album> listaAlbum;
    private List<Genero> listaGenero;
    private List<Artista> listaArtista;
     private Album albumFormulario;
     
    @Inject
    private DatosAlbum service;
    
     public album(){
     
     }
     
    @PostConstruct
    public void album() {
        listarAlbum();
        listarGenero();
        listarArtista();
        this.listaAlbum = service.getListaAlbum();
        this.listaGenero =service.getListaGenero();
        this.listaArtista=service.getListaArtista();
        albumFormulario = new Album();
    }
  
    public void listarAlbum(){
        try {
            service.listar();
        } catch (SQLException ex) {
            Logger.getLogger(inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void listarGenero(){
        try {
            service.listarGenero();
        } catch (SQLException ex) {
            Logger.getLogger(inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void listarArtista(){
        try {
            service.listarArtista();
        } catch (SQLException ex) {
            Logger.getLogger(inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void insertarAlbum(){
        this.idArtista = Integer.parseInt(albumFormulario.getNombreArtista());
        this.idGenero = Integer.parseInt(albumFormulario.getNombreGenero());
        String cadenaSql = " INSERT INTO public.album( id_album, nombre_album, fecha_album, formato_album, precio_album, id_artista, id_genero)"
                + "VALUES ((SELECT MAX(id_album)+1 as id_album FROM public.album)," + "'" + albumFormulario.getNombreAlbum() + "'," + "'" + albumFormulario.getFechaAlbum() + "'," + "'" + albumFormulario.getFormatoAlbum() + "'," + "'" + albumFormulario.getPrecioAlbum() + "'," + "'" + idArtista + "'" + ",'" + idGenero + "');";
        System.out.println(albumFormulario.getNombreAlbum() + "'," + "'" + albumFormulario.getFechaAlbum() + "'," + "'" + albumFormulario.getFormatoAlbum() + "'," + "'" + albumFormulario.getPrecioAlbum() + "'," + "'" + idArtista + "'" + ",'" + idGenero);
        FacesMessage message = new FacesMessage("Se inserto correctamente");
        service.modifacionBaseDatos(cadenaSql, message);
        
        
    }
    public void actualizarAlbum(RowEditEvent event){
        Album datosAlbum = (Album) event.getObject();
        this.idArtista = Integer.parseInt(datosAlbum.getNombreArtista());
        this.idGenero=Integer.parseInt(datosAlbum.getNombreGenero());
        String cadenaSql = "UPDATE public.album SET nombre_album='"+datosAlbum.getNombreAlbum()+"',fecha_album='"+datosAlbum.getFechaAlbum()+"',formato_album='"+datosAlbum.getFormatoAlbum()+"',precio_album='"+datosAlbum.getPrecioAlbum()+"',id_artista='"+idArtista+"',id_genero='"+idGenero+"' WHERE id_album="+datosAlbum.getIdAlbum()+";";
        FacesMessage message = new FacesMessage("Editó el album con id: " + datosAlbum.getIdAlbum());
        service.modifacionBaseDatos(cadenaSql, message);
    }
    
    public void eliminarAlbum(RowEditEvent event)  {
        Album datosAlbum = (Album) event.getObject();
        String cadenaSql = "DELETE FROM public.album WHERE id_album" + "=" + datosAlbum.getIdAlbum() + ";";
        FacesMessage message = new FacesMessage("Se Elimino el artista: " + datosAlbum.getIdAlbum());
        service.modifacionBaseDatos(cadenaSql, message);
    }
    
//    public void eliminarAlbum(Album artista) {
//        System.out.println("Entre al eliminar" + artista.getIdAlbum());
//        String cadenaSql = "DELETE FROM public.album WHERE id_album" + "=" + artista.getIdAlbum() + ";";
//        FacesMessage message = new FacesMessage("Se Elimino el artista: " + artista.getIdAlbum());
//        service.modifacionBaseDatos(cadenaSql, message);
//
//    }
    

    public List<Album> getListaAlbum() {
        return listaAlbum;
    }

    public void setListaAlbum(List<Album> listaAlbum) {
        this.listaAlbum = listaAlbum;
    }

    public Album getAlbumFormulario() {
        return albumFormulario;
    }

    public void setAlbumFormulario(Album albumFormulario) {
        this.albumFormulario = albumFormulario;
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
