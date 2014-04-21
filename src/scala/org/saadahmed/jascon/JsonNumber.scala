/*
 * Copyright 2014 Saad Ahmed
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.saadahmed.jascon


/**
 * @author Saad Ahmed
 * @version 0.1 2014/02/24
 */
class JsonNumber(number: Number = 0) extends JsonValue {
	override type T = Number
	override protected val underlying = number


	override def copy: JsonNumber = new JsonNumber(this.value)

	override def equals(that: Any) = {
		that != null && that.isInstanceOf[JsonNumber] && this.value == that.asInstanceOf[JsonNumber].value
	}

	def shortValue = this.underlying.shortValue
	def intValue = this.underlying.intValue
	def longValue = this.underlying.longValue
	def floatValue = this.underlying.floatValue
	def doubleValue = this.underlying.doubleValue

	override def value = underlying
}


object JsonNumber {

	// ^(-?0+|-?0*[1-9]\d{0,18})$
	val INTEGER_REGEX = "^(-?0+|-?0*[1-9]\\d{0,18})$".r

	// ^(-?\d+(\.\d+|[eE]-?\d+|\.\d+[eE]-?\d+))$
	val FLOATING_POINT_REGEX = "^(-?\\d+(\\.\\d+|[eE]-?\\d+|\\.\\d+[eE]-?\\d+))$".r

	def apply(value: Int) = new JsonNumber(value)

	def apply(value: Long) = new JsonNumber(value)

	def apply(value: Float) = new JsonNumber(value)

	def apply(value: Double) = new JsonNumber(value)

	def apply(value: Number) = new JsonNumber(value)

	def apply(string: String) = string match {
		case INTEGER_REGEX(s) =>
			try {
				new JsonNumber(s.toInt)
			}
			catch {
				case _:NumberFormatException => new JsonNumber(s.toLong)
			}
		case FLOATING_POINT_REGEX(s, _) => new JsonNumber(s.toDouble)
		case _ => throw JsonParseException(string)
	}
}
