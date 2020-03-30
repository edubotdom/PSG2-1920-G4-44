package org.springframework.samples.petclinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.samples.petclinic.model.Cause;
import org.springframework.samples.petclinic.model.Donation;
import org.springframework.samples.petclinic.repository.DonationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DonationService {
	
	@Autowired
	private DonationRepository repository;
	
	public DonationService(final DonationRepository  repository) {
		this.repository = repository;
	}
	
	@Transactional
	@Cacheable(value = "donations")
	public Iterable<Donation> findAllDonations() {
		return this.repository.findAll();
	}
	
	public Donation findDonationById(final int donationId) {
		return this.repository.findDonationById(donationId);
	}
	
	@Transactional
	public void save(final Donation donation) {
		this.repository.save(donation);
	}

}
