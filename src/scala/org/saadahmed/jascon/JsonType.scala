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

import scala.collection.mutable
import java.util.{Date, UUID}


/**
 * @author Saad Ahmed
 * @version 0.1 2014/02/24
 */
abstract class JsonType {
	type T
	protected val underlying: T


	def asArray = this.asInstanceOf[JsonArray]
	def asBoolean = this.asInstanceOf[JsonBoolean]
	def asNumber = this.asInstanceOf[JsonNumber]
	def asObject = this.asInstanceOf[JsonObject]
	def asString = this.asInstanceOf[JsonString]

	def copy: JsonType

	override def equals(that: Any): Boolean

	override def hashCode() = underlying.hashCode()

	def isArray = this.isInstanceOf[JsonArray]
	def isBoolean = this.isInstanceOf[JsonBoolean]
	def isCollection = this.isInstanceOf[JsonCollection[_]]
	def isNonNull = !this.isNull
	def isNull = this.value == None
	def isNumber = this.isInstanceOf[JsonNumber]
	def isObject = this.isInstanceOf[JsonObject]
	def isString = this.isInstanceOf[JsonString]
	def isValue = this.isInstanceOf[JsonValue]

	override def toString = underlying.toString

	def value: Any
}


object JsonType {

	def apply(value: Any): JsonType = value match {
		case null => JsonValue.NULL
		case None => JsonValue.NULL
		case Some(e) => JsonType(e)
		case true => JsonValue.TRUE
		case false => JsonValue.FALSE
		case e: Byte => JsonNumber(e)
		case e: Short => JsonNumber(e)
		case e: Int => JsonNumber(e)
		case e: Long => JsonNumber(e)
		case e: Float => JsonNumber(e)
		case e: Double => JsonNumber(e)
		case e: String => JsonString(e)
		case e: Date => JsonNumber(e.getTime)
		case e: UUID => JsonString(e.toString)
		case e: Array[_] => JsonArray(e)
		case e: Seq[_] => JsonArray(e)
		case e: Map[String, _] => JsonObject(e)
		case e: mutable.LinkedHashMap[String, _] => JsonObject(e)
		case e: JsonEnum => e.toJson
		case e: JsonModel => e.toJson
		case e: JsonType => e
		case e: Any => JsonString(e.toString)
	}

}
