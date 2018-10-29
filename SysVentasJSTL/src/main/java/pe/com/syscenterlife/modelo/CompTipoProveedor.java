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
@Table(name = "comp_tipo_proveedor")
@NamedQueries({
    @NamedQuery(name = "CompTipoProveedor.findAll", query = "SELECT c FROM CompTipoProveedor c")})
public class CompTipoProveedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTipoProveedor")
    private Integer idTipoProveedor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private int estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoProveedor")
    private Collection<CompProveedores> compProveedoresCollection;

    public CompTipoProveedor() {
    }

    public CompTipoProveedor(Integer idTipoProveedor) {
        this.idTipoProveedor = idTipoProveedor;
    }

    public CompTipoProveedor(Integer idTipoProveedor, String nombre, int estado) {
        this.idTipoProveedor = idTipoProveedor;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Integer getIdTipoProveedor() {
        return idTipoProveedor;
    }

    public void setIdTipoProveedor(Integer idTipoProveedor) {
        this.idTipoProveedor = idTipoProveedor;
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

    public Collection<CompProveedores> getCompProveedoresCollection() {
        return compProveedoresCollection;
    }

    public void setCompProveedoresCollection(Collection<CompProveedores> compProveedoresCollection) {
        this.compProveedoresCollection = compProveedoresCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoProveedor != null ? idTipoProveedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompTipoProveedor)) {
            return false;
        }
        CompTipoProveedor other = (CompTipoProveedor) object;
        if ((this.idTipoProveedor == null && other.idTipoProveedor != null) || (this.idTipoProveedor != null && !this.idTipoProveedor.equals(other.idTipoProveedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.com.syscenterlife.modelo.CompTipoProveedor[ idTipoProveedor=" + idTipoProveedor + " ]";
    }
    
}
