/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.discotienda.beans.logica;

import edu.unicundi.discotienda.model.Administrador;
import edu.unicundi.discotienda.model.Artista;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Luz
 */
@Named(value = "datosInicioSesion")
@RequestScoped
public class DatosInicioSesion extends Datos implements Serializable {

    private Administrador adminDatos;
    private String sql;
    private int Id;

    public DatosInicioSesion() {
    }

    @PostConstruct
    public void init() {
        adminDatos = new Administrador();
    }
    
    public void listar(Administrador admin) throws SQLException {
        sql = "SELECT id_admin, usuario_admin, contrasena_admin FROM public.administrador WHERE  usuario_admin = '" + admin.getUsuarioAdmin() + "' AND contrasena_admin = '" + admin.getContrasenaAdmin() + "' ;";
        java.sql.Statement st = conexion.createStatement();
        try {
            ResultSet result = st.executeQuery(sql);
            while (result.next()) {
                int id = Integer.parseInt(result.getString("id_admin"));
                adminDatos.setIdAmin(Integer.parseInt(result.getString("id_admin")));
                adminDatos.setUsuarioAdmin(result.getString("usuario_admin"));
                adminDatos.setContrasenaAdmin(result.getString("contrasena_admin"));
            }

        } catch (Exception e) {

        }
    }

    public Administrador getAdminDatos() {
        return adminDatos;
    }

    public void setAdminDatos(Administrador adminDatos) {
        this.adminDatos = adminDatos;
    }

}
