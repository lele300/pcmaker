/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author leo_l
 */

public class TipoAtributo implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(length = 100, insertable = true, updatable = true, nullable = false)
    private String nomeAtributo;
    
    //Um tipoAtributo está associado á vários atributos
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoAtributo")
    private List<Atributo> atributos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeAtributo() {
        return nomeAtributo;
    }

    public void setNomeAtributo(String nomeAtributo) {
        this.nomeAtributo = nomeAtributo;
    }

    public List<Atributo> getAtributo() {
        return atributos;
    }

    public void setAtributo(List<Atributo> atributos) {
        this.atributos = atributos;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.id;
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
        final TipoAtributo other = (TipoAtributo) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nomeAtributo, other.nomeAtributo)) {
            return false;
        }
        if (!Objects.equals(this.atributos, other.atributos)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TipoAtributo{" + "id=" + id + ", nomeAtributo=" + nomeAtributo + ", atributo=" + atributos + '}';
    }
    
}
