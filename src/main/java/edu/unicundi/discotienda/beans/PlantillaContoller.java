package edu.unicundi.discotienda.beans;

import edu.unicundi.discotienda.model.Administrador;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@Named(value = "plantillaContoller")
@RequestScoped
public class PlantillaContoller {

    public PlantillaContoller() {
    }

    public void validarSesion() {

        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance()
                .getExternalContext().getRequest();
        String url = req.getRequestURL().toString();
        System.out.println("MIRAR AQUI" + url);

        if (url.contains("albumUsuario.xhtml") || url.contains("cancionUsuario.xhtml")) {

        } else {
            Administrador us = (Administrador) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
            if (us != null) {
                if (url.contains("album.xhtml") || url.contains("index.xhtml") || url.contains("cancion.xhtml")) {

                } else {
                    redireccionarNoAutorizado();
                }
            } else {
                redireccionarNoAutorizado();
            }
        }

    }

    public void redireccionarNoAutorizado() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("errorCredencial.xhtml");
        } catch (IOException ex) {
            //Logger.getLogger(CrearArtista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
