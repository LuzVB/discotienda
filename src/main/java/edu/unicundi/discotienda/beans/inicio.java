/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.discotienda.beans;

import edu.unicundi.discotienda.beans.logica.Datos;
import edu.unicundi.discotienda.model.Artista;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author Luz
 */
@Named(value = "inicio")
@RequestScoped
public class inicio  implements Serializable {

    private List<Artista> listaArtista;
    private Artista artistaFormulario;
    private Datos datos;
   
    @Inject
    private Datos service;
 
    /**
     * Creates a new instance of inicio
     */
    public inicio() {
    }
    
    @PostConstruct
    public void inicio() {
        this.listaArtista = service.getListaArtista();
        datos = new Datos();
        artistaFormulario = new Artista();
    }

    public void insertarArtista() {
        this.datos.insertar(artistaFormulario);
    }
    
    public Artista getArtistaFormulario() {
        return artistaFormulario;
    }

    public void setArtistaFormulario(Artista artistaFormulario) {
        this.artistaFormulario = artistaFormulario;
    }

    public Datos getDatos() {
        return datos;
    }

    public void setDatos(Datos datos) {
        this.datos = datos;
    }

    public List<Artista> getListaArtista() {
        return listaArtista;
    }

    public void setListaArtista(List<Artista> listaArtista) {
        this.listaArtista = listaArtista;
    }

}
