/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Enum.StatusPedido;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;import javax.persistence.Temporal;
;

@Entity
public class Pedido implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPedido;
      
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataPedido;
   
    private Double valorTotal;
          
    @Enumerated(EnumType.STRING)
    private StatusPedido statusPedido; 
    
    @ManyToMany()
    private List<Componente> itensComponente;
    
    @ManyToOne()
    private Usuario usuarioDoPedido;

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public StatusPedido getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(StatusPedido statusPedido) {
        this.statusPedido = statusPedido;
    }

    public List<Componente> getItensComponente() {
        return itensComponente;
    }

    public void setItensComponente(List<Componente> itensComponente) {
        this.itensComponente = itensComponente;
    }

    public Usuario getUsuarioDoPedido() {
        return usuarioDoPedido;
    }

    public void setUsuarioDoPedido(Usuario usuarioDoPedido) {
        this.usuarioDoPedido = usuarioDoPedido;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    } 

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + this.idPedido;
        hash = 19 * hash + Objects.hashCode(this.dataPedido);
        hash = 19 * hash + Objects.hashCode(this.valorTotal);
        hash = 19 * hash + Objects.hashCode(this.statusPedido);
        hash = 19 * hash + Objects.hashCode(this.itensComponente);
        hash = 19 * hash + Objects.hashCode(this.usuarioDoPedido);
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
        final Pedido other = (Pedido) obj;
        if (this.idPedido != other.idPedido) {
            return false;
        }
        return true;
    }
      
}
