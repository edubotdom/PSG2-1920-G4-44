
package org.springframework.samples.petclinic.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Table(name = "bookroom")
@Entity
public class BookRoom extends BaseEntity {

	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private LocalDate	start;

	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private LocalDate	end;

	@ManyToOne
	private Pet			pet;

	@ManyToOne
	private Owner		owner;


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

	public Pet getPet() {
		return this.pet;
	}

	public void setPet(final Pet pet) {
		this.pet = pet;
	}

	public Owner getOwner() {
		return this.owner;
	}

	public void setOwner(final Owner owner) {
		this.owner = owner;
	}

}
