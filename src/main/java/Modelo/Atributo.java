/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


 /**
 *
 * @author devops
 */


public class Atributo implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(length = 100, nullable = false, updatable = true, insertable = true)
    private String nomeAtributo;
    
    @Column(length = 100, nullable = false, updatable = true, insertable = true)
    private double valor;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Componente_Atributo")
    private List<Componente> componentes;

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

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public List<Componente> getComponentes() {
        return componentes;
    }

    public void setComponentes(List<Componente> componentes) {
        this.componentes = componentes;
    }

    
    
}
