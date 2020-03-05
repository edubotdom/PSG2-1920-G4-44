
package org.springframework.samples.petclinic.web;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.BookRoom;
import org.springframework.samples.petclinic.service.BookRoomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/bookroom")
public class BookRoomController {

	private static final String	CREATE_BOOKROOM_FORM	= "bookrooms/form";
	private static final String	LIST_BOOKROOM_FORM		= "bookrooms/list";
	private static final String	SHOW_BOOKROOM_FORM		= "bookrooms/show";

	@Autowired
	private BookRoomService		service;


	@GetMapping(value = "/new")
	public String initCreationFrom(final Map<String, Object> model) {
		BookRoom bookroom = new BookRoom();
		model.put("bookroom", bookroom);
		return BookRoomController.CREATE_BOOKROOM_FORM;
	}

	@PostMapping(value = "/save")
	public String processCreationForm(@Valid final BookRoom bookroom, final BindingResult result, final ModelMap modelMap) {
		if (result.hasErrors()) {
			modelMap.addAttribute("bookroom,", bookroom);
			return BookRoomController.CREATE_BOOKROOM_FORM;
		} else {
			this.service.saveBookRoom(bookroom);
			modelMap.addAttribute("message", "Event sucesfully added!");
			return this.listBookRoom(modelMap);
		}

	}

	@GetMapping()
	public String listBookRoom(final ModelMap modelMap) {
		Iterable<BookRoom> bookrooms = this.service.findAll();
		modelMap.addAttribute("bookrooms", bookrooms);
		return BookRoomController.LIST_BOOKROOM_FORM;

	}

	@GetMapping("/{bookroomId}")
	public ModelAndView showBookRoom(@PathVariable("bookroomId") final int bookroomId) {
		ModelAndView mav = new ModelAndView(BookRoomController.SHOW_BOOKROOM_FORM);
		mav.addObject(this.service.findBookRoomById(bookroomId));
		return mav;
	}

}
