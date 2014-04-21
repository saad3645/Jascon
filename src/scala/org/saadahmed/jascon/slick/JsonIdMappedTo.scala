package org.saadahmed.jascon.slick

/**
 * @author Saad Ahmed
 * @version 0.1 2014/03/13
 */
trait JsonIdMappedTo[T, U] {

	val value: T

	def mapTo(src: Any): U
}
