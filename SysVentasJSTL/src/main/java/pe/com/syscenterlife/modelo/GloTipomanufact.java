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
@Table(name = "glo_tipomanufact")
@NamedQueries({
    @NamedQuery(name = "GloTipomanufact.findAll", query = "SELECT g FROM GloTipomanufact g")})
public class GloTipomanufact implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTipomanufact")
    private Integer idTipomanufact;
    @Size(max = 60)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private int estado;
    @Size(max = 15)
    @Column(name = "tipo")
    private String tipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipomanufact")
    private Collection<GloManufactura> gloManufacturaCollection;

    public GloTipomanufact() {
    }

    public GloTipomanufact(Integer idTipomanufact) {
        this.idTipomanufact = idTipomanufact;
    }

    public GloTipomanufact(Integer idTipomanufact, int estado) {
        this.idTipomanufact = idTipomanufact;
        this.estado = estado;
    }

    public Integer getIdTipomanufact() {
        return idTipomanufact;
    }

    public void setIdTipomanufact(Integer idTipomanufact) {
        this.idTipomanufact = idTipomanufact;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Collection<GloManufactura> getGloManufacturaCollection() {
        return gloManufacturaCollection;
    }

    public void setGloManufacturaCollection(Collection<GloManufactura> gloManufacturaCollection) {
        this.gloManufacturaCollection = gloManufacturaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipomanufact != null ? idTipomanufact.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GloTipomanufact)) {
            return false;
        }
        GloTipomanufact other = (GloTipomanufact) object;
        if ((this.idTipomanufact == null && other.idTipomanufact != null) || (this.idTipomanufact != null && !this.idTipomanufact.equals(other.idTipomanufact))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.com.syscenterlife.modelo.GloTipomanufact[ idTipomanufact=" + idTipomanufact + " ]";
    }
    
}
