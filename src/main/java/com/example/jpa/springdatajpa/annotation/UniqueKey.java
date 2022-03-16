package com.example.jpa.springdatajpa.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface UniqueKey {
	
	/**
	 * Native name.
	 *
	 * @return the string
	 */
	String nativeName() default "";
	
	/**
	 * Path.
	 *
	 * @return the string
	 */
	String path() default "";
	
}