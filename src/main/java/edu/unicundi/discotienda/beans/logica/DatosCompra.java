/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.discotienda.beans.logica;

import edu.unicundi.discotienda.model.Album;
import edu.unicundi.discotienda.model.Artista;
import edu.unicundi.discotienda.model.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Luz
 */
@Named(value = "datosCompra")
@ApplicationScoped
public class DatosCompra {

    private List<Album> listaAlbumCompra;
    private List<Usuario> listaCancionCompra;
    private int totalCompra;

    /**
     * Creates a new instance of DatosCompra
     */
    public DatosCompra() {
        listaAlbumCompra = new ArrayList<>();
        listaCancionCompra = new ArrayList<>();
    }

    @PostConstruct
    public void inicio() {
        precioCompra();
    }

    public void llenarArtista(Album artista) {
        listaAlbumCompra.add(new Album(artista.getIdAlbum(), artista.getNombreAlbum(),
                artista.getNombreArtista(), artista.getNombreGenero(), artista.getFormatoAlbum(),
                artista.getFechaAlbum(), artista.getPrecioAlbum()));
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
                "Añadir album!","Se agrego al carrito el album: "+artista.getNombreAlbum()));
    }

    public void llenarCancion(Usuario cancion) {
        listaCancionCompra.add(new Usuario(cancion.getIdCancion(), cancion.getNombreArtista(),
                cancion.getNombreAlbum(), cancion.getNombreCancion(), cancion.getDuracionCancion(),
                cancion.getFormato(), cancion.getPrecioCancion(), cancion.getIdAlbum()));
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
                 "Añadir album!","Se agrego al carrito la cancion: "+cancion.getNombreCancion() ));
    }

    public void precioCompra() {
        System.out.println("ENTRO!");
        for (Album album : listaAlbumCompra) {
            totalCompra = totalCompra+album.getPrecioAlbum();
        }
        for (Usuario cancion : listaCancionCompra) {
            totalCompra = totalCompra+cancion.getPrecioCancion();
        }
        
        System.out.println("ENTRO! "+totalCompra);
    }
    
    public void limpiarLista(){
        listaAlbumCompra.clear();
        listaCancionCompra.clear();
        totalCompra = 0;
    }

    public List<Album> getListaAlbumCompra() {
        return listaAlbumCompra;
    }

    public void setListaAlbumCompra(List<Album> listaAlbumCompra) {
        this.listaAlbumCompra = listaAlbumCompra;
    }

    public List<Usuario> getListaCancionCompra() {
        return listaCancionCompra;
    }

    public void setListaCancionCompra(List<Usuario> listaCancionCompra) {
        this.listaCancionCompra = listaCancionCompra;
    }

    public int getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(int totalCompra) {
        this.totalCompra = totalCompra;
    }

}
