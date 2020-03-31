
package org.springframework.samples.petclinic.web;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.validation.Valid;

import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.BookRoom;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.service.BookRoomService;
import org.springframework.samples.petclinic.service.ClinicService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bookroom")
public class BookRoomController {

	private static final String	CREATE_BOOKROOM_FORM	= "bookrooms/form";
	private static final String	LIST_BOOKROOM_FORM		= "bookrooms/list";
	private static final String	SHOW_BOOKROOM_FORM		= "bookrooms/show";

	@Autowired
	private BookRoomService		bookroomService;

	@Autowired
	private ClinicService		clinicService;


	@GetMapping(value = "/new/{ownerId}/{petId}")
	public String initCreationFrom(final Map<String, Object> model, @PathVariable("ownerId") final int ownerId, @PathVariable("petId") final int petId) {
		BookRoom bookroom = new BookRoom();
		Owner owner = this.clinicService.findOwnerById(ownerId);
		Pet pet = this.clinicService.findPetById(petId);
		bookroom.setPet(pet);
		bookroom.setOwner(owner);
		model.put("owner", bookroom.getOwner().getId());
		model.put("pet", bookroom.getPet().getId());
		model.put("bookroom", bookroom);
		return BookRoomController.CREATE_BOOKROOM_FORM;
	}

	@PostMapping(value = "/save/")
	public String processCreationForm(@Valid final BookRoom bookroom, final BindingResult result, final ModelMap modelMap) {

		Set<BookRoom> reservas = new HashSet<BookRoom>();
		for(BookRoom r: this.bookroomService.findAll() ) {
			if(r.getPetId() == bookroom.getPetId()) {
				reservas.add(r);
			}
		}
			boolean sePuedeReservar =true;
			LocalDate start= bookroom.getStart();
			LocalDate end= bookroom.getEnd();

			for(BookRoom r: reservas) {
				LocalDate startR = r.getStart();
				LocalDate endR = r.getEnd();
				if((start.isBefore(endR)&& start.isAfter(startR)) ||
						(end.isBefore(endR) && end.isAfter(startR))){
					sePuedeReservar = false;
					break;
				}
			}		
		if (result.hasErrors()) {
			Owner owner = this.clinicService.findOwnerById(bookroom.getOwnerId());
			Pet pet = this.clinicService.findPetById(bookroom.getPetId());
			bookroom.setOwner(owner);
			bookroom.setPet(pet);
			modelMap.addAttribute("bookroom", bookroom);
			return BookRoomController.CREATE_BOOKROOM_FORM;
		  } else {

			if ((!bookroom.getStart().isBefore(bookroom.getEnd())) || (sePuedeReservar =false) ) {
				Owner owner = this.clinicService.findOwnerById(bookroom.getOwnerId());
				Pet pet = this.clinicService.findPetById(bookroom.getPetId());
				bookroom.setOwner(owner);
				bookroom.setPet(pet);
				boolean error = true;
				modelMap.addAttribute("dateError", error);
				modelMap.addAttribute("bookroom", bookroom);
				return BookRoomController.CREATE_BOOKROOM_FORM;
				
			} else {
				Owner owner = this.clinicService.findOwnerById(bookroom.getOwnerId());
				Pet pet = this.clinicService.findPetById(bookroom.getPetId());
				bookroom.setOwner(owner);
				bookroom.setPet(pet);
				this.bookroomService.saveBookRoom(bookroom);
				modelMap.addAttribute("message", "Event sucesfully added!");
				return this.listBookRoom(modelMap);
			}
		}

	}

	@GetMapping()
	public String listBookRoom(final ModelMap modelMap) {
		Iterable<BookRoom> bookrooms = this.bookroomService.findAll();
		modelMap.addAttribute("bookrooms", bookrooms);
		return BookRoomController.LIST_BOOKROOM_FORM;

	}

	@GetMapping("/{bookroomId}")
	public String showBookRoom(final Map<String, Object> model, @PathVariable("bookroomId") final int bookroomId) {
		BookRoom bookroom = this.bookroomService.findBookRoomById(bookroomId);
		model.put("bookroom", bookroom);
		return BookRoomController.SHOW_BOOKROOM_FORM;
	}

	@GetMapping(value = "/{bookroomId}/delete")
	public String delete(@PathVariable("bookroomId") final int bookroomId, final ModelMap model) {
		BookRoom bookRoom = this.bookroomService.findBookRoomById(bookroomId);

		this.bookroomService.deleteBookRoom(bookRoom);
		return "redirect:/bookroom";
	}

}
