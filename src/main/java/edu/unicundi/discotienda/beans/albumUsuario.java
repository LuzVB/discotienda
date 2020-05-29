/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.discotienda.beans;

import edu.unicundi.discotienda.beans.logica.DatosCompra;
import edu.unicundi.discotienda.model.Album;
import edu.unicundi.discotienda.model.Usuario;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author Valentina
 */
@Named(value = "albumUsuario")
@ApplicationScoped
public class albumUsuario {
    
    @Inject
    private DatosCompra serviceCompra;
    /**
     * Creates a new instance of albumUsuario
     */
    public albumUsuario() {
    }
    
    public void comprarAlbum(Album artista) {
       serviceCompra.llenarArtista(artista);
    }
    
}
