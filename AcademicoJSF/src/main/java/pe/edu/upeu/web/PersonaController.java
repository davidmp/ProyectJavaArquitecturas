/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.web;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pe.edu.upeu.modelo.Persona;
import pe.edu.upeu.repositorio.PersonaRepository;

/**
 *
 * @author davidmp
 */
@Component("personaController")
@Scope("request")
public class PersonaController {
    @Autowired
    PersonaRepository resPersonaRepository; 

    @Getter @Setter
    private Persona persona;

    @Getter @Setter
    public List<Persona> listPersona;

    @PostConstruct
    public void init() {
            persona = new Persona();
            listPersona = new ArrayList<>();
            listPersona=findAllBooks();
    }
        
    public String submit() {
            if (persona.getNombre() != null && persona.getApellidos() != null && persona.getDni() != null
                            && persona.getTelefono() != null) {
                    //persona.setToken(UUID.randomUUID().toString());

                    resPersonaRepository.save(persona);
                FacesContext.getCurrentInstance().addMessage("errors",
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Book created",
                    "The book " + persona.getNombre()+ " has been created with id=" + persona.getIdPersona()));                        
            } else {
                    FacesContext.getCurrentInstance().addMessage(null,
                                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning", "Debe rellenar todos los campos."));
            }
            listPersona=findAllBooks();
            return "index.xhtml?faces-redirect=true";
    }  
        
    public List<Persona> findAllBooks() {
        return resPersonaRepository.findAll();
    } 
    
    public void reset() {
            persona = new Persona();
    }    
}
