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
public class Album {
    
    private Integer idAlbum;
    private String  nombreAlbum;
    private String  fechaAlbum;
    private String  formatoAlbum;
    private Integer precioAlbum;
    private Integer idArtista;
    private Integer idGenero;
    private String  nombreArtista;
    private String  nombreGenero;
    
    public Album() {
    }
    
    public Album( Integer idAlbum ,String  nombreAlbum,String nombreArtista,String nombreGenero, String formatoAlbum, String  fechaAlbum , Integer precioAlbum) {
    this.idAlbum=idAlbum;
    this.nombreAlbum=nombreAlbum;
    this.fechaAlbum=fechaAlbum;
    this.formatoAlbum=formatoAlbum;
    this.precioAlbum=precioAlbum;
    this.nombreArtista=nombreArtista;
    this.nombreGenero=nombreGenero;
    
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

    public String getFechaAlbum() {
        return fechaAlbum;
    }

    public void setFechaAlbum(String fechaAlbum) {
        this.fechaAlbum = fechaAlbum;
    }

    public String getFormatoAlbum() {
        return formatoAlbum;
    }

    public void setFormatoAlbum(String formatoAlbum) {
        this.formatoAlbum = formatoAlbum;
    }

    public Integer getPrecioAlbum() {
        return precioAlbum;
    }

    public void setPrecioAlbum(Integer precioAlbum) {
        this.precioAlbum = precioAlbum;
    }

    public Integer getIdArtista() {
        return idArtista;
    }

    public void setIdArtista(Integer idArtista) {
        this.idArtista = idArtista;
    }

    public Integer getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(Integer idGenero) {
        this.idGenero = idGenero;
    }

    public String getNombreArtista() {
        return nombreArtista;
    }

    public void setNombreArtista(String nombreArtista) {
        this.nombreArtista = nombreArtista;
    }

    public String getNombreGenero() {
        return nombreGenero;
    }

    public void setNombreGenero(String nombreGenero) {
        this.nombreGenero = nombreGenero;
    }
    
    @Override
    public String toString(){
        return this.nombreAlbum;
    }
}
