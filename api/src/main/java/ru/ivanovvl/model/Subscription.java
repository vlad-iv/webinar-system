package ru.ivanovvl.model;

import java.util.List;

/**
 * Subscription to lector or webinars.
 *
 * @author Vladimir Ivanov (ivanov.vladimir.l@gmail.com)
 */
public record Subscription(int id, String name, User lector, List<Webinar> webinars) {
}
