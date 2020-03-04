
package org.springframework.samples.petclinic.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Table(name = "bookroom")
@Entity
public class BookRoom extends NamedEntity {

	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private LocalDate	start;

	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private LocalDate	end;

	@ManyToOne
	private Pet			mascota;

	@ManyToOne
	private Owner		propietario;


	public LocalDate getStart() {
		return this.start;
	}

	public void setStart(final LocalDate start) {
		this.start = start;
	}

	public LocalDate getEnd() {
		return this.end;
	}

	public void setEnd(final LocalDate end) {
		this.end = end;
	}

	public Pet getMascota() {
		return this.mascota;
	}

	public void setMascota(final Pet mascota) {
		this.mascota = mascota;
	}

	public Owner getPropietario() {
		return this.propietario;
	}

	public void setPropietario(final Owner propietario) {
		this.propietario = propietario;
	}

}
