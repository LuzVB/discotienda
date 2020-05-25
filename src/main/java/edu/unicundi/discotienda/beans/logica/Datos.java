/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.discotienda.beans.logica;

import edu.unicundi.discotienda.model.Artista;
import edu.unicundi.discotienda.model.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Luz
 */
@Named(value = "datos")
@RequestScoped
public class Datos {

    Connection conexion;

    /**
     * Creates a new instance of datos
     */
    public Datos() {
        try {
            ConexionBD conectar = new ConexionBD();
            conectar.conectarBaseDatos();
            this.conexion = conectar.getConexion();
        } catch (SQLException ex) {
            Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertar(Artista artista) {
        PreparedStatement prepararSentencia = null;
        try {
            String cadenaSql = "INSERT INTO public.artista(id_artista, nombre_artista, pais_artista, fecha_nacimiento)"
                    + "VALUES  ((SELECT MAX(id_artista)+1 as id_arista FROM public.artista),'" + artista.getNombre() + "','" + artista.getPais() + "','1959-08-11')";
            prepararSentencia = this.conexion.prepareStatement(cadenaSql);
            prepararSentencia.executeUpdate();
        } catch (Exception e) {

        }
    }

    public void listar() {

    }

}
