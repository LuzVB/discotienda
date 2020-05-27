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
public class Cancion {

    private Integer idCancion;
    private String  nombreCancion;
    private String  duracionCancion;
    private Integer precioCancion;
    private Integer idAlbum;
    private String  nombreAlbum;
    
    public Cancion() {
    }
    
    public Cancion(Integer idCancion ,String nombreAlbum, String nombreCancion , String duracionCancion,  Integer precioCancion) {
      this.idCancion=idCancion;
      this.nombreCancion=nombreCancion;
      this.duracionCancion=duracionCancion;
      this.precioCancion=precioCancion;
      this.nombreAlbum=nombreAlbum;
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
    
}
