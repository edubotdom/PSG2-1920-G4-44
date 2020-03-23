
package org.springframework.samples.petclinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.samples.petclinic.model.Cause;
import org.springframework.samples.petclinic.repository.CauseRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CauseService {

	@Autowired
	private CauseRepository repository;


	public CauseService(final CauseRepository repository) {
		this.repository = repository;
	}

	@Transactional(readOnly = true)
	@Cacheable(value = "causes")
	public Iterable<Cause> findAllCauses() {
		return this.repository.findAll();
	}

	public Cause findCauseById(final int causeId) {
		return this.repository.findCauseById(causeId);
	}

	@Transactional
	public void save(final Cause cause) {
		this.repository.save(cause);
	}
}
