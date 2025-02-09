package ru.ivanovvl.ui.controller;

import java.time.Instant;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import ru.ivanovvl.dto.WebinarCreateDto;
import ru.ivanovvl.dto.WebinarDto;
import ru.ivanovvl.dto.WebinarUpdateDto;
import ru.ivanovvl.operations.WebinarOperations;

@Controller
@RequestMapping("/webinars")
@RequiredArgsConstructor
public class WebinarUiController {

	private final WebinarOperations webinarClient;

	// Список всех вебинаров
	@GetMapping
	public String listWebinars(Model model) {
		model.addAttribute("webinars", webinarClient.getAllWebinars());
		return "webinars/list";
	}

	// Форма создания нового вебинара
	@GetMapping("/create")
	public String createWebinarForm(Model model) {
		model.addAttribute("webinar", new WebinarCreateDto("", "", Instant.now(), -1));
		return "webinars/create";
	}

	// Обработка создания вебинара
	@PostMapping
	public String createWebinar(@ModelAttribute WebinarCreateDto webinarCreateDto) {
		webinarClient.createWebinar(webinarCreateDto);
		return "redirect:/webinars";
	}

	// Просмотр вебинара
	@GetMapping("/{id}")
	public String viewWebinar(@PathVariable Integer id, Model model) {
		WebinarDto webinar = webinarClient.getWebinarById(id);
		model.addAttribute("webinar", webinar);
		return "webinars/view";
	}

	// Форма редактирования вебинара
	@GetMapping("/{id}/edit")
	public String editWebinarForm(@PathVariable Integer id, Model model) {
		WebinarDto webinar = webinarClient.getWebinarById(id);
		model.addAttribute("webinar", webinar);
		return "webinars/edit";
	}

	// Обработка обновления вебинара
	@PostMapping("/{id}/edit")
	public String updateWebinar(@PathVariable Integer id, @ModelAttribute WebinarUpdateDto webinarUpdateDto) {
		webinarClient.updateWebinar(id, webinarUpdateDto);
		return "redirect:/webinars";
	}

	// Удаление вебинара
	@GetMapping("/{id}/delete")
	public String deleteWebinar(@PathVariable Integer id) {
		webinarClient.deleteWebinar(id);
		return "redirect:/webinars";
	}
}