package com.mdevino.shiny.timebox;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import reactor.core.publisher.Flux;

public interface TimeboxRepository extends ReactiveCrudRepository<Timebox, Long>{

	Flux<Timebox> findAll(Sort sort);
}
