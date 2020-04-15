
package org.springframework.samples.petclinic.web;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Cause;
import org.springframework.samples.petclinic.service.CauseService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cause")
public class CauseController {

	private static final String	CAUSES_LIST		= "causes/list";
	private static final String	CAUSES_SHOW		= "causes/show";
	private static final String	CAUSES_CREATE	= "causes/form";

	@Autowired
	private CauseService		causeService;


	public CauseController(final CauseService causeService) {
		this.causeService = causeService;

	}

	@GetMapping()
	public String getListCauses(final Map<String, Object> model) {
		Iterable<Cause> causes = this.causeService.findAllCauses();
		model.put("causes", causes);
		return CauseController.CAUSES_LIST;
	}

	@GetMapping("/{causeId}")
	public String getShowCause(final Map<String, Object> model, @PathVariable("causeId") final int causeId) {
		Cause cause = this.causeService.findCauseById(causeId);
		model.put("cause", cause);
		return CauseController.CAUSES_SHOW;
	}

	@GetMapping("/create")
	public String createCause(final Map<String, Object> model) {
		Cause cause = new Cause();
		cause.setIsClosed(false);
		model.put("cause", cause);
		return CauseController.CAUSES_CREATE;
	}

	@PostMapping("/save")
	public String createCause(final Map<String, Object> model, @Valid final Cause cause, final BindingResult result) {
		if (result.hasErrors()) {
			cause.setIsClosed(false);
			model.put("error", true);
			model.put("cause", cause);
			return CauseController.CAUSES_CREATE;

		} else {
			cause.setIsClosed(false);
			this.causeService.save(cause);
			return "redirect:/cause";
		}
	}

}
