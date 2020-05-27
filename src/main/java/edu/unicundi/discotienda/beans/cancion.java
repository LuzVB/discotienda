/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.discotienda.beans;


import edu.unicundi.discotienda.beans.logica.DatosCancion;
import edu.unicundi.discotienda.model.Album;
import edu.unicundi.discotienda.model.Cancion;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Luz
 */
@Named(value = "cancion")
@RequestScoped
public class cancion implements Serializable {

    int idAlbum;
    private List<Cancion> listaCancion;
    private List<Album> listaAlbum;
    private Cancion cancionFormulario;
   
    
    @Inject
    private DatosCancion service;
    
    public cancion() {
    }
     
    @PostConstruct
    public void cancion() {
         listarCancion();
         listarAlbum();
         this.listaCancion = service.getListaCancion();
         this.listaAlbum=service.getListaAlbum();
         cancionFormulario = new Cancion();
    }
    
    public void listarCancion(){
        try {
            service.listarCancion();
        } catch (SQLException ex) {
            Logger.getLogger(inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void listarAlbum(){
        try {
            service.listarAlbum();
        } catch (SQLException ex) {
            Logger.getLogger(inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void insertarCancion(){
        this.idAlbum = Integer.parseInt(cancionFormulario.getNombreAlbum());
        String cadenaSql = " INSERT INTO public.cancion(id_cancion, nombre_cancion, duracion_cancion, precio_cancion, id_album)"
        + "VALUES ((SELECT MAX(id_cancion)+1 as id_cancion FROM public.cancion)," + "'" + cancionFormulario.getNombreCancion()+ "'," + "'" + cancionFormulario.getDuracionCancion() + "'," + "'" + cancionFormulario.getPrecioCancion() +"',"+ idAlbum + ");";
        System.out.println("Entre a listar cancion"+ "'" + cancionFormulario.getNombreCancion()+ "'," + "'" + cancionFormulario.getDuracionCancion() + "'," + "'" + cancionFormulario.getPrecioCancion() + idAlbum);
        FacesMessage message = new FacesMessage("Se inserto correctamente");
        service.modifacionBaseDatos(cadenaSql, message);
      
    }
    public void actualizarCancion(RowEditEvent event){
        Cancion datosCancion = (Cancion) event.getObject();
        this.idAlbum=Integer.parseInt(datosCancion.getNombreAlbum());
        String cadenaSql = "UPDATE public.cancion SET nombre_cancion='"+datosCancion.getNombreCancion()+"',duracion_cancion='"+datosCancion.getDuracionCancion()+"',id_album='"+idAlbum+"' WHERE id_cancion="+datosCancion.getIdCancion()+";";
        FacesMessage message = new FacesMessage("Editó la cancion con id: " + datosCancion.getIdCancion());
        service.modifacionBaseDatos(cadenaSql, message);
    }
    
    public void eliminarCancion(RowEditEvent event)  {
        Cancion datosCancion = (Cancion) event.getObject();
        String cadenaSql = "DELETE FROM public.cancion WHERE id_cancion" + "=" + datosCancion.getIdCancion() + ";";
        FacesMessage message = new FacesMessage("Se Elimino el artista: " + datosCancion.getIdCancion());
        service.modifacionBaseDatos(cadenaSql, message);
    }
    

    public List<Cancion> getListaCancion() {
        return listaCancion;
    }

    public void setListaCancion(List<Cancion> listaCancion) {
        this.listaCancion = listaCancion;
    }

    public Cancion getCancionFormulario() {
        return cancionFormulario;
    }

    public void setCancionFormulario(Cancion cancionFormulario) {
        this.cancionFormulario = cancionFormulario;
    }

    public List<Album> getListaAlbum() {
        return listaAlbum;
    }

    public void setListaAlbum(List<Album> listaAlbum) {
        this.listaAlbum = listaAlbum;
    }
    
    
}
