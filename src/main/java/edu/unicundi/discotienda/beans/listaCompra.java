/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.discotienda.beans;

import edu.unicundi.discotienda.beans.logica.DatosCompra;
import edu.unicundi.discotienda.model.Album;
import edu.unicundi.discotienda.model.Usuario;
import java.io.IOException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author Luz
 */
@Named(value = "listaCompra")
@ApplicationScoped
public class listaCompra {
   
    private List<Usuario> listaCancion;
    private List<Album> listaAlbum;
    private int precio;
//    private Usuario cancionUFormulario;
    
    @Inject
    private DatosCompra serviceCompra;
    
    /**
     * Creates a new instance of listaCompra
     */
    public listaCompra() {
    }
    
    @PostConstruct
    public void init() {
        this.listaAlbum = serviceCompra.getListaAlbumCompra();
        this.listaCancion = serviceCompra.getListaCancionCompra();
        this.precio = serviceCompra.precioCompra();
    }
    
    public void confirmarCompra(){
        this.precio  = serviceCompra.precioCompra();
        serviceCompra.limpiarLista();
    }
    
    public void redireccionar() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("albumUsuario.xhtml");
        } catch (IOException ex) {
            //Logger.getLogger(CrearArtista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Usuario> getListaCancion() {
        return listaCancion;
    }

    public void setListaCancion(List<Usuario> listaCancion) {
        this.listaCancion = listaCancion;
    }

    public List<Album> getListaAlbum() {
        return listaAlbum;
    }

    public void setListaAlbum(List<Album> listaAlbum) {
        this.listaAlbum = listaAlbum;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
}
