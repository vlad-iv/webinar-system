package ru.ivanovvl.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import ru.ivanovvl.dto.WebinarCreateDto;
import ru.ivanovvl.dto.WebinarDto;
import ru.ivanovvl.dto.WebinarUpdateDto;
import ru.ivanovvl.service.WebinarService;

import java.util.List;

/**
 * REST Controller для работы с вебинарами.
 * Выполняет CRUD-операции с помощью слоев сервиса.
 *
 * @author Vladimir Ivanov
 */
@RestController
@RequestMapping("/api/v1/webinars")
public class WebinarController {

	private final WebinarService webinarService;

	public WebinarController(WebinarService webinarService) {
		this.webinarService = webinarService;
	}

	/**
	 * Создает новый вебинар.
	 *
	 * @param webinarCreateDto DTO с деталями вебинара.
	 * @return DTO созданного вебинара.
	 */
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public WebinarDto createWebinar(@RequestBody  @Valid WebinarCreateDto webinarCreateDto) {
		return webinarService.createWebinar(webinarCreateDto);
	}

	/**
	 * Получает список всех вебинаров.
	 *
	 * @return Список DTO вебинаров.
	 */
	@GetMapping
	public List<WebinarDto> getAllWebinars() {
		return webinarService.getAllWebinars();
	}

	/**
	 * Получает информацию о вебинаре по его ID.
	 *
	 * @param webinarId ID вебинара.
	 * @return DTO найденного вебинара.
	 */
	@GetMapping("/{webinarId}")
	public WebinarDto getWebinarById(@PathVariable Integer webinarId) {
		return webinarService.getWebinarById(webinarId);
	}

	/**
	 * Обновляет данные о вебинаре по его ID.
	 *
	 * @param webinarId        ID вебинара.
	 * @param webinarUpdateDto DTO с обновленными данными вебинара.
	 * @return DTO обновленного вебинара.
	 */
	@PutMapping("/{webinarId}")
	public WebinarDto updateWebinar(@PathVariable Integer webinarId,
			@RequestBody @Valid WebinarUpdateDto webinarUpdateDto) {
		return webinarService.updateWebinar(webinarId, webinarUpdateDto);
	}

	/**
	 * Удаляет вебинар по его ID.
	 *
	 * @param webinarId ID вебинара.
	 */
	@DeleteMapping("/{webinarId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteWebinar(@PathVariable Integer webinarId) {
		webinarService.deleteWebinar(webinarId);
	}
}