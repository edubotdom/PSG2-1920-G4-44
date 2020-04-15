
package org.springframework.samples.petclinic.repository;

import java.util.Set;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.samples.petclinic.model.BookRoom;

public interface BookRoomRepository extends CrudRepository<BookRoom, Integer> {

	BookRoom findBookRoomById(int id);
	
	void delete(BookRoom bookroom) throws DataAccessException;

	@Query("SELECT bkt FROM BookRoom bkt WHERE bkt.pet.id=?1")
	Set<BookRoom> findAllByPetId(@Param("petId") int petId) throws DataAccessException;
	
	@Query("SELECT bkt FROM BookRoom bkt WHERE bkt.owner.id=?1")
	Set<BookRoom> findAllByOwnerId(@Param("ownerId") int ownerId) throws DataAccessException;
	

}
