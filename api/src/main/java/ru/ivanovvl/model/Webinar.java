package ru.ivanovvl.model;

import java.time.Instant;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Webinar .
 *
 * @author Vladimir Ivanov (ivanov.vladimir.l@gmail.com)
 */
@Getter
@Setter
@NoArgsConstructor
@Table("webinars")
public class Webinar {
	@Id
	private Integer id;
	private String name;
	private String description;
	private Instant date;
	private User lector;
	private int visitors;
}

