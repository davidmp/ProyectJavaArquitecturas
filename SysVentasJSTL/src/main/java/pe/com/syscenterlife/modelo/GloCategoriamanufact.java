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
@Table(name = "glo_categoriamanufact")
@NamedQueries({
    @NamedQuery(name = "GloCategoriamanufact.findAll", query = "SELECT g FROM GloCategoriamanufact g")})
public class GloCategoriamanufact implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCategoriamanufactura")
    private Integer idCategoriamanufactura;
    @Size(max = 30)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "estado")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCategoriamanufactura")
    private Collection<GloManufactura> gloManufacturaCollection;

    public GloCategoriamanufact() {
    }

    public GloCategoriamanufact(Integer idCategoriamanufactura) {
        this.idCategoriamanufactura = idCategoriamanufactura;
    }

    public GloCategoriamanufact(Integer idCategoriamanufactura, String estado) {
        this.idCategoriamanufactura = idCategoriamanufactura;
        this.estado = estado;
    }

    public Integer getIdCategoriamanufactura() {
        return idCategoriamanufactura;
    }

    public void setIdCategoriamanufactura(Integer idCategoriamanufactura) {
        this.idCategoriamanufactura = idCategoriamanufactura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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
        hash += (idCategoriamanufactura != null ? idCategoriamanufactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GloCategoriamanufact)) {
            return false;
        }
        GloCategoriamanufact other = (GloCategoriamanufact) object;
        if ((this.idCategoriamanufactura == null && other.idCategoriamanufactura != null) || (this.idCategoriamanufactura != null && !this.idCategoriamanufactura.equals(other.idCategoriamanufactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.com.syscenterlife.modelo.GloCategoriamanufact[ idCategoriamanufactura=" + idCategoriamanufactura + " ]";
    }
    
}
