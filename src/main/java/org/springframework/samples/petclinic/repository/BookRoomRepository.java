
package org.springframework.samples.petclinic.repository;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.CrudRepository;
import org.springframework.samples.petclinic.model.BookRoom;
import org.springframework.samples.petclinic.model.Pet;

public interface BookRoomRepository extends CrudRepository<BookRoom, Integer> {

	BookRoom findBookRoomById(int Id);
	
	void delete(BookRoom bookroom) throws DataAccessException;

}
