package ru.ivanovvl.operations;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * // TODO .
 *
 * @author Vladimir Ivanov (ivanov.vladimir.l@gmail.com)
 */
@FeignClient("/api/v1/webinars")
public interface WebinarClient extends WebinarOperations {
}
