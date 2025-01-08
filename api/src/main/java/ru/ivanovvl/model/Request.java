package ru.ivanovvl.model;

import java.time.Instant;

/**
 * User request to webinar.
 *
 * @author Vladimir Ivanov (ivanov.vladimir.l@gmail.com)
 */
public record Request(int id, User user, Webinar webinar, Instant timestamp) {
}
