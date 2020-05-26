/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.discotienda.beans.logica;

import edu.unicundi.discotienda.model.Artista;
import edu.unicundi.discotienda.model.ConexionBD;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Luz
 */
@Named(value = "datos")
@SessionScoped
public class Datos implements Serializable {

    Connection conexion;
    private List<Artista> listaArtista;

    /**
     * Creates a new instance of datos
     */
    public Datos() {
        listaArtista = new ArrayList<>();
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
            String cadenaSql = "INSERT INTO public.artista(id_artista, nombre_artista, pais_artista, fecha_nacimiento)" +"VALUES ((SELECT MAX(id_artista)+1 as id_artista FROM public.artista),"+"'"+artista.getNombre()+"',"+"'"+artista.getPais()+"'"+",'"+"04/05/1849"+"');";
//                    "INSERT INTO public.artista(id_artista, nombre_artista, pais_artista, fecha_nacimiento)"
//                    + "VALUES  ((SELECT MAX(id_artista)+1 as id_artista FROM public.artista),'" + artista.getNombre() + "','" + artista.getPais() + "','1959-08-11')";
            prepararSentencia = this.conexion.prepareStatement(cadenaSql);
            prepararSentencia.executeUpdate();
        } catch (Exception e) {

        }
    }
    @PostConstruct
    public void init() {

    }
    public void listar() throws SQLException {
        java.sql.Statement st = conexion.createStatement();
        try{
        String sql = "SELECT id_artista , nombre_artista, pais_artista , fecha_nacimiento FROM artista";
        ResultSet result = st.executeQuery(sql);
        while (result.next()) {
            System.out.println ("Entro a lista");
            int  id = Integer.parseInt(result.getString("id_artista"));
            listaArtista.add(new Artista(id, result.getString("nombre_artista"), result.getString("pais_artista"), result.getString("fecha_nacimiento")));
        }
        }catch(Exception e ){
                
                }
        }
    
    public void actualizar(RowEditEvent event){
        Artista c = (Artista) event.getObject();
        PreparedStatement prepararSentencia = null;
        try {
            String cadenaSql = "UPDATE public.artista SET nombre_artista='"+c.getNombre()+"',pais_artista='"+c.getPais()+"',fecha_nacimiento='"+c.getFechaNacimiento()+"' WHERE id_artista="+c.getId()+";";
            prepararSentencia = this.conexion.prepareStatement(cadenaSql);
            prepararSentencia.executeUpdate();
            FacesMessage message = new FacesMessage("Editó el carro con id: " + c.getId());
        } catch (Exception e) {

        }

    }

    public void cancelar(RowEditEvent event){
        Artista c = (Artista) event.getObject();
        PreparedStatement prepararSentencia = null;
        try {
            String cadenaSql = "DELETE FROM public.artista WHERE id_artista" + "=" + c.getId() + ";";
            prepararSentencia = this.conexion.prepareStatement(cadenaSql);
            prepararSentencia.executeUpdate();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se Elimino" + c.getId()));
        } catch (Exception e) {

        }

    }
 
    public List<Artista> getListaArtista() {
        return listaArtista;
    }

    public void setListaArtista(List<Artista> listaArtista) {
        this.listaArtista = listaArtista;
    }

    
    }

