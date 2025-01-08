package ru.ivanovvl.repository;

import org.springframework.data.repository.CrudRepository;

import ru.ivanovvl.model.Webinar;

/**
 * Webinar repository.
 *
 * @author Vladimir Ivanov (ivanov.vladimir.l@gmail.com)
 */
public interface WebinarRepository extends CrudRepository<Webinar, Integer> {
}
