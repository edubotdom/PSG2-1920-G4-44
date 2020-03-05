
package org.springframework.samples.petclinic.service;

import java.util.Optional;

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

	public Optional<BookRoom> findBookRoomById(final int id) throws DataAccessException {
		return this.repository.findById(id);
	}

	@Transactional(readOnly = true)
	@Cacheable(value = "bookroom")
	public Iterable<BookRoom> findAll() throws DataAccessException {
		return this.repository.findAll();
	}

}
