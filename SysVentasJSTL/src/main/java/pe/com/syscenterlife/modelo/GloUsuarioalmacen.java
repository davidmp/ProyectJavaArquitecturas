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
@Table(name = "glo_usuarioalmacen")
@NamedQueries({
    @NamedQuery(name = "GloUsuarioalmacen.findAll", query = "SELECT g FROM GloUsuarioalmacen g")})
public class GloUsuarioalmacen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idUsuarioAlamacen")
    private Integer idUsuarioAlamacen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "estado")
    private String estado;
    @JoinColumn(name = "idAlmacen", referencedColumnName = "idAlmacen")
    @ManyToOne(optional = false)
    private GloAlmacen idAlmacen;
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private GloUsuario idUsuario;

    public GloUsuarioalmacen() {
    }

    public GloUsuarioalmacen(Integer idUsuarioAlamacen) {
        this.idUsuarioAlamacen = idUsuarioAlamacen;
    }

    public GloUsuarioalmacen(Integer idUsuarioAlamacen, String estado) {
        this.idUsuarioAlamacen = idUsuarioAlamacen;
        this.estado = estado;
    }

    public Integer getIdUsuarioAlamacen() {
        return idUsuarioAlamacen;
    }

    public void setIdUsuarioAlamacen(Integer idUsuarioAlamacen) {
        this.idUsuarioAlamacen = idUsuarioAlamacen;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public GloAlmacen getIdAlmacen() {
        return idAlmacen;
    }

    public void setIdAlmacen(GloAlmacen idAlmacen) {
        this.idAlmacen = idAlmacen;
    }

    public GloUsuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(GloUsuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuarioAlamacen != null ? idUsuarioAlamacen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GloUsuarioalmacen)) {
            return false;
        }
        GloUsuarioalmacen other = (GloUsuarioalmacen) object;
        if ((this.idUsuarioAlamacen == null && other.idUsuarioAlamacen != null) || (this.idUsuarioAlamacen != null && !this.idUsuarioAlamacen.equals(other.idUsuarioAlamacen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.com.syscenterlife.modelo.GloUsuarioalmacen[ idUsuarioAlamacen=" + idUsuarioAlamacen + " ]";
    }
    
}
