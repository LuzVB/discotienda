/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.discotienda.beans;

import edu.unicundi.discotienda.beans.logica.DatosArtista;
import edu.unicundi.discotienda.model.Artista;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Luz
 */
@Named(value = "inicio")
@RequestScoped
public class inicio implements Serializable {

    private List<Artista> listaArtista;
    private Artista artistaFormulario;

    @Inject
    private DatosArtista service;

    public inicio() {
    }

    @PostConstruct
    public void inicio() {
        listarArtista();
        this.listaArtista = service.getListaArtista();
        artistaFormulario = new Artista();
    }

    public void insertarArtista() {
        String cadenaSql = "INSERT INTO public.artista(id_artista, nombre_artista, pais_artista, fecha_nacimiento)"
                + "VALUES ((SELECT MAX(id_artista)+1 as id_artista FROM public.artista)," + "'" + artistaFormulario.getNombre() + "'," + "'" + artistaFormulario.getPais() + "'" + ",'" + artistaFormulario.getFechaNacimiento() + "');";
//                    "INSERT INTO public.artista(id_artista, nombre_artista, pais_artista, fecha_nacimiento)"
//                    + "VALUES  ((SELECT MAX(id_artista)+1 as id_artista FROM public.artista),'" + artista.getNombre() + "','" + artista.getPais() + "','1959-08-11')";
        FacesMessage message = new FacesMessage("Se inserto correctamente");
        service.modifacionBaseDatos(cadenaSql, message);
    }

    public void listarArtista() {
        try {
            service.listar();
        } catch (SQLException ex) {
            Logger.getLogger(inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void actualizarArtista(RowEditEvent event) {
        Artista datosArtista = (Artista) event.getObject();
        String cadenaSql = "UPDATE public.artista SET nombre_artista='" + datosArtista.getNombre() + "',pais_artista='" + datosArtista.getPais() + "',fecha_nacimiento='" + datosArtista.getFechaNacimiento() + "' WHERE id_artista=" + datosArtista.getId() + ";";
        FacesMessage message = new FacesMessage("Editó el asrtista con id: " + datosArtista.getId());
        service.modifacionBaseDatos(cadenaSql, message);
    }

    public void eliminarArtista(RowEditEvent event) {
        Artista datosArtista = (Artista) event.getObject();
        String cadenaSql = "DELETE FROM public.artista WHERE id_artista" + "=" + datosArtista.getId() + ";";
        FacesMessage message = new FacesMessage("Se Elimino el artista: " + datosArtista.getId());
        service.modifacionBaseDatos(cadenaSql, message);
    }

    public void cancelar(RowEditEvent event) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cancelar"));
    }

    public Artista getArtistaFormulario() {
        return artistaFormulario;
    }

    public void setArtistaFormulario(Artista artistaFormulario) {
        this.artistaFormulario = artistaFormulario;
    }

    public List<Artista> getListaArtista() {
        return listaArtista;
    }

    public void setListaArtista(List<Artista> listaArtista) {
        this.listaArtista = listaArtista;
    }

}
