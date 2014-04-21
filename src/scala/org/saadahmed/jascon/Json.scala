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

import org.saadahmed.jascon.parser.JsonParser

/**
 * @author Saad Ahmed
 * @version 0.1 2014/02/24
 */
object Json {

	def encodeString(s : String) = s.map {
			case '"'  => "\\\""
			case '\\' => "\\\\"
			case '\b' => "\\b"
			case '\f' => "\\f"
			case '\n' => "\\n"
			case '\r' => "\\r"
			case '\t' => "\\t"
			case c => c
	}.mkString

	def parse(source: String) = JsonParser.parse(source)

	def quote(s: String) = "\"" + encodeString(s) + "\""

	def stringify(array: Array[_]) = JsonArray(array).toString

	def stringify(sequence: Seq[_]) = JsonArray(sequence).toString

	def stringify(enum: JsonEnum) = enum.toJson.toString

	def stringify(obj: JsonModel) = obj.toJson.toString

}
