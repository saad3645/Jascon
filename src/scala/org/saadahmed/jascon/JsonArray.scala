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
import scala.collection.mutable.ArrayBuffer
import java.util.{UUID, Date}
import org.saadahmed.jascon.parser.JsonParser


/**
 * @author Saad Ahmed
 * @version 0.1 2014/04/14
 */
class JsonArray protected (buffer: ArrayBuffer[JsonType]) extends JsonCollection[JsonType] {
	override type T = mutable.Buffer[JsonType]
	override protected val underlying = buffer


	def this(sequence: Seq[_]) = this(sequence.foldLeft(new ArrayBuffer[JsonType]) { (buffer, e) =>
		buffer += JsonType(e)
	})

	def this(array: Array[_]) = this(array.foldLeft(new ArrayBuffer[JsonType]) { (buffer, e) =>
		buffer += JsonType(e)
	})


	def += (element: Boolean): JsonArray = this.insert(JsonType(element))

	def += (element: Byte): JsonArray = this.insert(JsonType(element))

	def += (element: Short): JsonArray = this.insert(JsonType(element))

	def += (element: Int): JsonArray = this.insert(JsonType(element))

	def += (element: Long): JsonArray = this.insert(JsonType(element))

	def += (element: Float): JsonArray = this.insert(JsonType(element))

	def += (element: Double): JsonArray = this.insert(JsonType(element))

	def += (element: String): JsonArray = this.insert(JsonType(element))

	def += (element: Date): JsonArray = this.insert(JsonType(element))

	def += (element: UUID): JsonArray = this.insert(JsonType(element))

	def += (element: Array[_]): JsonArray = this.insert(JsonType(element))

	def += (element: Seq[_]): JsonArray = this.insert(JsonType(element))

	def += (element: Map[String, _]): JsonArray = this.insert(JsonType(element))

	def += (element: JsonEnum): JsonArray = this.insert(JsonType(element))

	def += (element: JsonModel): JsonArray = this.insert(JsonType(element))

	def += (element: Option[_]): JsonArray = this.insert(JsonType(element))

	def += (element: Null): JsonArray = this.insert(JsonValue.NULL)

	def += (element: JsonType): JsonArray = this.insert(element)

	def insert (element: JsonType) = {
		underlying += element
		this
	}


	def +:= (element: Boolean): JsonArray = this +:= JsonType(element)

	def +:= (element: Byte): JsonArray = this +:= JsonType(element)

	def +:= (element: Short): JsonArray = this +:= JsonType(element)

	def +:= (element: Int): JsonArray = this +:= JsonType(element)

	def +:= (element: Long): JsonArray = this +:= JsonType(element)

	def +:= (element: Float): JsonArray = this +:= JsonType(element)

	def +:= (element: Double): JsonArray = this +:= JsonType(element)

	def +:= (element: String): JsonArray = this +:= JsonType(element)

	def +:= (element: Date): JsonArray = this +:= JsonType(element)

	def +:= (element: UUID): JsonArray = this +:= JsonType(element)

	def +:= (element: Array[_]): JsonArray = this +:= JsonType(element)

	def +:= (element: Seq[_]): JsonArray = this +:= JsonType(element)

	def +:= (element: Map[String, _]): JsonArray = this +:= JsonType(element)

	def +:= (element: JsonEnum): JsonArray = this +:= JsonType(element)

	def +:= (element: JsonModel): JsonArray = this +:= JsonType(element)

	def +:= (element: Option[_]): JsonArray = this +:= JsonType(element)

	def +:= (element: Null): JsonArray = this +:= JsonValue.NULL

	def +:= (element: JsonType) = {
		underlying.+=: (element)
		this
	}


	def -= (element: Any) = underlying -= JsonType(element)


	def append(elements: Any*) = {
		elements.foreach{e => this insert JsonType(e)}
		this
	}

	def apply(index: Int) = underlying.apply(index)

	def array: Array[_] = (for (e <- underlying) yield  e.value).toArray

	override def copy: JsonArray = new JsonArray(this.underlying)

	override def equals(that: Any): Boolean = {
		if (that == null || !that.isInstanceOf[JsonArray] || this.length != that.asInstanceOf[JsonArray].length) false
		else {
			for ((e1, e2) <- this.underlying.zip(that.asInstanceOf[JsonArray].underlying)) {
				if (e1 != e2) return false
			}
			true
		}
	}

	override def hashCode() = {
		underlying.foldLeft(7) { (hash, e) =>
			31 * hash + e.hashCode()
		}
	}

	def get[U](index: Int) = this(index).value.asInstanceOf[U]

	def getBoolean(index: Int) = this.get[Boolean](index)

	def getByte(index: Int) = this.getNumber(index).byteValue()

	def getShort(index: Int) = this.getNumber(index).shortValue()

	def getInt(index: Int) = this.getNumber(index).intValue()

	def getLong(index: Int) = this.getNumber(index).longValue()

	def getFloat(index: Int) = this.getNumber(index).floatValue()

	def getDouble(index: Int) = this.getNumber(index).doubleValue()

	def getNumber(index: Int) = this.get[Number](index)

	def getString(index: Int) = this.get[String](index)

	def getArray(index: Int) = this.get[JsonArray](index)

	def getObject(index: Int)= this.get[JsonObject](index)


	def hasNonNull(index: Int) = this(index).isNonNull

	def hasNull(index: Int) = this(index).isNull


	override def iterator = underlying.iterator

	def length = underlying.length

	def list: List[_] = (for (e <- underlying) yield e.value).toList

	def prepend(elements: Any*) = {
		elements.foreach(e => this +:= JsonType(e))
		this
	}

	def remove(index: Int) = underlying.remove(index)

	override def toString = {
		if (this.isEmpty) {
			"[]"
		}

		else {
			val items = underlying.iterator
			val builder = new StringBuilder("[")

			builder.append(items.next().toString)
			while(items.hasNext) {
				builder.append(",").append(items.next().toString)
			}

			builder.append("]").toString()
		}
	}

	def update(index: Int, value: Boolean) = this.updateItem(index, value)

	def update(index: Int, value: Byte) = this.updateItem(index, value)

	def update(index: Int, value: Short) = this.updateItem(index, value)

	def update(index: Int, value: Int) = this.updateItem(index, value)

	def update(index: Int, value: Long) = this.updateItem(index, value)

	def update(index: Int, value: Float) = this.updateItem(index, value)

	def update(index: Int, value: Double) = this.updateItem(index, value)

	def update(index: Int, value: String) = this.updateItem(index, value)

	def update(index: Int, value: Date) = this.updateItem(index, value)

	def update(index: Int, value: UUID) = this.updateItem(index, value)

	def update(index: Int, value: Array[_]) = this.updateItem(index, value)

	def update(index: Int, value: Seq[_]) = this.updateItem(index, value)

	def update(index: Int, value: Map[String, _]) = this.updateItem(index, value)

	def update(index: Int, value: mutable.Map[String, _]) = this.updateItem(index, value)

	def update(index: Int, value: JsonEnum) = this.updateItem(index, value)

	def update(index: Int, value: JsonModel) = this.updateItem(index, value)

	def update(index: Int, value: Option[_]) = this.updateItem(index, value)

	def update(index: Int, value: Null) = underlying.update(index, JsonValue.NULL)

	def update(index: Int, value: JsonType) = underlying.update(index, value)

	protected def updateItem[V](index: Int, value: V) = underlying.update(index, JsonType(value))

	override def value = this
}


object JsonArray {
	def apply() = new JsonArray(ArrayBuffer.empty)

	def apply(sequence: Seq[_]) = new JsonArray(sequence)

	def apply(array: Array[_]) = new JsonArray(array)

	def apply(string: String) = JsonParser.parse(string).asArray
}
