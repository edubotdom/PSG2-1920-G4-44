
package org.springframework.samples.petclinic.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Table(name = "bookroom")
@Entity
public class BookRoom extends BaseEntity {
	
	@Column(name =  "date_of_start")
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private LocalDate	start;
	
	@Column(name =  "date_of_end")
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private LocalDate	end;

	@ManyToOne
	@JoinColumn(name = "pet_id")
	private Pet			pet;

	@ManyToOne
	@JoinColumn(name = "owner_id")
	private Owner		owner;

	private Integer		idO;

	private Integer		idP;


	public Integer getOwnerId() {
		return this.idO;
	}

	public void setOwnerId(final Integer ownerId) {
		this.idO = ownerId;
	}

	public Integer getPetId() {
		return this.idP;
	}

	public void setPetId(final Integer petId) {
		this.idP = petId;
	}

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
