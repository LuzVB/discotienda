/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.discotienda.model;

/**
 *
 * @author Valentina
 */
public class Administrador {
    
    private Integer idAmin;
    private String usuarioAdmin;
    private String contrasenaAdmin;
    
    public Administrador() {
    }

    public Integer getIdAmin() {
        return idAmin;
    }

    public void setIdAmin(Integer idAmin) {
        this.idAmin = idAmin;
    }

    public String getUsuarioAdmin() {
        return usuarioAdmin;
    }

    public void setUsuarioAdmin(String usuarioAdmin) {
        this.usuarioAdmin = usuarioAdmin;
    }

    public String getContrasenaAdmin() {
        return contrasenaAdmin;
    }

    public void setContrasenaAdmin(String contrasenaAdmin) {
        this.contrasenaAdmin = contrasenaAdmin;
    }
    
}
