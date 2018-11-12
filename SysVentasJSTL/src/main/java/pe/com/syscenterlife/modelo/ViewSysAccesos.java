/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Getter;

import lombok.Setter;

/**
 *
 * @author davidmp
 */
@Entity
@Getter @Setter
public class ViewSysAccesos implements Serializable {
@Id   
int idAccesos;

int nroOrden,idMenu,estado, estadopri;
String nombre, url,codigoSeg, nombremenu;

}
