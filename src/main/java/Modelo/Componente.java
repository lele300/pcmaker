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
import javax.persistence.ManyToMany;

/**
 *
 * @author devops
 */

@Entity
public class Componente implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(length = 100, nullable = false, insertable = true, updatable = true, unique = true)
    private String nome;
    
    @Column(length = 100, nullable = false, insertable = true, updatable = true)
    private String marca;
    
    @Column(length = 50, nullable = false, insertable = true, updatable = true)
    private String modelo;
    
    @Column(length = 512, nullable = false, insertable = true, updatable = true)
    private String descricao;
    
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "componente")
    private List<Atributo> atributos;

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

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Atributo> getAtributos() {
        return atributos;
    }

    public void setAtributos(List<Atributo> atributos) {
        this.atributos = atributos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + this.id;
        hash = 61 * hash + Objects.hashCode(this.nome);
        hash = 61 * hash + Objects.hashCode(this.marca);
        hash = 61 * hash + Objects.hashCode(this.modelo);
        hash = 61 * hash + Objects.hashCode(this.descricao);
        hash = 61 * hash + Objects.hashCode(this.atributos);
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
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.marca, other.marca)) {
            return false;
        }
        if (!Objects.equals(this.modelo, other.modelo)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        return Objects.equals(this.atributos, other.atributos);
    }

    @Override
    public String toString() {
        return "Componente{" + "id=" + id + ", nome=" + nome + ", marca=" + marca + ", modelo=" + modelo + ", descricao=" + descricao + ", atributos=" + atributos + '}';
    }

    
}
    
    