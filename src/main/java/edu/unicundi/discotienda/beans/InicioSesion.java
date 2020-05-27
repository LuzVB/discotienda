/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.discotienda.beans;

import edu.unicundi.discotienda.beans.logica.DatosInicioSesion;
import edu.unicundi.discotienda.model.Administrador;
import edu.unicundi.discotienda.model.Artista;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author Luz
 */
@Named(value = "inicioSesion")
@RequestScoped
public class InicioSesion {

    private Administrador adminInicio;
    private Administrador adminSQL;

    @Inject
    private DatosInicioSesion serviceInicioSesion;

    public InicioSesion() {
    }

    @PostConstruct
    public void init() {
        adminInicio = new Administrador();
        adminSQL = new Administrador();
    }

    public void confirmarAdministrador() {
        try {
            serviceInicioSesion.listar(adminInicio);
        } catch (SQLException ex) {
            Logger.getLogger(InicioSesion.class.getName()).log(Level.SEVERE, null, ex);
        }

        adminSQL = serviceInicioSesion.getAdminDatos();

        if (adminSQL.getIdAmin() == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!","Credenciales incorrectas"));
        } else {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", adminSQL);
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("faces/index.xhtml");
            } catch (IOException ex) {
               // Logger.getLogger(InicioSesion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public String direccionar() {
        return "index";
    }

    public Administrador getAdminInicio() {
        return adminInicio;
    }

    public void setAdminInicio(Administrador adminInicio) {
        this.adminInicio = adminInicio;
    }

    public Administrador getAdminSQL() {
        return adminSQL;
    }

    public void setAdminSQL(Administrador adminSQL) {
        this.adminSQL = adminSQL;
    }

    public DatosInicioSesion getServiceInicioSesion() {
        return serviceInicioSesion;
    }

    public void setServiceInicioSesion(DatosInicioSesion serviceInicioSesion) {
        this.serviceInicioSesion = serviceInicioSesion;
    }

}
