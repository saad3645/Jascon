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
import java.util.{UUID, Date}
import org.saadahmed.jascon.parser.JsonParser


/**
 * @author Saad Ahmed
 * @version 0.1 2014/04/14
 */
class JsonObject protected (map: mutable.Map[String, JsonType]) extends JsonCollection[(String, JsonType)] {
	override type T = mutable.Map[String, JsonType]
	override protected val underlying = map


	def this(map: Map[String, _]) = this(map.foldLeft(new mutable.HashMap[String, JsonType]) { (newMap, kv) =>
		newMap += (kv._1 -> JsonType(kv._2))
	})

	def this(kvPairs: Seq[(String, _)]) = this(kvPairs.foldLeft(new mutable.LinkedHashMap[String, JsonType]) { (newMap, kv) =>
		newMap += (kv._1 -> JsonType(kv._2))
	})


	def += (key: String, value: Boolean): JsonObject = this.insert(key -> JsonType(value))

	def += (key: String, value: Byte): JsonObject = this.insert(key -> JsonType(value))

	def += (key: String, value: Short): JsonObject = this.insert(key -> JsonType(value))

	def += (key: String, value: Int): JsonObject = this.insert(key -> JsonType(value))

	def += (key: String, value: Long): JsonObject = this.insert(key -> JsonType(value))

	def += (key: String, value: Float): JsonObject = this.insert(key -> JsonType(value))

	def += (key: String, value: Double): JsonObject = this.insert(key -> JsonType(value))

	def += (key: String, value: String): JsonObject = this.insert(key -> JsonType(value))

	def += (key: String, value: Date): JsonObject = this.insert(key -> JsonType(value))

	def += (key: String, value: UUID): JsonObject = this.insert(key -> JsonType(value))

	def += (key: String, value: Array[_]): JsonObject = this.insert(key -> JsonType(value))

	def += (key: String, value: Seq[_]): JsonObject = this.insert(key -> JsonType(value))

	def += (key: String, value: Map[String, _]): JsonObject = this.insert(key -> JsonType(value))

	def += (key: String, value: JsonEnum): JsonObject = this.insert(key -> JsonType(value))

	def += (key: String, value: JsonModel): JsonObject = this.insert(key -> JsonType(value))

	def += (key: String, value: Option[_]): JsonObject = this.insert(key -> JsonType(value))

	def += (key: String, value: Null): JsonObject = this.insert(key -> JsonValue.NULL)

	def += (key: String, value: JsonType): JsonObject = this.insert(key -> value)


	override def insert (kv: (String, JsonType)) = {
		if (kv._1 == null) throw new IllegalArgumentException("JSONMap += -> Key is null")
		if (kv._1.isEmpty) throw new IllegalArgumentException("JSONMap += -> Key is empty")

		underlying += kv
		this
	}

	def -= (key: String) = {
		if (key == null) throw new IllegalArgumentException("JSONMap -= -> Key is null")
		if (key.isEmpty) throw new IllegalArgumentException("JSONMap -= -> Key is empty")

		underlying -= key
		this
	}

	def apply(key: String) = {
		if (key == null) throw new IllegalArgumentException("JSONMap.apply -> Key is null")
		if (key.isEmpty) throw new IllegalArgumentException("JSONMap.apply -> Key is empty")

		underlying.apply(key)
	}

	def copy: JsonObject = new JsonObject(this.underlying)


	override def equals(that: Any): Boolean = {
		if (that == null || !that.isInstanceOf[JsonObject] || this.size != that.asInstanceOf[JsonObject].size) false
		else {
			for (key <- this.keySet) {
				if (!that.asInstanceOf[JsonObject].has(key)) return false
				if (this(key) != that.asInstanceOf[JsonObject](key)) return false
			}
			true
		}
	}

	override def hashCode() = {
		underlying.foldLeft(7) { (hash, e) =>
			31 * hash + (7 * e._1.hashCode() + e._2.hashCode())
		}
	}

	def get[V](key: String): Option[V] = {
		if (key == null) throw new IllegalArgumentException("JSONMap.get -> Key is null")
		if (key.isEmpty) throw new IllegalArgumentException("JSONMap.get -> Key is empty")

		underlying.get(key).map { element =>
			element.value.asInstanceOf[V]
		}
	}

	def getBoolean(key: String) = this.get[Boolean](key)

	def getByte(key: String) = this.getNumber(key).map { number => number.byteValue() }

	def getShort(key: String) = this.getNumber(key).map { number => number.shortValue() }

	def getInt(key: String) = this.getNumber(key).map { number => number.intValue() }

	def getLong(key: String) = this.getNumber(key).map { number => number.longValue() }

	def getFloat(key: String) = this.getNumber(key).map { number => number.floatValue() }

	def getDouble(key: String) = this.getNumber(key).map { number => number.doubleValue() }

	def getNumber(key: String) = this.get[Number](key)

	def getString(key: String) = this.get[String](key)

	def getArray(key: String) = this.get[JsonArray](key)

	def getObject(key: String) = this.get[JsonObject](key)


	def getOrElse[V](key: String, default: => V): V = {
		if (key == null) throw new IllegalArgumentException("JsonObject.getOrElse -> Key is null")
		if (key.isEmpty) throw new IllegalArgumentException("JsonObject.getOrElse -> Key is empty")

		underlying.get(key).map { element =>
			element.value.asInstanceOf[V]
		}.getOrElse(default)
	}

	def getBooleanOrElse(key: String, default: => Boolean) = this.getOrElse[Boolean](key, default)

	def getByteOrElse(key: String, default: => Byte) = this.getNumberOrElse(key, default).byteValue()

	def getShortOrElse(key: String, default: => Short) = this.getNumberOrElse(key, default).shortValue()

	def getIntOrElse(key: String, default: => Int) = this.getNumberOrElse(key, default).intValue()

	def getLongOrElse(key: String, default: => Long) = this.getNumberOrElse(key, default).longValue()

	def getFloatOrElse(key: String, default: => Float) = this.getNumberOrElse(key, default).floatValue()

	def getDoubleOrElse(key: String, default: => Double) = this.getNumberOrElse(key, default).doubleValue()

	def getNumberOrElse(key: String, default: => Number) = this.getOrElse[Number](key, default)

	def getStringOrElse(key: String, default: => String) = this.getOrElse[String](key, default)

	def getArrayOrElse(key: String, default: => JsonArray) = this.getOrElse[JsonArray](key, default)

	def getObjectOrElse(key: String, default: => JsonObject) = this.getOrElse[JsonObject](key, default)


	def has(key: String) = underlying.contains(key)

	def hasNonNull(key: String) = this(key).isNonNull

	def hasNull(key: String) = this(key).isNull

	override def iterator = underlying.iterator

	def keys = underlying.keys

	def keySet = underlying.keySet

	def keysList = {
		(for (kv <- underlying) yield kv._1).toList
	}


	def offer(key: String, value: Boolean) = this.offerItem(key, value)

	def offer(key: String, value: Byte) = this.offerItem(key, value)

	def offer(key: String, value: Short) = this.offerItem(key, value)

	def offer(key: String, value: Int) = this.offerItem(key, value)

	def offer(key: String, value: Long) = this.offerItem(key, value)

	def offer(key: String, value: Float) = this.offerItem(key, value)

	def offer(key: String, value: Double) = this.offerItem(key, value)

	def offer(key: String, value: String) = this.offerItem(key, value)

	def offer(key: String, value: Date) = this.offerItem(key, value)

	def offer(key: String, value: UUID) = this.offerItem(key, value)

	def offer(key: String, value: Array[_]) = this.offerItem(key, value)

	def offer(key: String, value: Seq[_]) = this.offerItem(key, value)

	def offer(key: String, value: Map[String, _]) = this.offerItem(key, value)

	def offer(key: String, value: mutable.Map[String, _]) = this.offerItem(key, value)

	def offer(key: String, value: JsonEnum) = this.offerItem(key, value)

	def offer(key: String, value: JsonModel) = this.offerItem(key, value)

	def offer(key: String, value: Option[_]) = this.offerItem(key, value)

	def offer(key: String, value: Null) = this.offerItem(key, value)

	def offer(key: String, value: JsonType) = this.offerItem(key, value)

	protected def offerItem[V](key: String, value: V): Option[V] = {
		if (key == null) throw new IllegalArgumentException("JSONMap.offer -> Key is null")
		if (key.isEmpty) throw new IllegalArgumentException("JSONMap.offer -> Key is empty")


		this.has(key) match {
			case true => underlying.get(key).map {
				element => element.value.asInstanceOf[V]
			}
			case false =>
				underlying.put(key, JsonType(value))
				None
		}
	}


	def put(key: String, value: Boolean) = this.putItem(key, value)

	def put(key: String, value: Byte) = this.putItem(key, value)

	def put(key: String, value: Short) = this.putItem(key, value)

	def put(key: String, value: Int) = this.putItem(key, value)

	def put(key: String, value: Long) = this.putItem(key, value)

	def put(key: String, value: Float) = this.putItem(key, value)

	def put(key: String, value: Double) = this.putItem(key, value)

	def put(key: String, value: String) = this.putItem(key, value)

	def put(key: String, value: Date) = this.putItem(key, value)

	def put(key: String, value: UUID) = this.putItem(key, value)

	def put(key: String, value: Array[_]) = this.putItem(key, value)

	def put(key: String, value: Seq[_]) = this.putItem(key, value)

	def put(key: String, value: Map[String, _]) = this.putItem(key, value)

	def put(key: String, value: mutable.Map[String, _]) = this.putItem(key, value)

	def put(key: String, value: JsonEnum) = this.putItem(key, value)

	def put(key: String, value: JsonModel) = this.putItem(key, value)

	def put(key: String, value: Option[_]) = this.putItem(key, value)

	def put(key: String, value: Null) = this.putItem(key, value)

	def put(key: String, value: JsonType) = this.putItem(key, value)

	protected def putItem[V](key: String, value: V) = {
		if (key == null) throw new IllegalArgumentException("JSONMap.put -> Key is null")
		if (key.isEmpty) throw new IllegalArgumentException("JSONMap.put -> Key is empty")

		underlying.put(key, JsonType(value))
	}


	override def size = underlying.size

	override def toList = underlying.toList

	def toMap = underlying.toMap

	override def toStream = underlying.toStream

	override def toString = this.toString(":")

	def toString(mapSep: String) = {
		if (this.isEmpty) {
			"{}"
		}

		else {
			val builder = new StringBuilder("{")
			val entries = this.iterator

			JsonObject.buildString(entries.next(), mapSep, builder)

			while (entries.hasNext) {
				builder.append(",")
				JsonObject.buildString(entries.next(), mapSep, builder)
			}

			builder.append("}").toString()
		}
	}

	def update(key: String, value: Boolean) = this.updateItem(key, value)

	def update(key: String, value: Byte) = this.updateItem(key, value)

	def update(key: String, value: Short) = this.updateItem(key, value)

	def update(key: String, value: Int) = this.updateItem(key, value)

	def update(key: String, value: Long) = this.updateItem(key, value)

	def update(key: String, value: Float) = this.updateItem(key, value)

	def update(key: String, value: Double) = this.updateItem(key, value)

	def update(key: String, value: String) = this.updateItem(key, value)

	def update(key: String, value: Date) = this.updateItem(key, value)

	def update(key: String, value: UUID) = this.updateItem(key, value)

	def update(key: String, value: Array[_]) = this.updateItem(key, value)

	def update(key: String, value: Seq[_]) = this.updateItem(key, value)

	def update(key: String, value: Map[String, _]) = this.updateItem(key, value)

	def update(key: String, value: JsonEnum) = this.updateItem(key, value)

	def update(key: String, value: JsonModel) = this.updateItem(key, value)

	def update(key: String, value: Option[_]) = this.updateItem(key, value)

	def update(key: String, value: Null) = this.updateItem(key, value)

	def update(key: String, value: JsonType) = this.updateItem(key, value)

	protected def updateItem[V](key: String, value: V) = {
		if (key == null) throw new IllegalArgumentException("JSONMap.update -> Key is null")
		if (key.isEmpty) throw new IllegalArgumentException("JSONMap.update -> Key is empty")

		underlying.update(key, JsonType(value))
	}

	override def value = this
}


object JsonObject {
	def apply() = new JsonObject(new mutable.LinkedHashMap[String, JsonType]())

	def apply(map: Map[String, _]) = new JsonObject(map)

	def apply(map: mutable.LinkedHashMap[String, _]) = {
		new JsonObject(map.foldLeft(new mutable.LinkedHashMap[String, JsonType]) { (newMap, kv) =>
			newMap += (kv._1 -> JsonType(kv._2))
		})
	}

	def apply(kvPairs: (String, _)*) = new JsonObject(kvPairs)

	def apply(string: String) = JsonParser.parse(string).asObject

	def buildString(kv: (String, JsonType), mapSep: String, builder: StringBuilder) = {
		kv match {
			case (key, value) => builder.append(Json.quote(key)).append(mapSep).append(value.toString)
		}
	}
}
