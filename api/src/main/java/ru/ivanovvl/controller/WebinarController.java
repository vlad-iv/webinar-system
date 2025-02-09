package ru.ivanovvl.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import ru.ivanovvl.dto.WebinarCreateDto;
import ru.ivanovvl.dto.WebinarDto;
import ru.ivanovvl.dto.WebinarUpdateDto;
import ru.ivanovvl.operations.WebinarOperations;
import ru.ivanovvl.service.WebinarService;

/**
 * REST Controller для работы с вебинарами.
 * Выполняет CRUD-операции с помощью слоев сервиса.
 *
 * @author Vladimir Ivanov
 */
@RestController
@RequestMapping("/api/v1/webinars")
public class WebinarController implements WebinarOperations {

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
	@Override
	public WebinarDto createWebinar(@RequestBody  @Valid WebinarCreateDto webinarCreateDto) {
		return webinarService.createWebinar(webinarCreateDto);
	}

	/**
	 * Получает список всех вебинаров.
	 *
	 * @return Список DTO вебинаров.
	 */
	@Override
	public List<WebinarDto> getAllWebinars() {
		return webinarService.getAllWebinars();
	}

	/**
	 * Получает информацию о вебинаре по его ID.
	 *
	 * @param webinarId ID вебинара.
	 * @return DTO найденного вебинара.
	 */
	@Override
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
	@Override
	public WebinarDto updateWebinar(@PathVariable Integer webinarId,
			@RequestBody @Valid WebinarUpdateDto webinarUpdateDto) {
		return webinarService.updateWebinar(webinarId, webinarUpdateDto);
	}

	/**
	 * Удаляет вебинар по его ID.
	 *
	 * @param webinarId ID вебинара.
	 */
	@Override
	public void deleteWebinar(@PathVariable Integer webinarId) {
		webinarService.deleteWebinar(webinarId);
	}
}