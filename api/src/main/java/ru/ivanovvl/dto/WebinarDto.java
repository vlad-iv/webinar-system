package ru.ivanovvl.dto;

import java.time.Instant;

import ru.ivanovvl.model.User;

/**
 * Webinar .
 *
 * @author Vladimir Ivanov (ivanov.vladimir.l@gmail.com)
 */
public record WebinarDto(
		int id,
		String name,
		String description,
		Instant date,
		UserDto lector
) {

}

