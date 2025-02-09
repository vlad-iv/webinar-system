package ru.ivanovvl.operations;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import ru.ivanovvl.dto.WebinarCreateDto;
import ru.ivanovvl.dto.WebinarDto;
import ru.ivanovvl.dto.WebinarUpdateDto;

/**
 * // TODO .
 *
 * @author Vladimir Ivanov (ivanov.vladimir.l@gmail.com)
 */
public interface WebinarOperations {
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	WebinarDto createWebinar(@RequestBody WebinarCreateDto webinarCreateDto);

	@GetMapping
	List<WebinarDto> getAllWebinars();

	WebinarDto getWebinarById(@PathVariable Integer webinarId);

	@PutMapping("/{webinarId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	WebinarDto updateWebinar(@PathVariable Integer webinarId,
			@RequestBody WebinarUpdateDto webinarUpdateDto);

	@DeleteMapping("/{webinarId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	void deleteWebinar(@PathVariable Integer webinarId);
}
