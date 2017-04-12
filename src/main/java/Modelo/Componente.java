/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author devops
 */
public class Componente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(length = 255, nullable = false, insertable = true, updatable = true, unique = true)
    private String nome;
    
    @OneToMany(cascade = CascadeType.ALL , mappedBy = "componente")
    private TipoComponente tipoComponente;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoAtributo")
    private ArrayList<Atributo> atributos;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoComponente getTipoComponente() {
        return tipoComponente;
    }

    public void setTipoComponente(TipoComponente tipoComponente) {
        this.tipoComponente = tipoComponente;
    }

    public ArrayList<Atributo> getAtributo() {
        return atributos;
    }

    public void setAtributo(ArrayList<Atributo> atributo) {
        this.atributos = atributo;
    }
    
     @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Componente other = (Componente) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
}
