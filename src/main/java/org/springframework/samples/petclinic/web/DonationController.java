package org.springframework.samples.petclinic.web;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Cause;
import org.springframework.samples.petclinic.model.Donation;
import org.springframework.samples.petclinic.service.CauseService;
import org.springframework.samples.petclinic.service.DonationService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/donation")
public class DonationController {
	
	private final static String	DONATIONS_LIST		= "donations/list";
	private final static String	DONATIONS_SHOW		= "donations/show";
	private final static String	DONATIONS_CREATE	= "donations/form";
	
	@Autowired
	private DonationService		donationService;
	
	@Autowired 
	private CauseService 		causeService;
	
	
	public DonationController(final DonationService donationService) {
		this.donationService = donationService;

	}
	
	@GetMapping()
	public String getListDonations(final Map<String, Object> model) {
		Iterable<Donation> donations = this.donationService.findAllDonations();
		model.put("donations", donations);
		return DonationController.DONATIONS_LIST;
	}
	
	@GetMapping("/{donationId}")
	public String getShowDonation(final Map<String, Object> model, @PathVariable("donationId") final int donationId) {
		Donation donation = this.donationService.findDonationById(donationId);
		model.put("donation", donation);
		return DonationController.DONATIONS_SHOW;
	}
	
	@GetMapping("/create/{causeId}")
	public String createDonation(@PathVariable("causeId") final int causeId, final Map<String, Object> model) {
		Donation donation = new Donation();
		Cause cause = this.causeService.findCauseById(causeId);
		donation.setCause(cause);
		cause.addDonation(donation);
		model.put("donation", donation);
		model.put("cause", cause);
		return DonationController.DONATIONS_CREATE;
	}
	
	@PostMapping("/save")
	public String createCause(final Map<String, Object> model, @Valid final Donation donation, final BindingResult result) {
		if (result.hasErrors()) {
			model.put("error", true);
			model.put("donation", donation);
			return DonationController.DONATIONS_CREATE;

		} else {
			this.donationService.save(donation);
			return "redirect:/donation";
		}
	}
	
	

}
