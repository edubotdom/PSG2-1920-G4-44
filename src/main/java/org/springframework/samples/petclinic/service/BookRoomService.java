
package org.springframework.samples.petclinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.repository.BookRoomRepository;
import org.springframework.stereotype.Service;

@Service
public class BookRoomService {

	@Autowired
	private BookRoomRepository repository;

}
