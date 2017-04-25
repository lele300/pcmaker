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
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author leo_l
 */

@Entity
public class Componente implements Serializable {
    
    @Id
    @GeneratedValue
    private int id;
    
    @Column(length = 100, insertable = true, updatable = true, nullable = false)
    private String modelo;
    
    @Column(length = 100, insertable = true, updatable = true, nullable = false)
    private String marca;
    
    @Column(length = 3, insertable = true, updatable = true, nullable = false)
    private int quantidade;
    
    @Column(length = 255, insertable = true, updatable = true, nullable = false)
    private String descricao;
    
    //Um componente só pode estar associado á um tipoComponente
    @ManyToOne(cascade = CascadeType.ALL)
    private TipoComponente tipoComponente;
    
    //Um componente pode estar associado á vários atributos
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "componentes")
    private List<Atributo> listaAtributo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Atributo> getListaAtributo() {
        return listaAtributo;
    }

    public void setListaAtributo(List<Atributo> listaAtributo) {
        this.listaAtributo = listaAtributo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + this.id;
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
        if (this.quantidade != other.quantidade) {
            return false;
        }
        if (!Objects.equals(this.modelo, other.modelo)) {
            return false;
        }
        if (!Objects.equals(this.marca, other.marca)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.listaAtributo, other.listaAtributo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Componente{" + "id=" + id + ", modelo=" + modelo + ", marca=" + marca + ", quantidade=" + quantidade + ", descricao=" + descricao + ", listaAtributo=" + listaAtributo + '}';
    }
    
}
