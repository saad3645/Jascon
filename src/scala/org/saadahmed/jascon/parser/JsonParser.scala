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
package org.saadahmed.jascon.parser

import org.saadahmed.jascon._


/**
 * @author Saad Ahmed
 * @version 0.1 2014/03/15
 */
object JsonParser {

	// ^\s*$
	val EMPTY_REGEX = "^\\s*$".r

	// ^\s*\{((.|\n)*)\}\s*$
	val JSON_OBJECT_ROOT_REGEX = "^\\s*\\{((.|\\n)*)\\}\\s*$".r

	// ^\s*\[((.|\n)*)\]\s*$
	val JSON_ARRAY_ROOT_REGEX = "^\\s*\\[((.|\\n)*)\\]\\s*$".r

	// ^\s*"((?:[^\\"]|\\'|\\"|\\\\|\\\/|\\b|\\f|\\n|\\r|\\t)+)"\s*:\s*(true|false|null|-?\d+(\.\d+)?([eE]-?\d+)?|"(?:[^\\"]|\\'|\\"|\\\\|\\\/|\\b|\\f|\\n|\\r|\\t)*"|\{(.|\n)*\}|\[(.|\n)*\])\s*(,\s*([^\s](.|\n)*))?$
	val JSON_OBJECT_CONS_REGEX = "^\\s*\"((?:[^\\\\\"]|\\\\'|\\\\\"|\\\\\\\\|\\\\\\/|\\\\b|\\\\f|\\\\n|\\\\r|\\\\t)+)\"\\s*:\\s*(true|false|null|-?\\d+(\\.\\d+)?([eE]-?\\d+)?|\"(?:[^\\\\\"]|\\\\'|\\\\\"|\\\\\\\\|\\\\\\/|\\\\b|\\\\f|\\\\n|\\\\r|\\\\t)*\"|\\{(.|\\n)*\\}|\\[(.|\\n)*\\])\\s*(,\\s*([^\\s](.|\\n)*))?$".r

	// ^\s*(true|false|null|-?\d+(\.\d+)?([eE]-?\d+)?|"(?:[^\\"]|\\'|\\"|\\\\|\\\/|\\b|\\f|\\n|\\r|\\t)*"|\{(.|\n)*\}|\[(.|\n)*\])\s*(,\s*([^\s](.|\n)*))?$
	val JSON_ARRAY_CONS_REGEX = "^\\s*(true|false|null|-?\\d+(\\.\\d+)?([eE]-?\\d+)?|\"(?:[^\\\\\"]|\\\\'|\\\\\"|\\\\\\\\|\\\\\\/|\\\\b|\\\\f|\\\\n|\\\\r|\\\\t)*\"|\\{(.|\\n)*\\}|\\[(.|\\n)*\\])\\s*(,\\s*([^\\s](.|\\n)*))?$".r

	// ^(-?\d+(\.\d+)?([eE]-?\d+)?)$
	val JSON_NUMBER_REGEX = "^(-?\\d+(\\.\\d+)?([eE]-?\\d+)?)$".r

	// ^"((?:[^\\"]|\\'|\\"|\\\\|\\\/|\\b|\\f|\\n|\\r|\\t)*)"$
	val JSON_STRING_REGEX = "^\"((?:[^\\\\\"]|\\\\'|\\\\\"|\\\\\\\\|\\\\\\/|\\\\b|\\\\f|\\\\n|\\\\r|\\\\t)*)\"$".r



	def parse(string: String): JsonType = string match {
		case "true" => JsonValue.TRUE
		case "false" => JsonValue.FALSE
		case "null" => JsonValue.NULL
		case JSON_NUMBER_REGEX(s, _, _) => JsonNumber(s)
		case JSON_STRING_REGEX(s) => JsonString(decodeString(s))
		case JSON_OBJECT_ROOT_REGEX(data, _) => parse(data, JsonObject())
		case JSON_ARRAY_ROOT_REGEX(data, _) => parse(data, JsonArray())
		case _ => throw JsonParseException(string)
	}

	def parse(string: String, obj: JsonObject): JsonType = string match {
		case (null | EMPTY_REGEX()) => obj
		case JSON_OBJECT_CONS_REGEX(key, value, _, _, _, _, _, tail, _) =>
			obj += (decodeString(key), parse(value))
			parse(tail, obj)
		case _ => throw JsonParseException(string)
	}

	def parse(string: String, array: JsonArray): JsonType = string match {
		case (null | EMPTY_REGEX()) => array
		case JSON_ARRAY_CONS_REGEX(element, _, _, _, _, _, tail, _) =>
			array insert parse(element)
			parse(tail, array)
		case _ => throw JsonParseException(string)
	}

	def decodeString(s: String) = {
		val itr = s.iterator
		val builder = new StringBuilder()
		while (itr.hasNext) {
			val c = itr.next()
			if (c == '\\') {
				if (itr.hasNext) {
					itr.next() match {
						case '\'' => builder.append("'")
						case '"' => builder.append("\"")
						case '\\' => builder.append("\\")
						case '/' => builder.append("/")
						case 'b' => builder.append("\b")
						case 'f' => builder.append("\f")
						case 'n' => builder.append("\n")
						case 'r' => builder.append("\r")
						case 't' => builder.append("\t")
						case _ => throw JsonParseException(s)
					}
				}
				else {
					throw JsonParseException(s)
				}
			}
			else {
				builder.append(c)
			}
		}
		builder.toString()
	}

}
