
package org.springframework.samples.petclinic.web;

import java.util.Map;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RequestMethod;

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
		model.put("bookroom", bookroom);
		return BookRoomController.CREATE_BOOKROOM_FORM;
	}

	@PostMapping(value = "/save/{ownerId}/{petId}")
	public String processCreationForm(@Valid final BookRoom bookroom, final BindingResult result, final ModelMap modelMap, @PathVariable("ownerId") final int ownerId, @PathVariable("petId") final int petId) {
		if (result.hasErrors()) {
			modelMap.addAttribute("bookroom,", bookroom);
			return BookRoomController.CREATE_BOOKROOM_FORM;
		} else {
			Owner owner = this.clinicService.findOwnerById(ownerId);
			Pet pet = this.clinicService.findPetById(petId);
			bookroom.setPet(pet);
			bookroom.setOwner(owner);
			this.bookroomService.saveBookRoom(bookroom);
			modelMap.addAttribute("message", "Event sucesfully added!");
			return this.listBookRoom(modelMap);
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
	
	@GetMapping(value = "/bookroom/{bookroomId}/delete" )
	public String delete(@PathVariable("bookroomId") int bookroomId, ModelMap model) {
		BookRoom bookRoom = this.bookroomService.findBookRoomById(bookroomId);
		//Pet pet = this.clinicService.findPetById(petId);
		//Owner owner=this.clinicService.findOwnerById(ownerId);
		
		
		this.bookroomService.deleteBookRoom(bookRoom);;
		return "redirect:/bookroom";
	}

}
