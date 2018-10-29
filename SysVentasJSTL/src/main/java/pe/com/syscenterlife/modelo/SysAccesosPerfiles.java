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
@Table(name = "sys_accesos_perfiles")
@NamedQueries({
    @NamedQuery(name = "SysAccesosPerfiles.findAll", query = "SELECT s FROM SysAccesosPerfiles s")})
public class SysAccesosPerfiles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAccesosPerfiles")
    private Integer idAccesosPerfiles;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "estado")
    private String estado;
    @JoinColumn(name = "idAccesos", referencedColumnName = "idAccesos")
    @ManyToOne(optional = false)
    private SysAccesos idAccesos;
    @JoinColumn(name = "idPerfil", referencedColumnName = "idPerfil")
    @ManyToOne(optional = false)
    private SysPerfiles idPerfil;

    public SysAccesosPerfiles() {
    }

    public SysAccesosPerfiles(Integer idAccesosPerfiles) {
        this.idAccesosPerfiles = idAccesosPerfiles;
    }

    public SysAccesosPerfiles(Integer idAccesosPerfiles, String estado) {
        this.idAccesosPerfiles = idAccesosPerfiles;
        this.estado = estado;
    }

    public Integer getIdAccesosPerfiles() {
        return idAccesosPerfiles;
    }

    public void setIdAccesosPerfiles(Integer idAccesosPerfiles) {
        this.idAccesosPerfiles = idAccesosPerfiles;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public SysAccesos getIdAccesos() {
        return idAccesos;
    }

    public void setIdAccesos(SysAccesos idAccesos) {
        this.idAccesos = idAccesos;
    }

    public SysPerfiles getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(SysPerfiles idPerfil) {
        this.idPerfil = idPerfil;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAccesosPerfiles != null ? idAccesosPerfiles.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SysAccesosPerfiles)) {
            return false;
        }
        SysAccesosPerfiles other = (SysAccesosPerfiles) object;
        if ((this.idAccesosPerfiles == null && other.idAccesosPerfiles != null) || (this.idAccesosPerfiles != null && !this.idAccesosPerfiles.equals(other.idAccesosPerfiles))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.com.syscenterlife.modelo.SysAccesosPerfiles[ idAccesosPerfiles=" + idAccesosPerfiles + " ]";
    }
    
}
