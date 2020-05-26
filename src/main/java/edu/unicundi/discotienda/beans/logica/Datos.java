/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.discotienda.beans.logica;

import edu.unicundi.discotienda.model.ConexionBD;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Luz
 */
@Named(value = "datos")
@ViewScoped
public class Datos implements Serializable {

    Connection conexion;

    public Datos() {
        try {
            ConexionBD conectar = new ConexionBD();
            conectar.conectarBaseDatos();
            this.conexion = conectar.getConexion();
        } catch (SQLException ex) {
            Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @PostConstruct
    public void init() {

    }
    

    public void modifacionBaseDatos(String cadenaSqlBean,FacesMessage messageBean){
        PreparedStatement prepararSentencia = null;
        try {
            String cadenaSql = cadenaSqlBean;
            prepararSentencia = this.conexion.prepareStatement(cadenaSql);
            prepararSentencia.executeUpdate();
            FacesContext.getCurrentInstance().addMessage(null,messageBean);
        } catch (Exception e) {

        }
    }


}
