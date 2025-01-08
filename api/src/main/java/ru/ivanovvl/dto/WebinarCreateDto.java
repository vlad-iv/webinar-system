package ru.ivanovvl.dto;

import java.time.Instant;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * Webinar .
 *
 * @author Vladimir Ivanov (ivanov.vladimir.l@gmail.com)
 */
@Data
public class WebinarCreateDto {
	private @NotBlank String name;
	private String description;
	private @NotNull
	@FutureOrPresent Instant date;
	private @NotNull Integer lectorId;
}

