package ru.ivanovvl.model;

import org.springframework.data.relational.core.mapping.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * // TODO .
 *
 * @author Vladimir Ivanov (ivanov.vladimir.l@gmail.com)
 */
@Getter
@Setter
@NoArgsConstructor
@Table("users")
public final class User {
	private Integer id;
	private String name;
	private String email;
	private UserType type;

}
