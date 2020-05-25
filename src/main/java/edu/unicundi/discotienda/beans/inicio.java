/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.discotienda.beans;

import edu.unicundi.discotienda.beans.logica.Datos;
import edu.unicundi.discotienda.model.Artista;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Luz
 */
@Named(value = "inicio")
@RequestScoped
public class inicio {

    private Artista artistaFormulario;
    private Datos datos;

    /**
     * Creates a new instance of inicio
     */
    public inicio() {
    }
    
    @PostConstruct
    public void inicio() {
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

}
