/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.discotienda.model;

import java.util.Date;

/**
 *
 * @author Luz
 */
public class Artista {

    private Integer id;

    private String nombre;

    private String pais;

    private String fechaNacimiento;
    
    public Artista(){
    
    }

    public Artista(int id, String nombre, String pais, String fechaNacimiento) {
      this.id=id;
      this.nombre=nombre;
      this.pais=pais;
      this.fechaNacimiento=fechaNacimiento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    
    @Override
    public String toString(){
        return this.nombre;
    }
}
