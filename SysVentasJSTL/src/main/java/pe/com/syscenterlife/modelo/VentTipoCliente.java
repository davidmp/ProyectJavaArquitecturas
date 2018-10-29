/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author davidmp
 */
@Entity
@Table(name = "vent_tipo_cliente")
@NamedQueries({
    @NamedQuery(name = "VentTipoCliente.findAll", query = "SELECT v FROM VentTipoCliente v")})
public class VentTipoCliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTipoCliente")
    private Integer idTipoCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private int estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoCliente")
    private Collection<VentClientes> ventClientesCollection;

    public VentTipoCliente() {
    }

    public VentTipoCliente(Integer idTipoCliente) {
        this.idTipoCliente = idTipoCliente;
    }

    public VentTipoCliente(Integer idTipoCliente, String nombre, int estado) {
        this.idTipoCliente = idTipoCliente;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Integer getIdTipoCliente() {
        return idTipoCliente;
    }

    public void setIdTipoCliente(Integer idTipoCliente) {
        this.idTipoCliente = idTipoCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Collection<VentClientes> getVentClientesCollection() {
        return ventClientesCollection;
    }

    public void setVentClientesCollection(Collection<VentClientes> ventClientesCollection) {
        this.ventClientesCollection = ventClientesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoCliente != null ? idTipoCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentTipoCliente)) {
            return false;
        }
        VentTipoCliente other = (VentTipoCliente) object;
        if ((this.idTipoCliente == null && other.idTipoCliente != null) || (this.idTipoCliente != null && !this.idTipoCliente.equals(other.idTipoCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.com.syscenterlife.modelo.VentTipoCliente[ idTipoCliente=" + idTipoCliente + " ]";
    }
    
}
