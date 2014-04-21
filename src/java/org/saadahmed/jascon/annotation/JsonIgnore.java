package org.saadahmed.jascon.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * @author Saad Ahmed
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = {ElementType.METHOD, ElementType.FIELD})
public @interface JsonIgnore {

	JsonIgnoreType ignoreType() default JsonIgnoreType.ANY;
}
