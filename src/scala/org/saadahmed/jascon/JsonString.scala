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
class JsonString(string: String) extends JsonValue {
	override type T = String
	override protected val underlying = string


	override def copy: JsonString = new JsonString(this.value)


	override def equals(that: Any) = {
		that != null && that.isInstanceOf[JsonString] && this.value.equals(that.asInstanceOf[JsonString].value)
	}

	override def toString = Json.quote(underlying)

	override def value = underlying
}


object JsonString {
	def apply(value: String) = new JsonString(value)
}
