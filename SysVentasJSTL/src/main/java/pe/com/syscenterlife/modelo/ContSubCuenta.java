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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "cont_sub_cuenta")
@NamedQueries({
    @NamedQuery(name = "ContSubCuenta.findAll", query = "SELECT c FROM ContSubCuenta c")})
public class ContSubCuenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSubCuenta")
    private Integer idSubCuenta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "cuenta")
    private String cuenta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "estado")
    private String estado;
    @JoinColumn(name = "idCuenta", referencedColumnName = "idCuenta")
    @ManyToOne(optional = false)
    private ContCuenta idCuenta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSubCuenta")
    private Collection<ContDivision> contDivisionCollection;

    public ContSubCuenta() {
    }

    public ContSubCuenta(Integer idSubCuenta) {
        this.idSubCuenta = idSubCuenta;
    }

    public ContSubCuenta(Integer idSubCuenta, String cuenta, String descripcion, String estado) {
        this.idSubCuenta = idSubCuenta;
        this.cuenta = cuenta;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public Integer getIdSubCuenta() {
        return idSubCuenta;
    }

    public void setIdSubCuenta(Integer idSubCuenta) {
        this.idSubCuenta = idSubCuenta;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public ContCuenta getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(ContCuenta idCuenta) {
        this.idCuenta = idCuenta;
    }

    public Collection<ContDivision> getContDivisionCollection() {
        return contDivisionCollection;
    }

    public void setContDivisionCollection(Collection<ContDivision> contDivisionCollection) {
        this.contDivisionCollection = contDivisionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSubCuenta != null ? idSubCuenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContSubCuenta)) {
            return false;
        }
        ContSubCuenta other = (ContSubCuenta) object;
        if ((this.idSubCuenta == null && other.idSubCuenta != null) || (this.idSubCuenta != null && !this.idSubCuenta.equals(other.idSubCuenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.com.syscenterlife.modelo.ContSubCuenta[ idSubCuenta=" + idSubCuenta + " ]";
    }
    
}
