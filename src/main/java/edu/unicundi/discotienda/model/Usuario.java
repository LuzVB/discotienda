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
public class Usuario {
    
    private Integer idCancion;
    private String  nombreCancion;
    private String  duracionCancion;
    private Integer precioCancion;
    private Integer idAlbum;
    private String  nombreAlbum;
    private String  nombreArtista;
    private String  formato;
    
    public Usuario() {
    }
    

    public Usuario(Integer idCancion, String nombreArtista, String nombreAlbum, String nombreCancion,String duracionCancion, String formato, Integer precioCancion, Integer idAlbum) {
        this.idCancion = idCancion;
        this.nombreArtista = nombreArtista;
        this.nombreAlbum = nombreAlbum;
        this.nombreCancion = nombreCancion;
        this.duracionCancion=duracionCancion;
        this.formato = formato;
        this.precioCancion = precioCancion;
        this.idAlbum = idAlbum;
    }

    public Integer getIdCancion() {
        return idCancion;
    }

    public void setIdCancion(Integer idCancion) {
        this.idCancion = idCancion;
    }

    public String getNombreCancion() {
        return nombreCancion;
    }

    public void setNombreCancion(String nombreCancion) {
        this.nombreCancion = nombreCancion;
    }

    public String getDuracionCancion() {
        return duracionCancion;
    }

    public void setDuracionCancion(String duracionCancion) {
        this.duracionCancion = duracionCancion;
    }

    public Integer getPrecioCancion() {
        return precioCancion;
    }

    public void setPrecioCancion(Integer precioCancion) {
        this.precioCancion = precioCancion;
    }

    public Integer getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(Integer idAlbum) {
        this.idAlbum = idAlbum;
    }

    public String getNombreAlbum() {
        return nombreAlbum;
    }

    public void setNombreAlbum(String nombreAlbum) {
        this.nombreAlbum = nombreAlbum;
    }

    public String getNombreArtista() {
        return nombreArtista;
    }

    public void setNombreArtista(String nombreArtista) {
        this.nombreArtista = nombreArtista;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }
    
    
}
