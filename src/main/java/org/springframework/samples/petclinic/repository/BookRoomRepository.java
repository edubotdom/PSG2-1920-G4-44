
package org.springframework.samples.petclinic.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.samples.petclinic.model.BookRoom;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRoomRepository extends CrudRepository<BookRoom, Integer> {

}
