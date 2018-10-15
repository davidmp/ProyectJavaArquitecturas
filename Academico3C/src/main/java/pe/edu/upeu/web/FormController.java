package pe.edu.upeu.web;

import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import pe.edu.upeu.entities.Reserva;
import pe.edu.upeu.repositories.ReservaRepository;
import java.util.ArrayList;
import java.util.List;

@Component("formController")
@Scope("request")
public class FormController {

	@Autowired
	ReservaRepository reservaRepository;

	private Reserva reserva;

        public List<Reserva> book;
        
	@PostConstruct
	public void init() {
		reserva = new Reserva();
                book = new ArrayList<>();
                book=findAllBooks();
	}

	public String submit() {
		if (reserva.getNombre() != null && reserva.getEmail() != null && reserva.getFechaEntrada() != null
				&& reserva.getFechaSalida() != null) {
			reserva.setToken(UUID.randomUUID().toString());

			reservaRepository.save(reserva);
                    FacesContext.getCurrentInstance().addMessage("errors",
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Book created",
                        "The book " + reserva.getNombre()+ " has been created with id=" + reserva.getId()));                        
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning", "Debe rellenar todos los campos."));
		}
                book=findAllBooks();
                return "index.xhtml";
	}

        public List<Reserva> findAllBooks() {

            for(Reserva entity : reservaRepository.findAll()) {
                Reserva view = new Reserva();
                view.setId(entity.getId());
                view.setNombre(entity.getNombre());
                view.setEmail(entity.getEmail());
                view.setToken(entity.getToken());
                view.setFechaEntrada(entity.getFechaEntrada());
                view.setFechaSalida(entity.getFechaSalida());
                book.add(view);
            }
            return book;
        }        
        
        
        
	public void reset() {
		reserva = new Reserva();
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

        public List<Reserva> getBook() {
            return book;
        }

        public void setBook(List<Reserva> book) {
            this.book = book;
        }

}
