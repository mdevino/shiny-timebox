package com.mdevino.shiny.timebox;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import reactor.core.publisher.Flux;

@Controller
public class TimeboxController {

	@Autowired
	private TimeboxRepository repository;
	
	@QueryMapping
	Flux<Timebox> timeboxes(){
		return repository.findAll(Sort.by(Direction.DESC, "start"));
	}
}
