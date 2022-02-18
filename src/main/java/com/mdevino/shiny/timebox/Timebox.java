package com.mdevino.shiny.timebox;

import java.time.LocalDateTime;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Timebox {
	private Long id;
	private String description;
	private LocalDateTime start;
	private LocalDateTime end;
}
