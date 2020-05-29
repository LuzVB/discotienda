/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.discotienda.beans.logica;

import edu.unicundi.discotienda.model.Album;
import edu.unicundi.discotienda.model.Artista;
import edu.unicundi.discotienda.model.Usuario;
import java.io.Serializable;
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
public class DatosCompra  implements Serializable {

    private List<Album> listaAlbumCompra;
    private List<Usuario> listaCancionCompra;
    private int totalCompra;

    /**
     * Creates a new instance of DatosCompra
     */
    public DatosCompra() {
        listaAlbumCompra = new ArrayList<>();
        listaCancionCompra = new ArrayList<>();
        totalCompra = 0;
    }

    @PostConstruct
    public void inicio() {
    }

    public void llenarArtista(Album artista) {
        boolean encuentro = false;
        for (Album c : listaAlbumCompra) {
            if (c.getIdAlbum().equals(artista.getIdAlbum())) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        "Error!", "El abum: " + artista.getNombreAlbum() + " Ya se encuentra en el carrito"));
                encuentro = true;
            }
        }

        if (encuentro == false) {
            listaAlbumCompra.add(new Album(artista.getIdAlbum(), artista.getNombreAlbum(),
                    artista.getNombreArtista(), artista.getNombreGenero(), artista.getFormatoAlbum(),
                    artista.getFechaAlbum(), artista.getPrecioAlbum()));

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Añadir album!", "Se agrego al carrito el album: " + artista.getNombreAlbum()));
        }
    }

    public void llenarCancion(Usuario cancion) {
        boolean encuentro = false;

        for (Album c : listaAlbumCompra) {
            if (c.getIdAlbum().equals(cancion.getIdAlbum())) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        "Error!", "La cancion: " + cancion.getNombreAlbum() + " pertenece a un album que ya se encuentra en el carrito"));
                encuentro = true;
            }
        }

        for (Usuario c : listaCancionCompra) {
            if (c.getIdCancion().equals(cancion.getIdCancion())) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        "Error!", "La cancion: " + cancion.getNombreCancion() + " ya se encuentra en el carrito"));
                encuentro = true;
            }
        }

        if (encuentro == false) {
             listaCancionCompra.add(new Usuario(cancion.getIdCancion(), cancion.getNombreArtista(),
                    cancion.getNombreAlbum(), cancion.getNombreCancion(), cancion.getDuracionCancion(),
                    cancion.getFormato(), cancion.getPrecioCancion(), cancion.getIdAlbum()));

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Añadir Cancion!", "Se agrego al carrito la cancion: " + cancion.getNombreCancion()));
        } 
        
        
    }

    public int precioCompra() {
        for (Album album : listaAlbumCompra) {
            totalCompra = totalCompra + album.getPrecioAlbum();
        }
        for (Usuario cancion : listaCancionCompra) {
            totalCompra = totalCompra + cancion.getPrecioCancion();
        }
        
        return totalCompra;
    }

    public void limpiarLista() {
        totalCompra = 0;
        listaAlbumCompra.clear();
        listaCancionCompra.clear();
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
