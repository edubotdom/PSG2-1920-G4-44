
package org.springframework.samples.petclinic.service;

import java.time.LocalDate;
import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.BookRoom;
import org.springframework.samples.petclinic.repository.BookRoomRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookRoomService {

	@Autowired
	private BookRoomRepository repository;
	

	@Transactional
	public void saveBookRoom(final BookRoom bookroom) {
		this.repository.save(bookroom);
	}

	public BookRoom findBookRoomById(final int id) throws DataAccessException {
		return this.repository.findBookRoomById(id);
	}

	@Transactional(readOnly = true)
	@Cacheable(value = "bookroom")
	public Iterable<BookRoom> findAll() throws DataAccessException {
		return this.repository.findAll();
	}
	
	@Transactional
	public void deleteBookRoom(BookRoom bookRoom) throws DataAccessException {
		repository.delete(bookRoom);
	}
	
	@Transactional
	public Set<BookRoom> findBookRoomByPetId(int petId) throws DataAccessException {
		return this.repository.findAllByPetId(petId);
	}

	@Transactional
	public boolean sePuedeReservar(BookRoom bookroom) throws DataAccessException{
		Set<BookRoom> reservas = this.findBookRoomByPetId(bookroom.getPetId());

			boolean sePuedeReservar= true;
			LocalDate start= bookroom.getStart();
			LocalDate end= bookroom.getEnd();

			for(BookRoom r: reservas) {
				LocalDate startR = r.getStart();
				LocalDate endR = r.getEnd();

				boolean reservaPrevia = (start.isBefore(startR)&& end.isBefore(startR));
				boolean reservaPosterior = (start.isAfter(endR) && end.isAfter(endR));
				boolean coincidePrincipioFinal = (start.equals(startR)) || (end.equals(endR));
				
				if(!(reservaPrevia&&!coincidePrincipioFinal || reservaPosterior&&!coincidePrincipioFinal)){
					sePuedeReservar = false;
					break;
				}else {
					sePuedeReservar=true;
				}
				
			}
			return sePuedeReservar;
	}
}
