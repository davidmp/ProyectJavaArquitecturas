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
@Table(name = "comp_despachos")
@NamedQueries({
    @NamedQuery(name = "CompDespachos.findAll", query = "SELECT c FROM CompDespachos c")})
public class CompDespachos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProbDespachos")
    private Integer idProbDespachos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "direccion")
    private String direccion;
    @JoinColumn(name = "idProveedor", referencedColumnName = "idProveedor")
    @ManyToOne(optional = false)
    private CompProveedores idProveedor;

    public CompDespachos() {
    }

    public CompDespachos(Integer idProbDespachos) {
        this.idProbDespachos = idProbDespachos;
    }

    public CompDespachos(Integer idProbDespachos, String direccion) {
        this.idProbDespachos = idProbDespachos;
        this.direccion = direccion;
    }

    public Integer getIdProbDespachos() {
        return idProbDespachos;
    }

    public void setIdProbDespachos(Integer idProbDespachos) {
        this.idProbDespachos = idProbDespachos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public CompProveedores getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(CompProveedores idProveedor) {
        this.idProveedor = idProveedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProbDespachos != null ? idProbDespachos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompDespachos)) {
            return false;
        }
        CompDespachos other = (CompDespachos) object;
        if ((this.idProbDespachos == null && other.idProbDespachos != null) || (this.idProbDespachos != null && !this.idProbDespachos.equals(other.idProbDespachos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.com.syscenterlife.modelo.CompDespachos[ idProbDespachos=" + idProbDespachos + " ]";
    }
    
}
