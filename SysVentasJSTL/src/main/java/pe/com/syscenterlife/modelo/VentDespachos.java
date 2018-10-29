/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author davidmp
 */
@Entity
@Table(name = "vent_despachos")
@NamedQueries({
    @NamedQuery(name = "VentDespachos.findAll", query = "SELECT v FROM VentDespachos v")})
public class VentDespachos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDespachos")
    private Integer idDespachos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "direccion")
    private String direccion;
    @JoinColumn(name = "idCliente", referencedColumnName = "idCliente")
    @ManyToOne(optional = false)
    private VentClientes idCliente;

    public VentDespachos() {
    }

    public VentDespachos(Integer idDespachos) {
        this.idDespachos = idDespachos;
    }

    public VentDespachos(Integer idDespachos, String direccion) {
        this.idDespachos = idDespachos;
        this.direccion = direccion;
    }

    public Integer getIdDespachos() {
        return idDespachos;
    }

    public void setIdDespachos(Integer idDespachos) {
        this.idDespachos = idDespachos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public VentClientes getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(VentClientes idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDespachos != null ? idDespachos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentDespachos)) {
            return false;
        }
        VentDespachos other = (VentDespachos) object;
        if ((this.idDespachos == null && other.idDespachos != null) || (this.idDespachos != null && !this.idDespachos.equals(other.idDespachos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.com.syscenterlife.modelo.VentDespachos[ idDespachos=" + idDespachos + " ]";
    }
    
}
