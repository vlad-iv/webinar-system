package ru.ivanovvl.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ru.ivanovvl.dto.UserDto;
import ru.ivanovvl.dto.WebinarCreateDto;
import ru.ivanovvl.dto.WebinarDto;
import ru.ivanovvl.dto.WebinarUpdateDto;
import ru.ivanovvl.model.User;
import ru.ivanovvl.model.Webinar;
import ru.ivanovvl.repository.WebinarRepository;

/**
 * Сервис для управления вебинарами.
 *
 * @author Vladimir Ivanov
 */
@Service
@RequiredArgsConstructor
public class WebinarService {

	private final WebinarRepository webinarRepository;

	/**
	 * Создает новый вебинар.
	 *
	 * @param webinarCreateDto DTO с деталями вебинара.
	 * @return DTO созданного вебинара.
	 */
	public WebinarDto createWebinar(WebinarCreateDto webinarCreateDto) {
		Webinar webinar = new Webinar();
		webinar.setName(webinarCreateDto.getName());
		webinar.setDescription(webinarCreateDto.getDescription());
		webinar.setDate(webinarCreateDto.getDate());
		final User lector = new User();
		lector.setId(webinarCreateDto.getLectorId());
		webinar.setLector(lector);

		Webinar savedWebinar = webinarRepository.save(webinar);

		return mapToDto(savedWebinar);
	}

	/**
	 * Возвращает список всех вебинаров.
	 *
	 * @return Список DTO вебинаров.
	 */
	public List<WebinarDto> getAllWebinars() {
		List<Webinar> webinars = (List<Webinar>) webinarRepository.findAll();
		return webinars.stream()
				.map(this::mapToDto)
				.collect(Collectors.toList());
	}

	/**
	 * Возвращает вебинар по его ID.
	 *
	 * @param webinarId ID вебинара.
	 * @return DTO найденного вебинара.
	 * @throws IllegalArgumentException если вебинар не найден.
	 */
	public WebinarDto getWebinarById(Integer webinarId) {
		Webinar webinar = webinarRepository.findById(webinarId)
				.orElseThrow(() -> new IllegalArgumentException("Вебинар с ID " + webinarId + " не найден"));

		return mapToDto(webinar);
	}

	/**
	 * Обновляет существующий вебинар.
	 *
	 * @param webinarId        ID вебинара.
	 * @param webinarUpdateDto DTO с обновленными данными.
	 * @return DTO обновленного вебинара.
	 */
	public WebinarDto updateWebinar(Integer webinarId, WebinarUpdateDto webinarUpdateDto) {
		Webinar webinar = webinarRepository.findById(webinarId)
				.orElseThrow(() -> new IllegalArgumentException("Вебинар с ID " + webinarId + " не найден"));

		webinar.setName(webinarUpdateDto.getName());
		webinar.setDescription(webinarUpdateDto.getDescription());
		webinar.setDate(webinarUpdateDto.getDate());
		final User lector = new User();
		lector.setId(webinarUpdateDto.getLectorId());
		webinar.setLector(lector);
		Webinar updatedWebinar = webinarRepository.save(webinar);

		return mapToDto(updatedWebinar);
	}

	/**
	 * Удаляет вебинар по его ID.
	 *
	 * @param webinarId ID вебинара.
	 */
	public void deleteWebinar(Integer webinarId) {
		if (!webinarRepository.existsById(webinarId)) {
			throw new IllegalArgumentException("Вебинар с ID " + webinarId + " не найден");
		}
		webinarRepository.deleteById(webinarId);
	}

	/**
	 * Преобразует сущность Webinar в DTO.
	 *
	 * @param webinar Сущность вебинара.
	 * @return DTO вебинара.
	 */
	private WebinarDto mapToDto(Webinar webinar) {
		User lector = webinar.getLector();
		return new WebinarDto(
				webinar.getId(),
				webinar.getName(),
				webinar.getDescription(),
				webinar.getDate(),
				new UserDto(lector.getId(), lector.getName(), lector.getEmail())
		);
	}
}