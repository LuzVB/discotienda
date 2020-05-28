/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.discotienda.beans;

import edu.unicundi.discotienda.beans.logica.DatosCancion;
import edu.unicundi.discotienda.model.Usuario;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author Valentina
 */
@Named(value = "cancionUsuario")
@RequestScoped
public class cancionUsuario {

    private List<Usuario> listaCancionU;
     private Usuario cancionUFormulario;
     
    @Inject
    private DatosCancion service;
    
    public cancionUsuario() {
    }
     
    @PostConstruct
    public void cancionUsuario() {
        listarCancionU();
        this.listaCancionU = service.getListaCancionU();
        cancionUFormulario = new Usuario();
    }
    

    public void comprarCancion() {
       

    }
    
    public void listarCancionU(){
        try {
            service.listarCancionU();
        } catch (SQLException ex) {
            Logger.getLogger(inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Usuario> getListaCancionU() {
        return listaCancionU;
    }

    public void setListaCancionU(List<Usuario> listaCancionU) {
        this.listaCancionU = listaCancionU;
    }

    public Usuario getCancionUFormulario() {
        return cancionUFormulario;
    }

    public void setCancionUFormulario(Usuario cancionUFormulario) {
        this.cancionUFormulario = cancionUFormulario;
    }
    
}
